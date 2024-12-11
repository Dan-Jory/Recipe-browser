import org.example.Main;
import org.example.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import nl.altindag.log.LogCaptor;

import java.util.List;

@SpringBootTest(classes = Main.class)
public class ControllerTest
{
    @Autowired
    private RecipeRepository recipeRepository;
    @Test
    public void testQuery() throws InterruptedException {

        try
        {
            //Had to import a new library logCaptor + relevant dependency to read the logs to compare
            LogCaptor logCaptor = LogCaptor.forName("org.hibernate.SQL");
            recipeRepository.searchRecipesByIngredients(List.of("Beef", "Spaghetti", "Tomato"));

            String expectedResult = "select r1_0.recipe_id,r1_0.title,r1_0.link from recipes r1_0 join recipe_ingredients ri1_0 on r1_0.recipe_id=ri1_0.recipe_id join ingredients i1_0 on ri1_0.ingredient_id=i1_0.ingredient_id where lower(i1_0.name) in (?,?,?) group by r1_0.title,r1_0.link,r1_0.recipe_id order by count(distinct i1_0.ingredient_id) desc";
            boolean queryCheck = logCaptor.getLogs().stream().anyMatch(log -> log.contains(expectedResult));

            assertTrue(queryCheck, "No match in the logs");
        }
        catch(Exception ignored)
        {

        }

    }


}

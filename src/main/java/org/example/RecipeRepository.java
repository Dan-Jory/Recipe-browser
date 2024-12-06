package org.example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface RecipeRepository extends JpaRepository<Recipe, Long>
{
    @Query("SELECT recipe FROM Recipe recipe WHERE recipe.Name LIKE %'ingredient%'")
    List<Recipe> searchIngredient(@Param("ingredient") String ingredients);


}

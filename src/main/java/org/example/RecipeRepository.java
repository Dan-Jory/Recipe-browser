package org.example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface RecipeRepository extends JpaRepository<Recipe, Long>
{
    @Query("SELECT recipe FROM Recipe recipe WHERE LOWER(recipe.Ingredients) ILIKE LOWER(CONCAT(('%'), :ingredient1, '%')) AND " +
            "LOWER(recipe.Ingredients) ILIKE LOWER(CONCAT(('%'), :ingredient2, '%')) AND " +
            "LOWER(recipe.Ingredients) ILIKE LOWER(CONCAT(('%'), :ingredient3, '%'))")

    List<Recipe> searchIngredient(@Param("ingredient1") String ingredient1,
    @Param("ingredient2") String ingredient2,
    @Param("ingredient3") String ingredient3);


}

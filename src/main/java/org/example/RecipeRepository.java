package org.example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface RecipeRepository extends JpaRepository<Recipe, Long>
{
    /*--------------------------------------------------
    This file handles the SQL Query conversion, called in
    Controller.java
    --------------------------------------------------*/
    @Query("SELECT recipe.title FROM Recipe recipe WHERE LOWER(recipe.ingredients) ILIKE LOWER(CONCAT('%', :ingredient1, '%')) AND LOWER(recipe.ingredients) ILIKE LOWER(CONCAT('%', :ingredient2, '%')) AND LOWER(recipe.ingredients) ILIKE LOWER(CONCAT('%', :ingredient3, '%'))")
    List<String> searchIngredient(@Param("ingredient1") String ingredient1,
    @Param("ingredient2") String ingredient2,
    @Param("ingredient3") String ingredient3);


}

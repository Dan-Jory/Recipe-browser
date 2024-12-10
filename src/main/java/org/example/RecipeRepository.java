package org.example;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    /*--------------------------------------------------
    This file handles the SQL Query conversion, called in
    Controller.java
    --------------------------------------------------*/
    @Query("""
    SELECT r.title
    FROM Recipe r
    JOIN RecipeIngredient ri ON r.recipeId = ri.recipe.recipeId
    JOIN Ingredient i ON ri.ingredient.ingredientId = i.ingredientId
    WHERE LOWER(i.name) IN :ingredients
    GROUP BY r.title
    HAVING COUNT(DISTINCT i.ingredientId) >= :minIngredients
""")
    List<String> searchRecipesByIngredients(
        @Param("ingredients") List<String> ingredients, 
        @Param("minIngredients") int minIngredients);
}

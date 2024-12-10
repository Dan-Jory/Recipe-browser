package org.example;
import jakarta.persistence.*;
@Entity
@Table(name = "Recipes")
public class Recipe
{
    


    @Id
    @Column(name = "recipe_id") 
    private long recipeId;

    public long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(long recipeId) {
        this.recipeId = recipeId;
    }

    private String title;
    private String ingredients;


    public String getName()
    {
        return title;
    }

    public void setName(String name)
    {
        this.title = name;
    }

    public String getIngredients()
    {
        return ingredients;
    }
    private void setIngredients(String ingredients)
    {
        this.ingredients = ingredients;
    }
}

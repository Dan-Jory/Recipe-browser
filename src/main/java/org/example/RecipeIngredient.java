package org.example;

import jakarta.persistence.*;
@Entity
@Table(name = "RecipeIngredients")
public class RecipeIngredient {

    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "recipe_id") 
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "ingredient_id") // Foreign key to the Ingredient entity
    private Ingredient ingredient;

    private String quantity; // Optional: To store the quantity of the ingredient

    // Getter and Setter for id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // Getter and Setter for recipe
    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    // Getter and Setter for ingredient
    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    // Getter and Setter for quantity (optional)
    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}

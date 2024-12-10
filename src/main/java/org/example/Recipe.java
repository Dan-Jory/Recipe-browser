package org.example;
import jakarta.persistence.*;
@Entity
@Table(name = "Recipes")
public class Recipe
{
    @Id
    private long recipeid;
    private String title;
    private String ingredients;
    public long getID()
    {
        return recipeid;
    }

    public void setID(long id) //fixed to accept long id
    {
        this.recipeid = id;
    }

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

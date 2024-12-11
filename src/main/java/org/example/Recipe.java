package org.example;
import jakarta.persistence.*;
@Entity
@Table(name = "Recipes")
public class Recipe
{
    
    public Recipe(long id, String title, String link)
    {
        this.recipeId = id;
        this.title = title;
        this.link = link;
    }

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
    private String link;

    public String getLink(){
        return link;
    }
    public void setLink(String name){
        this.link=name;
    }

    public String getName()
    {
        return title;
    }

    public void setName(String name)
    {
        this.title = name;
    }

}

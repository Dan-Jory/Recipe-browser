package org.example;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Recipe
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;
    private String Name;
    @ElementCollection
    private List<String> Ingredients;
    public long getID()
    {
        return ID;
    }

    public void setID(int id)
    {
        this.ID = id;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        this.Name = name;
    }

    public List<String> getIngredients()
    {
        return Ingredients;
    }
    private void setIngredients(List<String> ingredients)
    {
        this.Ingredients = ingredients;
    }
}

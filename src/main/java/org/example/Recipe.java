package org.example;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;

@Entity
public class Recipe
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;
    private String Name;
    private ArrayList<String> Ingredients = new ArrayList<>();

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

    public ArrayList<String> getIngredients()
    {
        return Ingredients;
    }
    private void setIngredients(ArrayList<String> ingredients)
    {
        this.Ingredients = ingredients;
    }
}

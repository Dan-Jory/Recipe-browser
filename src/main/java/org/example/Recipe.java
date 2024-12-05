package org.example;
import java.util.ArrayList;

public class Recipe
{
    private int ID;
    private String Name;
    private ArrayList<String> Ingredients;

    public int getID()
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

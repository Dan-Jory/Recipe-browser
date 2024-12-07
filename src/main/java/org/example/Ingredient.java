package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Ingredient
{
    private int ID;
    private String Name;

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
}

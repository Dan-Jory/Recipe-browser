package org.example;
import org.apache.coyote.Response;
import org.example.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*
-------------------------------------------------------------
This file handles the REST api calls to the database, only
implemented POST as GET PUT AND DELETE aren't used.
-------------------------------------------------------------
*/
@RestController
@RequestMapping("/api")
public class Controller
{
    @Autowired
    private RecipeRepository recipeRepository;

    @PostMapping("/search")
    public ResponseEntity<List<Recipe>> getRecipes(@RequestBody List<String> ingredients)
    {
        try
        {
            List<Recipe> matchingRecipes = new ArrayList<>();
            for (String ingredient : ingredients)
            {
                List<Recipe> recipes = recipeRepository.searchIngredient(ingredient);
                for(Recipe recipe : recipes)
                {
                    if(!matchingRecipes.contains(recipe))
                    {
                        matchingRecipes.add(recipe);
                    }
                }
            }
            if(!matchingRecipes.isEmpty())
            {
                return new ResponseEntity<>(matchingRecipes, HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

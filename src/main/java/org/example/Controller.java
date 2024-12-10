package org.example;
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

Coming back to this later, have now included GET because I
needed to test it was working :sob:
-------------------------------------------------------------
*/
@RestController
@RequestMapping("/api")
public class Controller
{
    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping("/test")
    public String testEndpoint() {
        return "API is working!";
    }

    @PostMapping("/search")
    public ResponseEntity<List<String>> getRecipes(@RequestParam("Ingredients") List<String> Ingredients)
    {
        try
        {
            List<String> matchingRecipes = new ArrayList<>();

            List<String> recipes = recipeRepository.searchRecipesByIngredients(Ingredients, Ingredients.size());

            for (String recipe : recipes)
            {
                if(!matchingRecipes.contains(recipe))
                {
                    matchingRecipes.add(recipe);
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

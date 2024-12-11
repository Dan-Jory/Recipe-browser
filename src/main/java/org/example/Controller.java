package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
-------------------------------------------------------------
This file handles the REST api calls to the database, only
implemented POST as GET PUT AND DELETE aren't used.

Coming back to this later, have now included GET because I
needed to test it was working :sob:
-------------------------------------------------------------
*/
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
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
    public ResponseEntity<List<String>> getRecipes(@RequestBody List<String> Ingredients)
    {
        try
        {
            System.out.println(Ingredients);
            
            List<String> lcIngredients = new ArrayList<>();
            for (String str : Ingredients) {
                lcIngredients.add(str.toLowerCase());
            }

            List<String> matchingRecipes = new ArrayList<>();
            List<Object[]> results = recipeRepository.searchRecipesByIngredients(lcIngredients);
List<Recipe> recipes = results.stream()
    .map(result -> new Recipe((long) result[0], (String) result[1], (String) result[2]))
    .collect(Collectors.toList());
            

            System.out.println("Recipes:");
            for(Recipe recipe: recipes)
            {
                matchingRecipes.add(recipe.getName());
            }
            for(Recipe recipe: recipes)
            {
                matchingRecipes.add(recipe.getLink());
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
            System.out.println("Exception");
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}



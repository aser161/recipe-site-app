package me.aserg.recipesiteapp.controllers;


import me.aserg.recipesiteapp.model.Ingredient;
import me.aserg.recipesiteapp.model.Recipe;
import me.aserg.recipesiteapp.services.IngredientService;
import me.aserg.recipesiteapp.services.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private RecipeService recipeService;
    private IngredientService ingredientService;
    @GetMapping("/add")
    public void add(@RequestParam String name, @RequestParam String cookingTime, @RequestParam byte[] ingredients){

        List<Ingredient> list = new ArrayList<>();
        for (int i:ingredients){
            list.add(ingredientService.get(i));
        }
        Recipe recipe = new Recipe(name, cookingTime,list );
        recipeService.add(recipe);
    }

    @GetMapping
    public Recipe get(@RequestParam int id){
        return recipeService.get(id);
    }

}

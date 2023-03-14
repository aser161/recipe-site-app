package me.aserg.recipesiteapp.controllers;


import me.aserg.recipesiteapp.model.Ingredient;
import me.aserg.recipesiteapp.model.Recipe;
import me.aserg.recipesiteapp.services.IngredientService;
import me.aserg.recipesiteapp.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;

    public RecipeController(RecipeService recipeService, IngredientService ingredientService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }

    @GetMapping("/add")
    public String add(@RequestParam String name, @RequestParam String cookingTime, @RequestParam int[] ingredients){

        List<Ingredient> list = new ArrayList<>();
        for (int i : ingredients){
            list.add(ingredientService.get(i));
        }
        Recipe recipe = new Recipe(name, cookingTime,list );
        recipeService.add(recipe);
        return "Рецепт: " + name + " добавлен";
    }

    @GetMapping("/get")
    public Recipe get(@RequestParam int id){
        return recipeService.get(id);
    }

    @GetMapping("/get/all")
    public String getAll(){
        return recipeService.getAll().toString();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> editRecipe (@RequestBody Recipe recipe, @PathVariable int id){
        Recipe recipe1 = recipeService.get(id);
        if (recipe1 == null){
            return ResponseEntity.notFound().build();
        }
        recipeService.edit(recipe, id);
        return ResponseEntity.ok(recipe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable int id){
        Recipe recipe = recipeService.get(id);
        if (recipe == null){
            return ResponseEntity.notFound().build();
        }
        recipeService.delete(id);
        return ResponseEntity.ok().build();
    }

}

package me.aserg.recipesiteapp.controllers;

import me.aserg.recipesiteapp.model.Ingredient;
import me.aserg.recipesiteapp.services.IngredientService;
import me.aserg.recipesiteapp.services.impl.IngredientServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipe/ingredient")
public class IngredientController {
    IngredientService ingredientService;

    @GetMapping("/add")
    public void add(@RequestParam String name, @RequestParam int count, @RequestParam String measureUnit){
        Ingredient ingredient = new Ingredient(name,count,measureUnit);
        ingredientService.add(ingredient);
    }

    @GetMapping
    public Ingredient get(@RequestParam int id){
       return ingredientService.get(id);
    }

}

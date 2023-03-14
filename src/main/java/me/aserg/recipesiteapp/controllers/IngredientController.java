package me.aserg.recipesiteapp.controllers;

import me.aserg.recipesiteapp.model.Ingredient;
import me.aserg.recipesiteapp.services.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/add")
    public String add(@RequestParam String name, @RequestParam int count, @RequestParam String measureUnit){
        Ingredient ingredient = new Ingredient(name,count,measureUnit);
        ingredientService.add(ingredient);
        return "Ингредиент " + name + " добавлен";
    }

    @GetMapping("/get")
    public String get(@RequestParam int id){
       return ingredientService.get(id).toString();
    }

    @GetMapping("/get/all")
    public String getAll(){
        return ingredientService.getAll().toString();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> editIngredient (@RequestBody Ingredient ingredient, @PathVariable int id){
        Ingredient ingredient1 = ingredientService.get(id);
        if (ingredient1 == null){
            return ResponseEntity.notFound().build();
        }
        ingredientService.edit(ingredient, id);
        return ResponseEntity.ok(ingredient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable int id){
        Ingredient ingredient1 = ingredientService.get(id);
        if (ingredient1 == null){
            return ResponseEntity.notFound().build();
        }
        ingredientService.deleteIngredient(id);
        return ResponseEntity.ok().build();
    }


}

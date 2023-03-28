package me.aserg.recipesiteapp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.aserg.recipesiteapp.model.Ingredient;
import me.aserg.recipesiteapp.services.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Tag(name = "Ингредиенты", description = "Список ингредиентов и их количество")
@RequestMapping("/recipe/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/add")
    @Operation(summary = "Добавление ингридиента",description = "Добавление ингридиента и присвоение ему id")
    public String add(@RequestParam String name, @RequestParam int count, @RequestParam String measureUnit){
        Ingredient ingredient = new Ingredient(name,count,measureUnit);
        ingredientService.add(ingredient);
        return "Ингредиент " + name + " добавлен";
    }

    @GetMapping("/get")
    @Operation(summary = "Поиск ингридиента",description = "Поиск ингридиента по id")
    public Ingredient get(@RequestParam int id){
        return ingredientService.get(id);
    }

    @GetMapping("/get/all")
    @Operation(summary = "Вывод всех ингридиентов",description = "Вывод всех ингридиентов в формате JSON")
    public Map<Integer,Ingredient> getAll(){
        return ingredientService.getAll();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Редактирование ингридиента",description = "Редактирование ингридиента по id")
    public ResponseEntity<Ingredient> editIngredient (@RequestBody Ingredient ingredient, @PathVariable int id){
        Ingredient ingredient1 = ingredientService.get(id);
        if (ingredient1 == null){
            return ResponseEntity.notFound().build();
        }
        ingredientService.edit(ingredient, id);
        return ResponseEntity.ok(ingredient);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление ингридиента",description = "Удаление ингридиента по id")
    public ResponseEntity<Void> deleteIngredient(@PathVariable int id){
        Ingredient ingredient1 = ingredientService.get(id);
        if (ingredient1 == null){
            return ResponseEntity.notFound().build();
        }
        ingredientService.deleteIngredient(id);
        return ResponseEntity.ok().build();
    }


}

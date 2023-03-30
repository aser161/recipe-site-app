package me.aserg.recipesiteapp.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.aserg.recipesiteapp.model.Ingredient;
import me.aserg.recipesiteapp.model.Recipe;
import me.aserg.recipesiteapp.services.IngredientService;
import me.aserg.recipesiteapp.services.RecipeService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@Tag(name = "Рецепты",description = "Список рецептов")
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;

    public RecipeController(RecipeService recipeService, IngredientService ingredientService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }

    @GetMapping("/add")
    @Operation(summary = "Добавление рецепта",description = "Добавление рецепта и присвоение ему id")
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
    @Operation(summary = "Поиск рецепта",description = "Поиск рецепта по id")
    public Recipe get(@RequestParam int id){
        return recipeService.get(id);
    }

    @GetMapping("/get/all")
    @Operation(summary = "Вывод всех рецептов",description = "Вывод всех рецептов в формате JSON")
    public Map<Integer, Recipe> getAll(){
        return recipeService.getAll();
    }

    @GetMapping("/download/list")
    @Operation(summary = "Список всех рецептов", description = "Скачивание файла со списком всех рецептов в формате txt")
    public ResponseEntity<Object>downloadListRecipes(){
        try {
            Path path = recipeService.createListRecipes();
            if (Files.size(path) == 0){
                return ResponseEntity.noContent().build();
            }
            InputStreamResource resource = new InputStreamResource(new FileInputStream(path.toFile()));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .contentLength(Files.size(path))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"recipes.txt\"")
                    .body(resource);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.toString());
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Редактирование рецепта",description = "Редактирование рецепта по id")
    public ResponseEntity<Recipe> editRecipe (@RequestBody Recipe recipe, @PathVariable int id){
        Recipe recipe1 = recipeService.get(id);
        if (recipe1 == null){
            return ResponseEntity.notFound().build();
        }
        recipeService.edit(recipe, id);
        return ResponseEntity.ok(recipe);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление рецепта",description = "Удаление рецепта по id")
    public ResponseEntity<Void> deleteRecipe(@PathVariable int id){
        Recipe recipe = recipeService.get(id);
        if (recipe == null){
            return ResponseEntity.notFound().build();
        }
        recipeService.delete(id);
        return ResponseEntity.ok().build();
    }

}

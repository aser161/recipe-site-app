package me.aserg.recipesiteapp.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.aserg.recipesiteapp.model.Recipe;
import me.aserg.recipesiteapp.services.RecipeService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class RecipeServiceImpl implements RecipeService {

    private static Map<Integer, Recipe> recipes = new LinkedHashMap<>();
    private static int counter = 0;
    private final FileRecipeServiceImpl fileRecipeService;

    public RecipeServiceImpl(FileRecipeServiceImpl fileRecipeService) {
        this.fileRecipeService = fileRecipeService;
    }


    @Override
    public void add(Recipe recipe) {
        recipes.put(counter++, recipe);
        saveToFile();
    }

    @Override
    public Recipe get(int ident) {
        return recipes.get(ident);
    }

    @Override
    public Map<Integer, Recipe> getAll(){
        return recipes;
    }

    @Override
    public void edit(Recipe recipe, int id){
        recipes.put(id,recipe);
        saveToFile();
    }
    @Override
    public void delete(int id){
        recipes.remove(id);
        saveToFile();
    }
    @PostConstruct
    private void init(){
        readFromFile();
    }

    private void saveToFile(){
        try {
            String json = new ObjectMapper().writeValueAsString(recipes);
            fileRecipeService.saveToFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    private void readFromFile(){
        try {
            String json = fileRecipeService.readFromFile();
            recipes = new ObjectMapper().readValue(json, new TypeReference<LinkedHashMap<Integer, Recipe>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}

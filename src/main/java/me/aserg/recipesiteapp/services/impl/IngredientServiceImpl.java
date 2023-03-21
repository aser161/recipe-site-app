package me.aserg.recipesiteapp.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.aserg.recipesiteapp.model.Ingredient;
import me.aserg.recipesiteapp.services.FileService;
import me.aserg.recipesiteapp.services.IngredientService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

@Service
public class IngredientServiceImpl implements IngredientService {

    private static LinkedHashMap<Integer, Ingredient> ingredients = new LinkedHashMap<>();
    private static int counter = 0;

    private final FileService fileService;

    public IngredientServiceImpl(FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    public void add(Ingredient ingredient) {
        ingredients.put(counter++,ingredient);
        saveToFile();
    }

    @Override
    public Ingredient get(int index) {
        return ingredients.get(index);
    }

    @Override
    public Map<Integer,Ingredient> getAll(){
        return ingredients;
    }

    @Override
    public void edit(Ingredient ingredient, int id){
        ingredients.put(id,ingredient);
        saveToFile();
    }
    @Override
    public void deleteIngredient(int id){
        ingredients.remove(id);
    }

    private void saveToFile(){
        try {
            String json = new ObjectMapper().writeValueAsString(ingredients);
            fileService.saveToFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    private void readFromFile(){
        try {
            String json = fileService.readFromFile();
            ingredients = new ObjectMapper().readValue(json, new TypeReference<LinkedHashMap<Integer,Ingredient>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

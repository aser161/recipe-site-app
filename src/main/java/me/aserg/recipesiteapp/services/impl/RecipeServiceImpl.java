package me.aserg.recipesiteapp.services.impl;

import me.aserg.recipesiteapp.model.Recipe;
import me.aserg.recipesiteapp.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class RecipeServiceImpl implements RecipeService {

    private static Map<Integer, Recipe> recipes = new LinkedHashMap<>();
    private static int counter = 0;


    @Override
    public void add(Recipe recipe) {
        recipes.put(counter++, recipe);
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
    }
    @Override
    public void delete(int id){
        recipes.remove(id);
    }

}

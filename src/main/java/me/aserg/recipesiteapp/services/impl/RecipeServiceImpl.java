package me.aserg.recipesiteapp.services.impl;

import me.aserg.recipesiteapp.model.Recipe;
import me.aserg.recipesiteapp.services.RecipeService;

import java.util.LinkedHashMap;
import java.util.Map;

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
}

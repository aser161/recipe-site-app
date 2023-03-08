package me.aserg.recipesiteapp.services.impl;

import me.aserg.recipesiteapp.model.Ingredient;
import me.aserg.recipesiteapp.services.IngredientService;

import java.util.Map;
import java.util.TreeMap;

public class IngredientServiceImpl implements IngredientService {

    private static Map<Integer, Ingredient> ingredients = new TreeMap<>();
    private static int counter = 0;

    @Override
    public void add(Ingredient ingredient) {
        ingredients.put(counter++,ingredient);
    }

    @Override
    public Ingredient get(int ident) {
        return ingredients.get(ident);
    }
}

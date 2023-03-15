package me.aserg.recipesiteapp.services.impl;

import me.aserg.recipesiteapp.model.Ingredient;
import me.aserg.recipesiteapp.services.IngredientService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@Service
public class IngredientServiceImpl implements IngredientService {

    private static Map<Integer, Ingredient> ingredients = new TreeMap<>();
    private static int counter = 0;

    @Override
    public void add(Ingredient ingredient) {
        ingredients.put(counter++,ingredient);
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
    }
    @Override
    public void deleteIngredient(int id){
        ingredients.remove(id);
    }
}

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
    public Ingredient[] getAll(){
        Ingredient [] allIngredient = new Ingredient[counter+1];
        for (int i = 0; i < counter+1; i++) {
            allIngredient[i] = get(i);
        }
        return allIngredient;
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

package me.aserg.recipesiteapp.services;

import me.aserg.recipesiteapp.model.Ingredient;

import java.util.Map;

public interface IngredientService {
    void add(Ingredient ingredient);

    Ingredient get(int index);

    Map<Integer,Ingredient> getAll();

    void edit(Ingredient ingredient, int id);

    void deleteIngredient(int id);
}

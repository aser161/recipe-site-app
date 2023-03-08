package me.aserg.recipesiteapp.services;

import me.aserg.recipesiteapp.model.Ingredient;

public interface IngredientService {
    void add(Ingredient ingredient);
    Ingredient get(int ident);
    }

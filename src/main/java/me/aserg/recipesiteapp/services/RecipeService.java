package me.aserg.recipesiteapp.services;

import me.aserg.recipesiteapp.model.Recipe;

import java.util.Map;

public interface RecipeService {
    void add(Recipe recipe);
    Recipe get(int ident);

    Map<Integer, Recipe> getAll();

    void edit(Recipe recipe, int id);

    void delete(int id);
}

package me.aserg.recipesiteapp.services;

import me.aserg.recipesiteapp.model.Recipe;

public interface RecipeService {
    void add(Recipe recipe);
    Recipe get(int ident);

    Recipe [] getAll();

    void edit(Recipe recipe, int id);

    void delete(int id);
}

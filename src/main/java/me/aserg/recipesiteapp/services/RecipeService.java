package me.aserg.recipesiteapp.services;

import me.aserg.recipesiteapp.model.Recipe;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public interface RecipeService {
    void add(Recipe recipe);
    Recipe get(int ident);

    Map<Integer, Recipe> getAll();

    Path createListRecipes() throws IOException;

    void edit(Recipe recipe, int id);

    void delete(int id);
}

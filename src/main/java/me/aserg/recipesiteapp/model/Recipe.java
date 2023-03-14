package me.aserg.recipesiteapp.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String name;
    private String cookingTime;
    private List<Ingredient> ingredients = new ArrayList<>();

    public Recipe(String name, String cookingTime, List<Ingredient> ingredients) {
        this.name = name;
        this.cookingTime = cookingTime;
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Рецепт: " + name + "Время готовки: " + cookingTime + "Ингредиенты: " + ingredients;
    }
}



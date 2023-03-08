package me.aserg.recipesiteapp.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Recipe {
    String name;
    String cookingTime;
    List<Ingredient> ingredients = new ArrayList<>();
    int id;

    public Recipe(String name, String cookingTime, List<Ingredient> ingredients) {
        this.name = name;
        this.cookingTime = cookingTime;
        this.ingredients = ingredients;
    }
}



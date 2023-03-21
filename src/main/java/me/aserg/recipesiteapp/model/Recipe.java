package me.aserg.recipesiteapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    private String name;
    private String cookingTime;
    private List<Ingredient> ingredients = new ArrayList<>();

    @Override
    public String toString() {
        return "Рецепт: " + name + "Время готовки: " + cookingTime + "Ингредиенты: " + ingredients;
    }
}



package me.aserg.recipesiteapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    private String name;
    private int count;
    private String measureUnit;


    @Override
    public String toString() {
        return "Ингредиент: " + name + " " + count + measureUnit;
    }
}

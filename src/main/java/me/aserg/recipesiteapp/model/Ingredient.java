package me.aserg.recipesiteapp.model;

public class Ingredient {
    private String name;
    private int count;
    private String measureUnit;


    public Ingredient(String name, int count, String measureUnit) {
        this.name = name;
        this.count = count;
        this.measureUnit = measureUnit;
    }

    @Override
    public String toString() {
        return "Ингредиент: " + name + " " + count + measureUnit;
    }
}

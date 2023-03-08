package me.aserg.recipesiteapp.model;

public class Ingredient {
    String name;
    int count;
    String measureUnit;


    public Ingredient(String name, int count, String measureUnit) {
        this.name = name;
        this.count = count;
        this.measureUnit = measureUnit;
    }
}

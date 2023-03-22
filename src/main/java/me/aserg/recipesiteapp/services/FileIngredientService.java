package me.aserg.recipesiteapp.services;

public interface FileIngredientService {
    boolean saveToFile(String json);

    String readFromFile();
}

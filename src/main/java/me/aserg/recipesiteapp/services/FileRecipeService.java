package me.aserg.recipesiteapp.services;

public interface FileRecipeService {

    boolean saveToFile(String json);

    String readFromFile();
}

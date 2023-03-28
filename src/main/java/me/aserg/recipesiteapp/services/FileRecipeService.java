package me.aserg.recipesiteapp.services;

import java.io.File;

public interface FileRecipeService {

    boolean saveToFile(String json);

    String readFromFile();

    File getDataFile();

    boolean cleanDataFile();
}

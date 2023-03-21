package me.aserg.recipesiteapp.services;

public interface FileService {
    boolean saveToFile(String json);

    String readFromFile();
}

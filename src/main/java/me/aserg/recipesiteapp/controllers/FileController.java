package me.aserg.recipesiteapp.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import me.aserg.recipesiteapp.services.FileIngredientService;
import me.aserg.recipesiteapp.services.FileRecipeService;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping("/files")
@Tag(name = "Файл", description = "Работа с файлами")
public class FileController {
    private final FileRecipeService fileRecipeService;

    private final FileIngredientService fileIngredientService;

    public FileController(FileRecipeService fileRecipeService, FileIngredientService fileIngredientService) {
        this.fileRecipeService = fileRecipeService;
        this.fileIngredientService = fileIngredientService;
    }

    @GetMapping("/export")
    public ResponseEntity<InputStreamResource>downloadDataFile() throws FileNotFoundException {
        File file = fileRecipeService.getDataFile();

        if (file.exists()){
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .contentLength(file.length())
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"recipes.json\"")
                    .body(resource);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping(value = "/import/recipe", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void>uploadRecipeDataFile(@RequestParam MultipartFile file){
        fileRecipeService.cleanDataFile();
        File recipeDataFile = fileRecipeService.getDataFile();

        try(FileOutputStream fos = new FileOutputStream(recipeDataFile)) {
            IOUtils.copy(file.getInputStream(),fos);
            return ResponseEntity.ok().build();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

    }

    @PostMapping(value = "/import/ingredient",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void>uploadIngredientDataFile(@RequestParam MultipartFile file){
        fileIngredientService.cleanDataFile();
        File ingredientDataFile = fileIngredientService.getDataFile();

        try(FileOutputStream fos = new FileOutputStream(ingredientDataFile)) {
            IOUtils.copy(file.getInputStream(),fos);
            return ResponseEntity.ok().build();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

    }
}

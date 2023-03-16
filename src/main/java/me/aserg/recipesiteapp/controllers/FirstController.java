package me.aserg.recipesiteapp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Проверочный", description = "Приветствие, описание проекта")
public class FirstController {

    @GetMapping
    @Operation(summary = "Запрос поверки",description = "Проверка первичная")
    public String recipeSite(){
        return " Приложение запущено! ";
    }

    @GetMapping("info")
    @Operation(summary = "Запрос инфо",description = "Инфо о проекте")

    public String printInfo(){
        return  "   имя ученика: Сергей \n" +
                "   название проекта: RecipeSiteApp \n" +
                "   дата создания проекта: 27.02.2023 \n" +
                "   описание проекта: Приложение для сайта рецептов" ;
    }
}

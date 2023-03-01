package me.aserg.recipesiteapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstControllers {

    @GetMapping
    public String recipeSite(){
        return "Приложение запущено";
    }

    @GetMapping("info")
    public String printInfo(){
        return " имя ученика: Сергей \n" +
                "   название проекта: RecipeSiteApp \n" +
                "   дата создания проекта: 27.02.2023 \n" +
                "   описание проекта: Приложение для сайта рецептов" ;
    }
}

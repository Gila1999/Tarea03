package com.example.t03e3.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class pageController {
    @GetMapping({"/", "/index", "/home"})
    public String showHome(@RequestParam Optional<String> usuario, Model model){
        // Obtenemos el año actual
        int currentYear = LocalDate.now().getYear();
        // Pasar el año al modelo
        model.addAttribute("currentYear", currentYear);
        /*String message;
        if (usuario !=null && !usuario.isEmpty()){
            message = "Bienvenido " + usuario + " a nuestra web.";
        } else {
            message = "Bienvenido a nuestra web!";
        }

        model.addAttribute("message", message);
        */
        //Si el parámetro "usuario" está presente, usamos su valor, de lo contrario se muestra un mensaje genérico
        String message = usuario.map(u -> "Bienvenido " + u + " a nuestra web").orElse("Bienvenido a nuestra web.");
        model.addAttribute("message", message);
        return "indexView";
    }

    @GetMapping("/palmares")
    public String showPalmares(Model model) {
        // Lista de títulos
        List<String> titles = new ArrayList<>();
        titles.add("La Liga 45/46");
        titles.add("Copa del Rey 34/35");
        titles.add("Copa del Rey 39/40");
        titles.add("Copa del Rey 48/49");
        titles.add("Copa del Rey 06/07");
        titles.add("Copa del Rey 09/10");
        titles.add("Europa Legue 05/06");
        titles.add("Europa Legue 06/07");
        titles.add("Supercopa de Europa 06/07");
        titles.add("Supercopa de España 07/08");
        titles.add("Europa Legue 13/14");
        titles.add("Europa Legue 14/15");
        titles.add("Europa Legue 13/14");
        titles.add("Europa Legue 19/20");
        titles.add("Europa Legue 22/23");

        //Pasamos la lista de títulos al modelo

        model.addAttribute("titles", titles);
        

        return "palmaresView";
    }

    @GetMapping("/galeria-fotos")
    public String showFotos() {
        return "photogalleryView";
    }
}

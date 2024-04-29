package com.cl1.DAWI_CL1_Grupo5_EdgarPerez.controller;

import com.cl1.DAWI_CL1_Grupo5_EdgarPerez.model.Ejercicio1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class EjercicioController {
    @GetMapping("/home")
    public String home(){
        return "backoffice/home";
    }


    //Primer Ejercicio
    @GetMapping("/ejercicio1")
    public String ejercicio1(@ModelAttribute Ejercicio1 ejercicio1 , Model model){

        int edad = ejercicio1.getEdad();
        int sexo=ejercicio1.getSexo();
        String resultado = "";


        if(edad>=60 & sexo == 0 ){
            resultado = "Usted ya puede jubilarse";
        } else
                if (edad>=54 & sexo == 1) {
                    resultado = "Usted ya puede jubilarse";

        }else {
                    resultado = "Usted no puede jubilarse";
                }
                model.addAttribute("ejercicio1",new Ejercicio1());
                model.addAttribute("resultado",resultado);
                return "backoffice/ejercicio1/ejercicio1";
    }
}

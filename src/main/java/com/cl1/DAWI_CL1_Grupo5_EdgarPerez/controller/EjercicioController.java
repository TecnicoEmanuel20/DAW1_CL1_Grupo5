package com.cl1.DAWI_CL1_Grupo5_EdgarPerez.controller;

import com.cl1.DAWI_CL1_Grupo5_EdgarPerez.model.bd.Ejercicio1;
import com.cl1.DAWI_CL1_Grupo5_EdgarPerez.model.bd.Ejercicio2;
import com.cl1.DAWI_CL1_Grupo5_EdgarPerez.model.bd.Ejercicio3;
import com.cl1.DAWI_CL1_Grupo5_EdgarPerez.model.bd.Ejercicio4;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.min;

@Controller
public class EjercicioController {
    @GetMapping("/home")
    public String home(){
        return "backoffice/home";
    }


    //Primer Ejercicio

    @GetMapping("/ejercicio1")
    public String ejercicio1(Model model){
        model.addAttribute("ejercicio1",new Ejercicio1());
        return "backoffice/ejercicio1/ejercicio1";
    }
    @PostMapping("/ejercicio1")
    public String ejercicio1(@ModelAttribute Ejercicio1 ejercicio1 , Model model){

        int edad = ejercicio1.getEdad();
        int sexo=ejercicio1.getSexo();
        String resultado = "";


        if(edad>=60 & sexo == 1 ){
            resultado = "Usted ya puede jubilarse";
        } else
                if (edad>=54 & sexo == 2) {
                    resultado = "Usted ya puede jubilarse";

        }else {
                    resultado = "Usted no puede jubilarse";
                }

                model.addAttribute("resultado",resultado);
                model.addAttribute("ejercicio1",new Ejercicio1());

                return "backoffice/ejercicio1/ejercicio1";
    }

    //Segundo Ejercicio
    @GetMapping("/ejercicio2")
    public String ejercicio2(Model model){
        model.addAttribute("ejercicio2", new Ejercicio2());
        return "backoffice/ejercicio2/ejercicio2";
    }


    @PostMapping("/ejercicio2")
    public String ejercicio2(@ModelAttribute Ejercicio2 ejercicio2, Model model){

        int nr1 = ejercicio2.getNr1();
        int nr2 = ejercicio2.getNr2();
        int nr3 = ejercicio2.getNr3();
        int nr4 = ejercicio2.getNr4();
        int menor = nr1;
        String resultado  = "El numero menor es " + menor;
        if (nr2 < menor) {
            menor = nr2;
            resultado  = "El numero menor es " + menor;
        }
        if (nr3 < menor) {
            menor = nr3;
            resultado  = "El numero menor es " + menor;
        }
        if (nr4 < menor) {
            menor = nr4;
            resultado  = "El numero menor es " + menor;
        }

        model.addAttribute("resultado",resultado);
        return "backoffice/ejercicio2/ejercicio2";


    }
    //Tercer Ejercicio

    @GetMapping("/ejercicio3")
    public String ejercicio3(Model model){
        model.addAttribute("ejercicio3", new Ejercicio3());
        return "backoffice/ejercicio3/ejercicio3";
    }

    @PostMapping("/ejercicio3")
    public String ejercicio3(@ModelAttribute Ejercicio3 ejercicio3, Model model){
        int materia= ejercicio3.getMateria();;
        double totalCompra = ejercicio3.getMontoCompra();
        int cosmateria = ejercicio3.getCosto();
        if(materia > 5){
            totalCompra = (cosmateria * materia) * 0.9;

        }else{
            totalCompra=cosmateria * materia;
        }
        model.addAttribute("resultado","El Monto a Pagar es: " + String.valueOf(totalCompra) );
        model.addAttribute("ejercicio3", new Ejercicio3());
        return "backoffice/ejercicio3/ejercicio3";
    }

    //Cuarto Ejercicio
    public static int calcularCuadrado(int numero) {
        return numero * numero;
    }
    @GetMapping("/ejercicio4")
    public String ejercicio4(Model model) {
        List<Ejercicio4> resultados = new ArrayList<>();

        for (int i = 15; i <= 70; i++) {
            int cuadrado = i * i;
            double mitad = i / 2.0;
            resultados.add(new Ejercicio4(i, cuadrado, mitad));
        }

        model.addAttribute("resultados", resultados);
        return "backoffice/ejercicio4/ejercicio4";
    }

}

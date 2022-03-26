package com.example.mega;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@Controller
public class MegasenaController{
    @RequestMapping("/megasena")
    public String megasenaPage( Integer n){
        if(n < 6 && n >10){
            return "Informe um número entre 6 e 10";
        }
        ArrayList<Integer> numeros = new ArrayList<Integer>();

        for(int i = 0; i < n; i++){
            Random gerador = new Random();
            numeros.add(gerador.nextInt(60));
        }
        Arrays.sort(numeros.toArray());
        System.out.println(numeros);
        return "megasena";
    }
}

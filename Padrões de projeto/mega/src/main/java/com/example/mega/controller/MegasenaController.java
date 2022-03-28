package com.example.mega.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class MegasenaController{
    @RequestMapping("/")
    public ModelAndView megasenaPage( Integer n){
        if(n < 6 && n >10){
            System.out.println("Informe um número entre 6 e 10");
        }
        ArrayList numeros = new ArrayList();
        Random gerador = new Random();
        for(int i = 0; i < n; i++){
            int nextnumber = gerador.nextInt(60);
            if(numeros.contains(nextnumber))
                i--;
            else
                numeros.add(nextnumber);
        }

        Collections.sort(numeros);
        System.out.println(numeros.toString());
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("numeros", numeros);
        return mv;
    }
}

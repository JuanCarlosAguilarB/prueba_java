package com.example.dev.prueba.controller;


import com.example.dev.prueba.services.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FibonacciController {

    @Autowired
    private FibonacciService fibonacciService;



    @GetMapping("/fibonacci")
    public Object getFibonacciSequence(@RequestParam(required = false) String usuario) {


        // if user is diferent to admin, so the user is not authorized
        if (usuario != null && !usuario.equals("admin")) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Usuario no autorizado");
            return errorResponse;
        }

        List<Integer> fibonacciSequence = fibonacciService.generateFibonacciSequence();

        return fibonacciSequence;
    }


    @PostMapping("/fibonacci")
    public Object getFibonacciSequence(
            @RequestBody(required = false) Map<String, String> body
    ) {
        // Verificar si se proporcionó el parámetro "usuario" en el cuerpo
        if (body != null && body.containsKey("usuario") && !body.get("usuario").equals("admin")) {
            // Usuario no autorizado
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Usuario no autorizado");
            return errorResponse;
        }

        fibonacciService.setTotalValuesFibonacci(Integer.valueOf(body.get("valuesFibonacci")));
        fibonacciService.setFirstValueFibonacci(Integer.valueOf(body.get("firstValueFibonacci")));
        fibonacciService.setSecondValueFibonacci(Integer.valueOf(body.get("secondValueFibonacci")));

        // Generar la secuencia de Fibonacci
        List<Integer> fibonacciSequence = fibonacciService.generateFibonacciSequence();

        return fibonacciSequence;
    }
}

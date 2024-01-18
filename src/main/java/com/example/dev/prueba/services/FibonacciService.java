package com.example.dev.prueba.services;

import com.example.dev.prueba.infraestructure.EmailService;
import com.example.dev.prueba.utils.DateManager;
import com.example.dev.prueba.utils.FibonacciCalculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
@Service
public class FibonacciService {

    private String currentDateFormated;
    private int firstValueFibonacci;

    public void setFirstValueFibonacci(int firstValueFibonacci) {
        this.firstValueFibonacci = firstValueFibonacci;
    }

    public void setSecondValueFibonacci(int secondValueFibonacci) {
        this.secondValueFibonacci = secondValueFibonacci;
    }

    public void setTotalValuesFibonacci(int totalValuesFibonacci) {
        this.totalValuesFibonacci = totalValuesFibonacci;
    }

    private int secondValueFibonacci;

    // for default are two values: firstValueFibonacci and secondValueFibonacci
    private int totalValuesFibonacci = 2;


    @Autowired
    private EmailService emailService;


    private FibonacciService() {
        this.currentDateFormated = DateManager.getCurrentDate();

        int hours = Integer.parseInt(this.currentDateFormated.split(":")[0]);
        int minutes = Integer.parseInt(this.currentDateFormated.split(":")[1]);
        int seconds = Integer.parseInt(this.currentDateFormated.split(":")[2]);

        this.firstValueFibonacci = minutes / 10;
        this.secondValueFibonacci = minutes % 10;
        this.totalValuesFibonacci = seconds + 2;
    }
    public List<Integer> generateFibonacciSequence() {

        List<Integer> result = new ArrayList<>();

        result  = FibonacciCalculate.calculateFibonacciWithSeed(this.firstValueFibonacci, this.secondValueFibonacci, this.totalValuesFibonacci);

        Collections.reverse(result);
        String destinatary = "abjuancarlos.12@gmail.com";
        String subject = "Fibonacci series.";


        StringBuilder contentEmail = new StringBuilder("Fibonacci series :\n\n");

        contentEmail.append("Hi, the follow email was generated at: ").append(this.currentDateFormated).append("\n");
        contentEmail.append("Now, the serie generated is: ").append("\n");
        contentEmail.append(result.toString()).append("\n").append("\n");;
        contentEmail.append("thanks and have a good day ").append("\n");


        emailService.sendEmail(
                destinatary, subject, contentEmail.toString()
        );

        return result;
    }




}

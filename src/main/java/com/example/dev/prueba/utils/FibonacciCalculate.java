package com.example.dev.prueba.utils;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FibonacciCalculate {

    public static List<Integer> calculateFibonacciWithSeed(int seed1, int seed2, int n) {
        List<Integer> fibonacciSeries = new ArrayList<>();

        // add seeds to serie
        fibonacciSeries.add(seed1);
        fibonacciSeries.add(seed2);

        // Calculated serie for n velues
        for (int i = 2; i < n; i++) {
            int nextValue = fibonacciSeries.get(i - 1) + fibonacciSeries.get(i - 2);
            fibonacciSeries.add(nextValue);
        }

        return fibonacciSeries;
    }

}

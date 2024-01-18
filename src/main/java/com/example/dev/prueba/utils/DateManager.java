package com.example.dev.prueba.utils;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateManager {

    // get current date in Colombia
    public static String getCurrentDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss", new Locale("es", "CO"));

        // Obtener la hora actual en Colombia
        LocalTime horaActualColombia = LocalTime.now();

        // Formatear la hora y mostrarla en consola
        String  dateFormated= horaActualColombia.format(formatter);
        System.out.println("Hora actual en Colombia: " + dateFormated);
        return dateFormated;

    }

}

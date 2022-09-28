package com.example;
import java.time.LocalDate;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Period;

public class holamundo {
    public static void main(String[] args) {
        String fecha;
        Scanner leer = new Scanner(System.in);
        System.out.println("Por favor, introduzca su fecha de nacimiento (DD/MM/AAAA): ");
        fecha = leer.nextLine();

        StringTokenizer strtok = new StringTokenizer(fecha, "/");
        int nDatos = strtok.countTokens();
        int[] datos = new int[nDatos];
        int i = 0;

        while(strtok.hasMoreTokens()){
            String str = strtok.nextToken();
            datos[i] = Integer.parseInt(str);
            i++;
        }

        DateTimeFormatter fecdia = DateTimeFormatter.ofPattern("dd");
        int diactual = Integer.parseInt(fecdia.format(LocalDateTime.now()));
        int dias = (2022-datos[2]) * 365 + datos[0] - diactual;
        System.out.println("Ha vivido en total " + dias + " días.");

        DateTimeFormatter fecact = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(fecha, fecact);
        LocalDate fechaAct = LocalDate.now();
        Period tiempo = Period.between(fechaNac, fechaAct);

        System.out.printf("Su edad es: %s años, %s meses, %s dias", tiempo.getYears(), tiempo.getMonths(), tiempo.getDays());
    }
}

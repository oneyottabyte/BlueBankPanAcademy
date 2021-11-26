
package br.com.pan.bluebank.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Utils {

    public static LocalDate toLocalDate(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //convert String to LocalDate
        LocalDate localDate = LocalDate.parse(data, formatter);
        return localDate;
    }
 
}

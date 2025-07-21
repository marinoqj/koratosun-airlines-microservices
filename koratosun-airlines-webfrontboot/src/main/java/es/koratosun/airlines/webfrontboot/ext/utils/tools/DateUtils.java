package es.koratosun.airlines.webfrontboot.ext.utils.tools;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    private DateUtils() {
        throw new IllegalStateException("Clase de Utilidad");
    }

    public static String cambioFormatoFecha(String fechaEntrada, String patronEntrada, String patronSalida) {
        // Formateador para el formato entrada
        DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern(patronEntrada);

        // Parsear la fecha original a LocalDate
        LocalDate fecha = LocalDate.parse(fechaEntrada, formatoEntrada);

        // Formateador para el nuevo formato
        DateTimeFormatter nuevoFormato = DateTimeFormatter.ofPattern(patronSalida);

        // Convertir y formatear la fecha al nuevo formato
        String fechaFormateada = fecha.format(nuevoFormato);

        return fechaFormateada;
    }
}

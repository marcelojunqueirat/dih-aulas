package tech.devinhouse.clamedv2.aula02.statics;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataUtils {

    public static String formatoData = "dd/MM/yyyy";


    public static String formatarData(LocalDate data) {
        return data.format(DateTimeFormatter.ofPattern(formatoData));
    }

}

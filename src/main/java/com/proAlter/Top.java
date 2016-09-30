package com.proAlter;
import com.proAlter.conect.conect_to_bd;
import com.proAlter.conect.select_from_bd;
import com.proAlter.conect.select_from_bd.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;
import java.io.FileWriter;


import java.io.FileWriter;
import java.io.IOException;

public class Top {
    public static void main(String[] args)  {
        select_from_bd sel = new select_from_bd();
            sel.rcd();

//        sel.rcd();

/*        try {
            CSVFormat csvFileFormat1 = CSVFormat.DEFAULT.withRecordSeparator("\n");

            FileWriter writer = new FileWriter("C:\\csv\\rcd.csv");
            CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader("Кол-во;Сумма;КГ;Агент;Дата;Месяц;Тип товара;Клиент;Товар;Группа товара;Адрес факт").withEscape('\\').withQuoteMode(QuoteMode.NONE);
            CSVPrinter csvFilePrinter = new CSVPrinter(writer, csvFileFormat);
            csvFilePrinter.printRecord("1;" + "test;" + a +  " ;"+" ;" +" ;" + d +" ;" +" ;" +" ;" +" ;");

            writer.flush();
            writer.close();
            csvFilePrinter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/



    }
}

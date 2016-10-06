package com.proAlter.conect;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;

import java.io.FileWriter;
import java.io.IOException;

public class csv {

    public void commn() {
        select_from_bd sel = new select_from_bd();
        try {
            CSVFormat csvFileFormat1 = CSVFormat.DEFAULT.withRecordSeparator("\n");

            FileWriter writer = new FileWriter("C:\\csv\\rcd.csv");

            CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader("Кол-во;Сумма;КГ;Агент;Дата;Месяц;Тип товара;Клиент;Товар;Группа товара;Адрес факт").withEscape('\\').withQuoteMode(QuoteMode.NONE);

            CSVPrinter csvFilePrinter = new CSVPrinter(writer, csvFileFormat);


            csvFilePrinter.printRecord(sel.rcd().get(0) + ";" + sel.rcd().get(1) + sel.rcd().get(2) + ";" + sel.rcd().get(3) + ";" + sel.rcd().get(4) + ";" + sel.rcd().get(5) + ";" +
                    sel.rcd().get(6) + ";" + sel.rcd().get(7) + ";" + sel.rcd().get(8) + ";" + sel.rcd().get(9) + ";" + sel.rcd().get(10));

            writer.flush();
            writer.close();
            csvFilePrinter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

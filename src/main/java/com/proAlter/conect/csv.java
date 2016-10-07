package com.proAlter.conect;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class csv {

    public void commn() {
        select_from_bd sel = new select_from_bd();
        try {
            CSVFormat csvFileFormat1 = CSVFormat.DEFAULT.withRecordSeparator("\n");

            FileWriter writer = new FileWriter("C:\\csv\\rcd.csv");

            CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader("Кол-во;Сумма;КГ;Агент;Дата;Клиент;Товар;Адрес факт;Тип товара;Месяц;Группа товара;").withEscape('\\').withQuoteMode(QuoteMode.NONE);

            CSVPrinter csvFilePrinter = new CSVPrinter(writer, csvFileFormat);

            List<Object> line = sel.rcd();
            for (Object o : line) {
                Object[] obj = (Object[]) o;
                csvFilePrinter.printRecord(obj[0] + ";" + obj[1] + ";" + obj[2] + ";" + obj[3] + ";" + obj[4] + ";" + obj[5] + ";" +
                        obj[6] + ";" + obj[7] + ";" + obj[8] + ";" + obj[9] + ";" + obj[10]);

            }
            writer.flush();
            writer.close();
            csvFilePrinter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

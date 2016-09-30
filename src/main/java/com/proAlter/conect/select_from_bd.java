package com.proAlter.conect;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class select_from_bd {


    public String rcd() {
        conect_to_bd res = new conect_to_bd();
        String t700 = "SELECT \n" +
                "    ITEMCOLVO,\n" +
                "    ITEMSUM,\n" +
                "    ITEMVES,\n" +
                "    AGENT,\n" +
                "    DOCDATE,\n" +
                "    UDFUMONTH(DOCDATE)||'.'||UDFUYEAR(DOCDATE) DATEMONTH,\n" +
                "    GoodsGType,\n" +
                "    CLIENTSNAME,\n" +
                "    GOODSSNAME,\n" +
                "    GOODSGROUPSNAME,\n" +
                "    ADDRESSLOCATION\n" +
                "from SPR_SELL2_RCD  order by DOCMONTH";

        try {
            Statement statement = res.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(t700);
            while (resultSet.next()) {
                double ITEMCOLVO = resultSet.getDouble("ITEMCOLVO");
                double ITEMSUM = resultSet.getDouble("ITEMSUM");
                double ITEMVES = resultSet.getDouble("ITEMVES");
                String AGENT = resultSet.getString("AGENT");
                String DOCDATE = resultSet.getString("DOCDATE");
                String DATEMONTH = resultSet.getString("DATEMONTH");
                String GoodsGType = resultSet.getString("GoodsGType");
                String CLIENTSNAME = resultSet.getString("CLIENTSNAME");
                String GOODSSNAME = resultSet.getString("GOODSSNAME");
                String GOODSGROUPSNAME = resultSet.getString("GOODSGROUPSNAME");
                String ADDRESSLOCATION = resultSet.getString("ADDRESSLOCATION");
               /* System.out.println(ITEMCOLVO +" "+
                        ITEMSUM +" "+
                        ITEMVES +" "+
                        AGENT +" "+
                        DOCDATE +" "+
                        DATEMONTH +" "+
                        GoodsGType +" "+
                        CLIENTSNAME +" "+
                        GOODSSNAME +" "+
                        GOODSGROUPSNAME +" "+
                        ADDRESSLOCATION);*/
                try {
                    CSVFormat csvFileFormat1 = CSVFormat.DEFAULT.withRecordSeparator("\n");

                    FileWriter writer = new FileWriter("C:\\csv\\rcd.csv");
                    CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader("Кол-во;Сумма;КГ;Агент;Дата;Месяц;Тип товара;Клиент;Товар;Группа товара;Адрес факт").withEscape('\\').withQuoteMode(QuoteMode.NONE);
                    CSVPrinter csvFilePrinter = new CSVPrinter(writer, csvFileFormat);

                        csvFilePrinter.printRecord(ITEMCOLVO + ITEMSUM + ITEMVES + AGENT + DOCDATE + DATEMONTH +GoodsGType +CLIENTSNAME + GOODSSNAME + GOODSGROUPSNAME + ADDRESSLOCATION);
                        writer.flush();
                        writer.close();
                        csvFilePrinter.close();



                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}

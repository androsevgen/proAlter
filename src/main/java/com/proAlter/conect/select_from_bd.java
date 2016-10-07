package com.proAlter.conect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class select_from_bd {


    public ArrayList<Object> rcd() {
        conect_to_bd res = new conect_to_bd();
        String t700 = "SELECT \n" +
                "    ITEMCOLVO,\n" +
                "    ITEMSUM,\n" +
                "    ITEMVES,\n" +
                "    AGENT,\n" +
                "    DOCDATE,\n" +
                "    DOCMONTH,\n" +
                "    GoodsGType,\n" +
                "    CLIENTSNAME,\n" +
                "    GOODSSNAME,\n" +
                "    GOODSGROUPSNAME,\n" +
                "    ADDRESSLOCATION\n" +
                "from SPR_SELL2_RCD  order by DOCMONTH";

        Object[] object = null;
        ArrayList<Object> line = new ArrayList<>();

        try {

            Statement statement = res.getConnection().createStatement();

            ResultSet resultSet = statement.executeQuery(t700);

            while (resultSet.next()) {
                Object ITEMCOLVO = resultSet.getObject("ITEMCOLVO");//Кол-во
                String ITEMSUM = String.valueOf(resultSet.getString("ITEMSUM"));//Сумма
                Object ITEMVES = resultSet.getObject("ITEMVES");//КГ
                String AGENT = resultSet.getString("AGENT");//Агент
                Object DOCDATE = resultSet.getObject("DOCDATE");//Дата
                String GoodsGType = resultSet.getString("GoodsGType");//Тип товара
                String CLIENTSNAME = resultSet.getString("CLIENTSNAME");//Клиент
                String GOODSSNAME = resultSet.getString("GOODSSNAME");//Товар
                String ADDRESSLOCATION = resultSet.getString("ADDRESSLOCATION");//Адрес факт
                String DATEMONTH = resultSet.getString("DOCMONTH");//Месяц
                String GOODSGROUPSNAME = resultSet.getString("GOODSGROUPSNAME");//Группа товара

                object = new Object[11];

                object[0] = ITEMCOLVO;
                object[1] = ITEMSUM;
                object[2] = ITEMVES;
                object[3] = AGENT;
                object[4] = DOCDATE;
                object[5] = CLIENTSNAME;
                object[6] = GOODSSNAME;
                object[7] = ADDRESSLOCATION;
                object[8] = GoodsGType;
                object[9] = DATEMONTH;
                object[10] = GOODSGROUPSNAME;

                line.add(object);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Object o : line) {
        }
        return line;
    }
}

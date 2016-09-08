package com.proAlter.conect;

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
                "from SPR_SELL2 (\n" +
                " '01.08.2016',\n" +
                " '06.08.2016',\n" +
                " '*',\n" +
                " '2008,2025,3030,4010,4011,5047,5048,560,2060,800,5060,5037,5046,5042,5061,5062,5065,5066,5067,5068,5069,5070,5072,801') order by DOCMONTH";

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
                System.out.println(ITEMCOLVO +
                        ITEMSUM +
                        ITEMVES +
                        AGENT +
                        DOCDATE +
                        DATEMONTH +
                        GoodsGType +
                        CLIENTSNAME +
                        GOODSSNAME +
                        GOODSGROUPSNAME +
                        ADDRESSLOCATION);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}

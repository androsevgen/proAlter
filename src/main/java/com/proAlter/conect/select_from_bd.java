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
                "    UDFUMONTH(DOCDATE)||'.'||UDFUYEAR(DOCDATE) DATEMONTH,\n" +
                "    GoodsGType,\n" +
                "    CLIENTSNAME,\n" +
                "    GOODSSNAME,\n" +
                "    GOODSGROUPSNAME,\n" +
                "    ADDRESSLOCATION\n" +
                "from SPR_SELL2_RCD  order by DOCMONTH";


        ArrayList<Object> object = null;

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

                object = new ArrayList<>();

                object.add(ITEMCOLVO);
                object.add(ITEMSUM);
                object.add(ITEMVES);
                object.add(AGENT);
                object.add(DOCDATE);
                object.add(DATEMONTH);
                object.add(GoodsGType);
                object.add(CLIENTSNAME);
                object.add(GOODSSNAME);
                object.add(GOODSGROUPSNAME);
                object.add(ADDRESSLOCATION);

               //System.out.println(objects);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println(object.size());
        return object;
    }
}

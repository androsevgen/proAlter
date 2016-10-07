package com.proAlter;

import com.proAlter.conect.csv;
import com.proAlter.conect.select_from_bd;


public class Top {
    public static void main(String[] args) {
        select_from_bd sel = new select_from_bd();
        System.out.println(sel.rcd());

        csv c = new csv();
        c.commn();

    }
}

package com.proAlter;

import com.proAlter.conect.conect_to_bd;
import  com.proAlter.conect.select_from_bd;
public class Top {
    public static void main(String[] args)  {
        //conect_to_bd con = new conect_to_bd();
        select_from_bd d900 = new select_from_bd();
        d900.rcd();

    }
}

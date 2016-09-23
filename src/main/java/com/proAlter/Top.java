package com.proAlter;
import com.proAlter.conect.conect_to_bd;
import com.proAlter.conect.select_from_bd;

public class Top {
    public static void main(String[] args)  {
        select_from_bd sel = new select_from_bd();
        sel.rcd();
    }
}

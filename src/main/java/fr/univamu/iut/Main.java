package fr.univamu.iut;


import fr.univamu.iut.ProduitFermier.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

public class Main {
    public static void main(String[] args){
        Miel miel = new Miel( LocalDate.of(2018, Month.NOVEMBER, 22));
        miel.valider();

    }
}

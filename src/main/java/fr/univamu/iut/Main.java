package fr.univamu.iut;


import fr.univamu.iut.ProduitFermier.ProduitApiculteur.Miel;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args){
        Miel miel = new Miel( LocalDate.of(2018, Month.NOVEMBER, 22));
        miel.valider();

    }
}

package fr.univamu.iut;


import fr.univamu.iut.Fermier.ProducteurDeViande;
import fr.univamu.iut.ProduitFermier.ProduitApiculteur.Miel;
import fr.univamu.iut.ProduitFermier.ProduitViande.Vache;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args){
        Miel miel = new Miel( LocalDate.of(2018, Month.NOVEMBER, 22));
        miel.valider();
        ProducteurDeViande producteurDeViande = new ProducteurDeViande();
        System.out.println(producteurDeViande.produitProduit());

    }
}

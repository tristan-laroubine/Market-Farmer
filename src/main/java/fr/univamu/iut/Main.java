package fr.univamu.iut;


import fr.univamu.iut.Fermier.ProducteurDeViande;
import fr.univamu.iut.ProduitFermier.ProduitApiculteur.Miel;
import fr.univamu.iut.ProduitFermier.ProduitViande.Cochon;
import fr.univamu.iut.ProduitFermier.ProduitViande.Vache;
import fr.univamu.iut.UniteDeProduction.UniteDeProductionDeViande;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
//        Miel miel = new Miel( LocalDate.of(2018, Month.NOVEMBER, 22));
//        miel.valider();
        ProducteurDeViande producteurDeViande = new ProducteurDeViande();
        producteurDeViande.setUniteDeProductionDeViande(new UniteDeProductionDeViande());
//        Vache vache = (Vache) producteurDeViande.produitProduit("Vache");
//
//
//
//
//        Cochon cochon = (Cochon) producteurDeViande.produitProduit("Cochon");
//        System.out.println(cochon);

        String[] arg = {"java.lang.String"};
        Vache vache1 = (Vache) producteurDeViande.produitProduit("Vache", arg,"String");
        System.out.println("Vache 1 =>" + vache1);



    }
    static void test(Object... arguments)
    {
        System.out.println(arguments[1]);
    }
}

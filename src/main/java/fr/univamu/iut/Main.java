package fr.univamu.iut;


import fr.univamu.iut.Fermier.ProducteurDeViande;
import fr.univamu.iut.ProduitFermier.ProduitApiculteur.Miel;
import fr.univamu.iut.ProduitFermier.ProduitViande.Cochon;
import fr.univamu.iut.ProduitFermier.ProduitViande.Vache;
import fr.univamu.iut.UniteDeProduction.UniteDeProductionDeViande;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;


public class Main {
    public static void main(String[] args){
//        Miel miel = new Miel( LocalDate.of(2018, Month.NOVEMBER, 22));
//        miel.valider();

        ProducteurDeViande producteurDeViande = new ProducteurDeViande();
        producteurDeViande.setUniteDeProductionDeViande(new UniteDeProductionDeViande());
//        Vache vache = (Vache) producteurDeViande.produitProduit("Vache");
        String url = "";
        String[] arg = {"java.time.LocalDate","java.lang.Integer"};
        String[] arguments = {"java.lang.String","java.time.LocalDate"};
        Cochon cochon = (Cochon) producteurDeViande.produitProduit("fr.univamu.iut.ProduitFermier.ProduitViande.Cochon",arg,LocalDate.of(2018, Month.NOVEMBER, 22),50);
        System.out.println(cochon);
    }

}

package fr.univamu.iut;


import fr.univamu.iut.Acteur.Proprietaire;
import fr.univamu.iut.Marché.MarcheFermier;
import fr.univamu.iut.Producteur.ProducteurDeViande;
import fr.univamu.iut.Producteur.ProducteurLaitier;
import fr.univamu.iut.ProduitFermier.ProduitFermier;
import fr.univamu.iut.ProduitFermier.ProduitViande.Cochon;
import fr.univamu.iut.ProduitFermier.ProduitViande.Vache;
import fr.univamu.iut.UniteDeProduction.UniteDeProductionDeViande;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.Month;


public class Main {
    public static void main(String[] args){
        simulation2();
    }
    public static void simulation1(){
        //        Miel miel = new Miel( LocalDate.of(2018, Month.NOVEMBER, 22));
//        miel.valider();

        ProducteurDeViande producteurDeViande = new ProducteurDeViande();
        producteurDeViande.setUniteDeProductionDeViande(new UniteDeProductionDeViande());

//        Vache vache = (Vache) producteurDeViande.produitProduit("Vache");
        String url = "";
        String[] arg = {"java.time.LocalDate","java.lang.Integer"};
        String[] arguments = {"java.lang.String","java.time.LocalDate"};
//        Cochon cochon = (Cochon) producteurDeViande.produitProduit("fr.univamu.iut.ProduitFermier.ProduitViande.Cochon",arg,LocalDate.of(2018, Month.NOVEMBER, 22),50);
        Cochon cochon = (Cochon) producteurDeViande.produitProduit("fr.univamu.iut.ProduitFermier.ProduitViande.Cochon");
        System.out.println(cochon);


    }
    public static void simulation2(){

        Controleur controleur = new Controleur();
        MarcheFermier marcheFermier = new MarcheFermier("Marche D'AIX EN PROVENCE", "Rhône-Alpes",controleur);

        ProducteurDeViande proprietaire1 = new ProducteurDeViande();
        proprietaire1.setUniteDeProductionDeViande(new UniteDeProductionDeViande());
        Cochon cochon = (Cochon) proprietaire1.produitProduit("fr.univamu.iut.ProduitFermier.ProduitViande.Cochon");
        Vache vache = (Vache) proprietaire1.produitProduit("fr.univamu.iut.ProduitFermier.ProduitViande.Vache");
        vache.setPrix(50);
        marcheFermier.addProduit(cochon);
        marcheFermier.addProduit(vache);

        ProducteurLaitier producteurLaitier = new ProducteurLaitier();
        System.out.println("Bien sur le marche : ");
        for ( ProduitFermier produitFermier : marcheFermier.getProduitsFermier()
        ) {
            System.out.println(produitFermier + " prix =" + produitFermier.getPrix());

        }
        System.out.println("Reserve du proprietaire : ");
        for ( ProduitFermier produitFermier : proprietaire1.getProduitFermiers()
        ) {
            System.out.println(produitFermier);

        }
        System.out.println("Sold du producteurLaitier " + producteurLaitier.getSolde());
        System.out.println("Sold du propriétaire " + proprietaire1.getSolde());
        System.out.println("Produit " + vache + " | prix : "+ vache.getPrix());
        System.out.println("Transaction");

        marcheFermier.transaction(vache,producteurLaitier);
        System.out.println("Sold du producteurLaitier " + producteurLaitier.getSolde());
        System.out.println("Sold du propriétaire " + proprietaire1.getSolde());
        System.out.println("Reserve du proprietaire : ");
        for ( ProduitFermier produitFermier : proprietaire1.getProduitFermiers()
             ) {
            System.out.println(produitFermier);

        }
        System.out.println("Reserve du producteurLaitier : ");
        for ( ProduitFermier produitFermier : producteurLaitier.getProduitFermiers()
        ) {
            System.out.println(produitFermier);
        }

    }

}

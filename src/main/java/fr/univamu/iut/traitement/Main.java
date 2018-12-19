package fr.univamu.iut.traitement;


import fr.univamu.iut.traitement.Acteur.CentraleAchat;
import fr.univamu.iut.traitement.Acteur.Grossiste;
import fr.univamu.iut.traitement.Acteur.Proprietaire;
import fr.univamu.iut.traitement.Marché.MarcheFermier;
import fr.univamu.iut.traitement.Marché.OffreAchat;
import fr.univamu.iut.traitement.Producteur.Producteur;
import fr.univamu.iut.traitement.Producteur.ProducteurDeViande;
import fr.univamu.iut.traitement.Producteur.ProducteurLaitier;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Cochon;
import fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Vache;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProductionDeViande;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args){
        simulation3();
    }
    public static void simulation1(){


        ProducteurDeViande producteurDeViande = new ProducteurDeViande();
        producteurDeViande.setUniteDeProduction(new UniteDeProductionDeViande());

//        Vache vache = (Vache) producteurDeViande.produitProduit("Vache");
        String url = "";
        String[] arg = {"java.time.LocalDate","java.lang.Integer"};
        String[] arguments = {"java.lang.Integer", "java.lang.Integer"};
//        Cochon cochon = (Cochon) producteurDeViande.produitProduit("Cochon",arg,LocalDate.of(2018, Month.NOVEMBER, 22),50);
        System.out.println((Cochon) producteurDeViande.produitProduit("fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Cochon"));


    }
    public static void simulation2(){

        Controleur controleur = new Controleur();
        Historique historique = new Historique();
        MarcheFermier marcheFermier = new MarcheFermier("Marche D'AIX EN PROVENCE", "Rhône-Alpes",controleur,historique);

        Producteur proprietaire1 = new ProducteurDeViande();
        proprietaire1.setUniteDeProduction(new UniteDeProductionDeViande());
        ProduitFermier cochon = (Cochon) proprietaire1.produitProduit("fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Cochon");
        Vache vache = (Vache) proprietaire1.produitProduit("fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Vache");
        proprietaire1.produitProduit("fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Vache");
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
        producteurLaitier.proposerOffre(marcheFermier,vache);
        producteurLaitier.proposerOffre(marcheFermier,cochon);

        marcheFermier.checkOffreAchatVente();
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

        CentraleAchat centraleAchat= new CentraleAchat();
        OffreAchat comparable = new OffreAchat( proprietaire1,cochon);

        OffreAchat comparable2 = new OffreAchat(proprietaire1,vache);
        ArrayList<OffreAchat> offreAchats = new ArrayList<>();
        offreAchats.add(new OffreAchat(proprietaire1,new Cochon(50, (double) 500)));
        offreAchats.add(new OffreAchat(proprietaire1,new Cochon(50, (double) 500)));
        offreAchats.add(new OffreAchat(proprietaire1,new Cochon(50, (double) 500)));
        centraleAchat.choixProduits(offreAchats, "fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Cochon");
        System.out.println(centraleAchat.getOffresChoisies().get(1).getProduitFermier());




    }

    public static void simulation3(){
        Controleur controleur = new Controleur();
        Historique historique = new Historique();
        MarcheFermier marcheFermier = new MarcheFermier("Marche D'AIX EN PROVENCE", "Rhône-Alpes",controleur,historique);

        Proprietaire marc = new Grossiste();
        marc.setPrenom("Marc");
        ProducteurDeViande paul = new ProducteurDeViande(new UniteDeProductionDeViande());
        paul.setPrenom("Paul");
        ProduitFermier cochon = (Cochon) paul.produitProduit("fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Cochon");
        paul.vendre(cochon,marcheFermier);
        System.out.println("Bien sur le marche : ");
        for ( ProduitFermier produitFermier : marcheFermier.getProduitsFermier()
        ) {
            System.out.println(produitFermier + " prix =" + produitFermier.getPrix());

        }
        System.out.println("Reserve du proprietaire Paul : ");
        for ( ProduitFermier produitFermier : paul.getProduitFermiers()
        ) {
            System.out.println(produitFermier);

        }
        marc.proposerOffre(marcheFermier,cochon);
        System.out.println("Transaction");
        marcheFermier.checkOffreAchatVente();
        System.out.println("Reserve du proprietaire Marc : ");
        for ( ProduitFermier produitFermier : marc.getProduitFermiers()
        ) {
            System.out.println(produitFermier);

        }
        historique.afficherTransaction();

    }
}

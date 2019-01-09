package fr.univamu.iut.traitement;


import fr.univamu.iut.traitement.Acteur.CentraleAchat;
import fr.univamu.iut.traitement.Acteur.Grossiste;
import fr.univamu.iut.traitement.Acteur.Proprietaire;
import fr.univamu.iut.traitement.Marche.MarcheFermier;
import fr.univamu.iut.traitement.Marche.OffreAchat;
import fr.univamu.iut.traitement.Producteur.Producteur;
import fr.univamu.iut.traitement.Producteur.ProducteurDeViande;
import fr.univamu.iut.traitement.Producteur.ProducteurLaitier;
import fr.univamu.iut.traitement.ProduitFermier.ProduitApiculteur.Miel;
import fr.univamu.iut.traitement.ProduitFermier.ProduitArboriculteur.Pomme;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Cochon;
import fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Vache;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProductionDeViande;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args){
        test1();
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

        Producteur producteur1 = new ProducteurDeViande();
        producteur1.setUniteDeProduction(new UniteDeProductionDeViande());
        ProduitFermier cochon = (Cochon) producteur1.produitProduit("fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Cochon");
        Vache vache = (Vache) producteur1.produitProduit("fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Vache");
        producteur1.produitProduit("fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Vache");
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
        for ( ProduitFermier produitFermier : producteur1.getProduitFermiers()
        ) {
            System.out.println(produitFermier);

        }
        System.out.println("Sold du producteurLaitier " + producteurLaitier.getSolde());
        System.out.println("Sold du propriétaire " + producteur1.getSolde());
        System.out.println("Produit " + vache + " | prix : "+ vache.getPrix());
        System.out.println("Transaction");
        producteurLaitier.proposerOffre(marcheFermier,vache);
        producteurLaitier.proposerOffre(marcheFermier,cochon);

        marcheFermier.checkOffreAchatVente();
        System.out.println("Sold du producteurLaitier " + producteurLaitier.getSolde());
        System.out.println("Sold du propriétaire " + producteur1.getSolde());
        System.out.println("Reserve du proprietaire : ");
        for ( ProduitFermier produitFermier : producteur1.getProduitFermiers()
             ) {
            System.out.println(produitFermier);

        }
        System.out.println("Reserve du producteurLaitier : ");
        for ( ProduitFermier produitFermier : producteurLaitier.getProduitFermiers()
        ) {
            System.out.println(produitFermier);
        }

        CentraleAchat centraleAchat= new CentraleAchat();
        OffreAchat comparable = new OffreAchat( producteur1,cochon);

        OffreAchat comparable2 = new OffreAchat(producteur1,vache);
        ArrayList<OffreAchat> offreAchats = new ArrayList<>();
        offreAchats.add(new OffreAchat(producteur1,new Cochon(50, (double) 500)));
        offreAchats.add(new OffreAchat(producteur1,new Cochon(50, (double) 500)));
        offreAchats.add(new OffreAchat(producteur1,new Vache(50, (double) 500)));




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


        Proprietaire centraleAchat = new CentraleAchat();
        ArrayList<OffreAchat> offreAchats = new ArrayList<>();
        offreAchats.add(new OffreAchat(centraleAchat,new Cochon(50, (double) 50)));
        offreAchats.add(new OffreAchat(centraleAchat,new Cochon(50, (double) 50)));
        offreAchats.add(new OffreAchat(centraleAchat,new Vache(50, (double) 50)));


        for ( ProduitFermier produitFermier : marcheFermier.getProduitsFermier()
        ) {
            System.out.println(produitFermier + " prix =" + produitFermier.getPrix());

        }

        //centraleAchat.proposerOffre();

        System.out.println("Reserve du proprietaire Paul : ");
        for ( ProduitFermier produitFermier : paul.getProduitFermiers()
        ) {
            System.out.println(produitFermier);

        }
    }
    public static void test1(){
        Pomme pomme = new Pomme(50, (double) 50);
        System.out.println(pomme.getPrix());
        Pomme pomme1 = (Pomme) pomme.clone();
        System.out.println(pomme1.getPrix());
        ProduitFermier produitFermier = new Miel(50,50.0);
        ProduitFermier produitFermier2 = (ProduitFermier) (produitFermier).divideBy(4);
        System.out.println(produitFermier2.getPrix() + "prix ->" + produitFermier2.getPoids());

    }
}

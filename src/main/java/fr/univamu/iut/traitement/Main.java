package fr.univamu.iut.traitement;


import fr.univamu.iut.traitement.Marché.MarcheFermier;
import fr.univamu.iut.traitement.Producteur.ProducteurDeViande;
import fr.univamu.iut.traitement.Producteur.ProducteurLaitier;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Cochon;
import fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Vache;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProductionDeViande;


public class Main {
    public static void main(String[] args){
        simulation2();
    }
    public static void simulation1(){


        ProducteurDeViande producteurDeViande = new ProducteurDeViande();
        producteurDeViande.setUniteDeProductionDeViande(new UniteDeProductionDeViande());

//        Vache vache = (Vache) producteurDeViande.produitProduit("Vache");
        String url = "";
        String[] arg = {"java.time.LocalDate","java.lang.Integer"};
        String[] arguments = {"java.lang.Integer", "java.lang.Integer"};
//        Cochon cochon = (Cochon) producteurDeViande.produitProduit("Cochon",arg,LocalDate.of(2018, Month.NOVEMBER, 22),50);
        Cochon cochon = (Cochon) producteurDeViande.produitProduit("fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Cochon");
        System.out.println(cochon);


    }
    public static void simulation2(){

        Controleur controleur = new Controleur();
        MarcheFermier marcheFermier = new MarcheFermier("Marche D'AIX EN PROVENCE", "Rhône-Alpes",controleur);

        ProducteurDeViande proprietaire1 = new ProducteurDeViande();
        proprietaire1.setUniteDeProductionDeViande(new UniteDeProductionDeViande());
        Cochon cochon = (Cochon) proprietaire1.produitProduit("fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Cochon");
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

    }

    public static void simulation3(){

    }
}

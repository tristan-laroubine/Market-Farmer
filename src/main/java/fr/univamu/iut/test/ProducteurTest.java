package fr.univamu.iut.test;
import static org.junit.Assert.*;

import fr.univamu.iut.traitement.Producteur.*;
import fr.univamu.iut.traitement.ProduitFermier.ProduitArboriculteur.ProduitArboriculteur;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.ProduitFermier.ProduitLaitier.ProduitLaitier;
import fr.univamu.iut.traitement.ProduitFermier.ProduitOrticulteur.ProduitOrticulteur;
import fr.univamu.iut.traitement.ProduitFermier.ProduitViande.ProduitViande;
import fr.univamu.iut.traitement.UniteDeProduction.*;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class ProducteurTest {

    Producteur producteur;
    UniteDeProduction uniteDeProduction;

    @Test
    public final void producteurDeViandeCochonTest(){
        uniteDeProduction = new UniteDeProductionDeViande();
        producteur = new ProducteurDeViande(uniteDeProduction);
        ProduitFermier produitFermier = producteur.produitProduit("fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Cochon");
        assertTrue(produitFermier instanceof ProduitViande);
    }

    @Test
    public final void producteurDeViandeTestVache(){
        uniteDeProduction = new UniteDeProductionDeViande();
        producteur = new ProducteurDeViande(uniteDeProduction);
        ProduitFermier produitFermier = producteur.produitProduit("fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Vache");
        assertTrue(produitFermier instanceof ProduitViande);
    }

    @Test
    public final void producteurOrticulteurTestPommeDeTerre(){
        uniteDeProduction = new UniteDeProductionOrticulteur();
        producteur = new Orticulteur(uniteDeProduction);
        String[] arg = {"java.time.LocalDate","java.lang.Integer", "java.lang.Double"};
        ProduitFermier produitFermier = producteur.produitProduit("fr.univamu.iut.traitement.ProduitFermier.ProduitOrticulteur.PommeDeTerre",arg, LocalDate.of(2019, Month.NOVEMBER, 22),50,50.0);
        assertTrue(produitFermier instanceof ProduitOrticulteur);
    }

    @Test
    public final void producteurLaitierTestLait(){
        uniteDeProduction = new UniteDeProductionLaitier();
        producteur = new ProducteurLaitier(uniteDeProduction);
        String[] arg = {"java.time.LocalDate","java.lang.Integer", "java.lang.Double"};
        ProduitFermier produitFermier = producteur.produitProduit("fr.univamu.iut.traitement.ProduitFermier.ProduitLaitier.Lait",arg, LocalDate.of(2019, Month.NOVEMBER, 22),50,50.0);
        assertTrue(produitFermier instanceof ProduitLaitier);
    }

    @Test
    public final void producteurArboriculteurTestLait(){
        uniteDeProduction = new UniteDeProductionArboriculteur();
        producteur = new Arboriculteur(uniteDeProduction);
        String[] arg = {"java.time.LocalDate","java.lang.Integer", "java.lang.Double"};
        ProduitFermier produitFermier = producteur.produitProduit("fr.univamu.iut.traitement.ProduitFermier.ProduitArboriculteur.Pomme",arg, LocalDate.of(2019, Month.NOVEMBER, 22),50,50.0);

        assertTrue(produitFermier instanceof ProduitArboriculteur);
    }




}

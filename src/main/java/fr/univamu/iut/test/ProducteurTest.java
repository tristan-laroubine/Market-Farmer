package fr.univamu.iut.test;
import static org.junit.Assert.*;

import fr.univamu.iut.traitement.Producteur.Orticulteur;
import fr.univamu.iut.traitement.Producteur.Producteur;
import fr.univamu.iut.traitement.Producteur.ProducteurDeViande;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.ProduitFermier.ProduitOrticulteur.ProduitOrticulteur;
import fr.univamu.iut.traitement.ProduitFermier.ProduitViande.ProduitViande;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProduction;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProductionDeViande;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProductionOrticulteur;
import org.junit.Test;

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
        ProduitFermier produitFermier = producteur.produitProduit("fr.univamu.iut.traitement.ProduitFermier.ProduitOrticulteur.PommeDeTerre");
        assertTrue(produitFermier instanceof ProduitOrticulteur);
    }


}

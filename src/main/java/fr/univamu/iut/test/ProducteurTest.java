package fr.univamu.iut.test;

import fr.univamu.iut.traitement.Producteur.Producteur;
import fr.univamu.iut.traitement.Producteur.ProducteurDeViande;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProduction;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProductionDeViande;
import org.junit.Test;

public class ProducteurTest {

    Producteur producteur;
    UniteDeProduction uniteDeProduction;

    @Test
    public final void producteurDeViandeTest(){
        uniteDeProduction = new UniteDeProductionDeViande();
        producteur = new ProducteurDeViande(uniteDeProduction);
//        ProduitFermier pf = producteur.produitProduit("Vache");
    }
}

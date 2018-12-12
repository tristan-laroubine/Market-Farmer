package fr.univamu.iut.test;

import fr.univamu.iut.traitement.Producteur.Producteur;
import fr.univamu.iut.traitement.Producteur.ProducteurDeViande;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import org.junit.Test;

public class ProducteurTest {

    Producteur producteur;

    @Test
    public final void producteurDeViandeTest(){
//        producteur = new ProducteurDeViande();
        ProduitFermier pf = producteur.produitProduit("Vache");
    }
}

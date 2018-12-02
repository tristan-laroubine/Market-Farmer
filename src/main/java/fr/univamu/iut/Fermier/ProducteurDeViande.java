package fr.univamu.iut.Fermier;

import fr.univamu.iut.UniteDeProduction.UniteDeProductionDeViande;
import fr.univamu.iut.ProduitFermier.ProduitViande.*;
public class ProducteurDeViande {
    UniteDeProductionDeViande uniteDeProductionDeViande;


    public ProduitViande produitProduit(){
        return uniteDeProductionDeViande.produitProduit("Vache");
    }
}

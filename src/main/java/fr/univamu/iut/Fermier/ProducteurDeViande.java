package fr.univamu.iut.Fermier;

import fr.univamu.iut.UniteDeProduction.UniteDeProductionDeViande;
import fr.univamu.iut.ProduitFermier.ProduitViande.*;
public class ProducteurDeViande {


    UniteDeProductionDeViande uniteDeProductionDeViande;


    public ProduitViande produitProduit(String type){
        return uniteDeProductionDeViande.produitProduit(type);
    }

    public ProduitViande produitProduit(String type, String[] arg, Object... arguments){
        return uniteDeProductionDeViande.produitProduit(type,arg, arguments);
    }


    public UniteDeProductionDeViande getUniteDeProductionDeViande() {
        return uniteDeProductionDeViande;
    }

    public void setUniteDeProductionDeViande(UniteDeProductionDeViande uniteDeProductionDeViande) {
        this.uniteDeProductionDeViande = uniteDeProductionDeViande;
    }

}

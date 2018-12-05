package fr.univamu.iut.Producteur;

import fr.univamu.iut.ProduitFermier.ProduitFermier;
import fr.univamu.iut.UniteDeProduction.UniteDeProductionDeViande;

public class ProducteurDeViande extends Producteur {


    private UniteDeProductionDeViande uniteDeProductionDeViande;

    public UniteDeProductionDeViande getUniteDeProductionDeViande() {
        return uniteDeProductionDeViande;
    }

    public void setUniteDeProductionDeViande(UniteDeProductionDeViande uniteDeProductionDeViande) {
        this.uniteDeProductionDeViande = uniteDeProductionDeViande;
    }

    @Override
    public ProduitFermier produitProduit(String type) {
        ProduitFermier produitFermier = uniteDeProductionDeViande.produitProduit(type);
        addProduitFermiers(produitFermier);
        return produitFermier;
    }

    @Override
    public ProduitFermier produitProduit(String type, String[] arg, Object... arguments) {
        ProduitFermier produitFermier = uniteDeProductionDeViande.produitProduit(type,arg,arguments);
        addProduitFermiers(produitFermier);
        return produitFermier;
    }

    @Override
    public String toString() {
        return "ProducteurDeViande";
    }
}

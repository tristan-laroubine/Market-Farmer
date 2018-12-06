package fr.univamu.iut.traitement.Producteur;

import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProductionDeViande;

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
        produitFermier.setProprietaire(this);
        return produitFermier;
    }

    @Override
    public ProduitFermier produitProduit(String type, String[] arg, Object... arguments) {
        ProduitFermier produitFermier = uniteDeProductionDeViande.produitProduit(type,arg,arguments);
        addProduitFermiers(produitFermier);
        produitFermier.setProprietaire(this);
        return produitFermier;
    }

    @Override
    public String toString() {
        return "ProducteurDeViande";
    }
}

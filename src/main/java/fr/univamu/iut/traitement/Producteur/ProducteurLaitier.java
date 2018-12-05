package fr.univamu.iut.traitement.Producteur;

import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProductionLaitier;

public class ProducteurLaitier extends Producteur{
    private UniteDeProductionLaitier uniteDeProductionLaitier;

    public UniteDeProductionLaitier getUniteDeProductionLaitier() {
        return uniteDeProductionLaitier;
    }

    public void setUniteDeProductionLaitier(UniteDeProductionLaitier uniteDeProductionLaitier) {
        this.uniteDeProductionLaitier = uniteDeProductionLaitier;
    }

    @Override
    public ProduitFermier produitProduit(String type) {
        return uniteDeProductionLaitier.produitProduit(type);
    }

    @Override
    public ProduitFermier produitProduit(String type, String[] arg, Object... arguments) {
        return uniteDeProductionLaitier.produitProduit(type,arg,arguments);
    }

    @Override
    public String toString() {
        return "ProducteurLaitier";
    }
}

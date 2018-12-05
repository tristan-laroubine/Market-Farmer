package fr.univamu.iut.Producteur;

import fr.univamu.iut.ProduitFermier.ProduitFermier;

public class ProducteurLaitier extends Producteur{
    private UniteDeProductionDeViande uniteDeProductionDeViande;

    public UniteDeProductionDeViande getUniteDeProductionDeViande() {
        return uniteDeProductionDeViande;
    }

    public void setUniteDeProductionDeViande(UniteDeProductionDeViande uniteDeProductionDeViande) {
        this.uniteDeProductionDeViande = uniteDeProductionDeViande;
    }

    @Override
    public ProduitFermier produitProduit(String type) {
        return uniteDeProductionDeViande.produitProduit(type);
    }

    @Override
    public ProduitFermier produitProduit(String type, String[] arg, Object... arguments) {
        return uniteDeProductionDeViande.produitProduit(type,arg,arguments);
    }
}

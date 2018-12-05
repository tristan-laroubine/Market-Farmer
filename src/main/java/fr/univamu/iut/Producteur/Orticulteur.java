package fr.univamu.iut.Producteur;

import fr.univamu.iut.ProduitFermier.ProduitFermier;
import fr.univamu.iut.UniteDeProduction.UniteDeProductionOrticulteur;

public class Orticulteur extends Producteur{
    private UniteDeProductionOrticulteur uniteDeProductionOrticulteur;

    public UniteDeProductionOrticulteur getUniteDeProductionOrticulteur() {
        return uniteDeProductionOrticulteur;
    }

    public void setUniteDeProductionOrticulteur(UniteDeProductionOrticulteur uniteDeProductionOrticulteur) {
        this.uniteDeProductionOrticulteur = uniteDeProductionOrticulteur;
    }

    @Override
    public ProduitFermier produitProduit(String type) {
        return uniteDeProductionOrticulteur.produitProduit(type);
    }

    @Override
    public ProduitFermier produitProduit(String type, String[] arg, Object... arguments) {
        return uniteDeProductionOrticulteur.produitProduit(type,arg,arguments);
    }
}

package fr.univamu.iut.Producteur;

import fr.univamu.iut.ProduitFermier.ProduitFermier;
import fr.univamu.iut.UniteDeProduction.UniteDeProductionArboriculteur;

public class Arboriculteur extends Producteur {
    private UniteDeProductionArboriculteur uniteDeProductionArboriculteur;

    public UniteDeProductionArboriculteur getUniteDeProductionArboriculteur() {
        return uniteDeProductionArboriculteur;
    }

    public void setUniteDeProductionArboriculteur(UniteDeProductionArboriculteur uniteDeProductionArboriculteur) {
        this.uniteDeProductionArboriculteur = uniteDeProductionArboriculteur;
    }

    @Override
    public ProduitFermier produitProduit(String type) {
        return uniteDeProductionArboriculteur.produitProduit(type);
    }

    @Override
    public ProduitFermier produitProduit(String type, String[] arg, Object... arguments) {
        return uniteDeProductionArboriculteur.produitProduit(type,arg,arguments);
    }
}

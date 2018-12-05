package fr.univamu.iut.Producteur;

import fr.univamu.iut.ProduitFermier.ProduitFermier;
import fr.univamu.iut.UniteDeProduction.UniteDeProductionDeViande;

public class Arboriculteur {
    private UniteDeProductionArboriculteur uniteDeProductionArboriculteur;

    public UUniteDeProductionArboriculteur getUniteDeProductionArboriculteur() {
        return UniteDeProductionArboriculteur;
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

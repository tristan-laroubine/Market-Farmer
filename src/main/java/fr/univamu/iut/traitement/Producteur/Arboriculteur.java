package fr.univamu.iut.traitement.Producteur;

import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProductionArboriculteur;

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

    @Override
    public String toString() {
        return "Arboriculteur";
    }
}

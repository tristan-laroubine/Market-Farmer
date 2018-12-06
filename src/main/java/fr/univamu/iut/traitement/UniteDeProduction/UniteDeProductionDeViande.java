package fr.univamu.iut.traitement.UniteDeProduction;

import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.ProduitFermier.ProduitViande.ProduitViande;

public class UniteDeProductionDeViande extends UniteDeProduction {

    @Override
    public ProduitFermier produitProduit(String type) {
        return (ProduitFermier)(ProduitViande) super.produitProduit(type);
    }

    @Override
    public ProduitFermier produitProduit(String type, String[] args, Object... arguments) {

        return (ProduitFermier)(ProduitViande) super.produitProduit(type, args, arguments);
    }
}

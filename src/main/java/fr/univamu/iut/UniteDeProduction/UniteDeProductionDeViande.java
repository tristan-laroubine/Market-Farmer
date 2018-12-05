package fr.univamu.iut.UniteDeProduction;

import fr.univamu.iut.ProduitFermier.ProduitFermier;
import fr.univamu.iut.ProduitFermier.ProduitViande.ProduitViande;

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

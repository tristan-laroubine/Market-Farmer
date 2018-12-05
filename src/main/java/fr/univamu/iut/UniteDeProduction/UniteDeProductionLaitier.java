package fr.univamu.iut.UniteDeProduction;

import fr.univamu.iut.ProduitFermier.ProduitFermier;
import fr.univamu.iut.ProduitFermier.ProduitLaitier.ProduitLaitier;

public class UniteDeProductionLaitier extends UniteDeProduction{
    @Override
    public ProduitFermier produitProduit(String type) {
        return (ProduitFermier)(ProduitLaitier) super.produitProduit(type);
    }

    @Override
    public ProduitFermier produitProduit(String type, String[] args, Object... arguments) {

        return (ProduitFermier)(ProduitLaitier) super.produitProduit(type, args, arguments);
    }
}

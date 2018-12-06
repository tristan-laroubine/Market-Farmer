package fr.univamu.iut.traitement.UniteDeProduction;

import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.ProduitFermier.ProduitLaitier.ProduitLaitier;

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

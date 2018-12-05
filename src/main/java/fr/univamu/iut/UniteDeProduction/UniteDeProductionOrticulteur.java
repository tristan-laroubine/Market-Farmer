package fr.univamu.iut.UniteDeProduction;

import fr.univamu.iut.ProduitFermier.ProduitFermier;
import fr.univamu.iut.ProduitFermier.ProduitLaitier.ProduitLaitier;
import fr.univamu.iut.ProduitFermier.ProduitOrticulteur.ProduitOrticulteur;

public class UniteDeProductionOrticulteur extends UniteDeProduction{
    @Override
    public ProduitFermier produitProduit(String type) {
        return (ProduitFermier)(ProduitOrticulteur) super.produitProduit(type);
    }

    @Override
    public ProduitFermier produitProduit(String type, String[] args, Object... arguments) {

        return (ProduitFermier)(ProduitOrticulteur) super.produitProduit(type, args, arguments);
    }
}

}

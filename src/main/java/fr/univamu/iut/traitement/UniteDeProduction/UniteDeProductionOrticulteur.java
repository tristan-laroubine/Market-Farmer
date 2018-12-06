package fr.univamu.iut.traitement.UniteDeProduction;

import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.ProduitFermier.ProduitOrticulteur.ProduitOrticulteur;

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



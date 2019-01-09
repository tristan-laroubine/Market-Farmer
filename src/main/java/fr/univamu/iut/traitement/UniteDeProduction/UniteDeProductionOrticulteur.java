package fr.univamu.iut.traitement.UniteDeProduction;

import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.ProduitFermier.ProduitOrticulteur.ProduitOrticulteur;

public class UniteDeProductionOrticulteur extends UniteDeProduction{
    /**
     * Permet de produire un produit fermier d'orticulteur grace à la fonction mère
     * @param type
     * @return ProduitFermier
     */
    @Override
    public ProduitFermier produitProduit(String type) {
        return (ProduitFermier)(ProduitOrticulteur) super.produitProduit(type);
    }

    /**
     * Permet de produire un produit fermier d'orticulteur grace à la fonction mère
     * @param type
     * @param args
     * @param arguments
     * @return ProduitFermier
     */
    @Override
    public ProduitFermier produitProduit(String type, String[] args, Object... arguments) {

        return (ProduitFermier)(ProduitOrticulteur) super.produitProduit(type, args, arguments);
    }
}



package fr.univamu.iut.traitement.UniteDeProduction;

import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.ProduitFermier.ProduitViande.ProduitViande;

/**
 * classe unite de production de viande
 */
public class UniteDeProductionDeViande extends UniteDeProduction {


    /**
     * Permet de produire un produit fermier de viande grace à la fonction mère
     * @param type
     * @return ProduitFermier
     */

    @Override
    public ProduitFermier produitProduit(String type) {
        return (ProduitFermier)(ProduitViande) super.produitProduit(type);
    }

    /**
     * Permet de produire un produit fermier de viande grace à la fonction mère
     * @param type
     * @return ProduitFermier
     */
    @Override
    public ProduitFermier produitProduit(String type, String[] args, Object... arguments) {

        return (ProduitFermier)(ProduitViande) super.produitProduit(type, args, arguments);
    }
}

package fr.univamu.iut.traitement.UniteDeProduction;

import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.ProduitFermier.ProduitLaitier.ProduitLaitier;

/**
 * Classe UniteDeProductionLaitier
 */
public class UniteDeProductionLaitier extends UniteDeProduction{

    /**
     * Permet de produire un produit fermier laitier grace à la fonction mère
     * @param type
     * @return ProduitFermier
     */

    @Override
    public ProduitFermier produitProduit(String type) {
        return (ProduitFermier)(ProduitLaitier) super.produitProduit(type);
    }

    /**
     * Permet de produire un produit fermier laitier grace à la fonction mère
     * @param type
     * @param args
     * @param arguments
     * @return ProduitFermier
     */

    @Override
    public ProduitFermier produitProduit(String type, String[] args, Object... arguments) {

        return (ProduitFermier)(ProduitLaitier) super.produitProduit(type, args, arguments);
    }
}

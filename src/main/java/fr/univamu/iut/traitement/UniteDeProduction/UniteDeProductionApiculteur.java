package fr.univamu.iut.traitement.UniteDeProduction;

import fr.univamu.iut.traitement.ProduitFermier.ProduitApiculteur.ProduitApiculteur;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;

/**
 * Classe UniteDeProductionApiculteur
 */
public class UniteDeProductionApiculteur extends UniteDeProduction{

    /**
     * Permet de produire un produit fermier grace à la fonction mère
     * @param type
     * @return ProduitFermier
     */
    @Override
    public ProduitFermier produitProduit(String type) {
        return (ProduitFermier)(ProduitApiculteur) super.produitProduit(type);
    }

    /**
     * Permet de produire un produit fermier grace à la fonction mère
     * @param type
     * @param args
     * @param arguments
     * @return ProduitFermier
     */
    @Override
    public ProduitFermier produitProduit(String type, String[] args, Object... arguments) {

        return (ProduitFermier)(ProduitApiculteur) super.produitProduit(type, args, arguments);
    }
}

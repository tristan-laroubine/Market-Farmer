package fr.univamu.iut.traitement.UniteDeProduction;


import fr.univamu.iut.traitement.ProduitFermier.ProduitArboriculteur.ProduitArboriculteur;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;

/**
 * classe UniteDeProductionArboriculteur
 */
public class UniteDeProductionArboriculteur extends UniteDeProduction {

    /**
     * Permet de produire un produit fermier d'arboriculteur grace à la fonction mère
     * @param type
     * @return ProduitFermier
     */
    @Override
    public ProduitFermier produitProduit(String type) {
        return (ProduitFermier)(ProduitArboriculteur) super.produitProduit(type);
    }

    /**
     * Permet de produire un produit fermier d'arboriculteur grace à la fonction mère
     * @param type
     * @param args
     * @param arguments
     * @return ProduitFermier
     */
    @Override
    public ProduitFermier produitProduit(String type, String[] args, Object... arguments) {

        return (ProduitFermier)(ProduitArboriculteur) super.produitProduit(type, args, arguments);
    }
}

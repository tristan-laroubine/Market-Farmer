package fr.univamu.iut.UniteDeProduction;


import fr.univamu.iut.ProduitFermier.ProduitArboriculteur.ProduitArboriculteur;
import fr.univamu.iut.ProduitFermier.ProduitFermier;

public class UniteDeProductionArboriculteur extends UniteDeProduction {
    @Override
    public ProduitFermier produitProduit(String type) {
        return (ProduitFermier)(ProduitArboriculteur) super.produitProduit(type);
    }

    @Override
    public ProduitFermier produitProduit(String type, String[] args, Object... arguments) {

        return (ProduitFermier)(ProduitArboriculteur) super.produitProduit(type, args, arguments);
    }
}

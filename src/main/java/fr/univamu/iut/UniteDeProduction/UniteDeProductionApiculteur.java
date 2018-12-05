package fr.univamu.iut.UniteDeProduction;

import fr.univamu.iut.ProduitFermier.ProduitApiculteur.ProduitApiculteur;
import fr.univamu.iut.ProduitFermier.ProduitFermier;

public class UniteDeProductionApiculteur extends UniteDeProduction{
    @Override
    public ProduitFermier produitProduit(String type) {
        return (ProduitFermier)(ProduitApiculteur) super.produitProduit(type);
    }

    @Override
    public ProduitFermier produitProduit(String type, String[] args, Object... arguments) {

        return (ProduitFermier)(ProduitApiculteur) super.produitProduit(type, args, arguments);
    }
}

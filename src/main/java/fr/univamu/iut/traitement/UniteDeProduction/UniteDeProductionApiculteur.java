package fr.univamu.iut.traitement.UniteDeProduction;

import fr.univamu.iut.traitement.ProduitFermier.ProduitApiculteur.ProduitApiculteur;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;

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

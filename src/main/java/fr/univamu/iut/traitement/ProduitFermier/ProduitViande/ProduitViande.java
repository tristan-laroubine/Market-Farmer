package fr.univamu.iut.traitement.ProduitFermier.ProduitViande;

import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;

public abstract class ProduitViande extends ProduitFermier {



    @Override
    public boolean valider() {
        return true;
    }

}

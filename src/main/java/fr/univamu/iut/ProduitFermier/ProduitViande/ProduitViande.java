package fr.univamu.iut.ProduitFermier.ProduitViande;

import fr.univamu.iut.ProduitFermier.ProduitFermier;

import java.time.LocalDate;
import java.util.Date;

public abstract class ProduitViande extends ProduitFermier {



    @Override
    public boolean valider() {
        return true;
    }

}

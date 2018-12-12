package fr.univamu.iut.traitement.Producteur;

import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProduction;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProductionDeViande;

public class ProducteurDeViande extends Producteur {


    public ProducteurDeViande()
    {
    }

    public ProducteurDeViande(UniteDeProduction uniteDeProduction)
    {
        if (uniteDeProduction instanceof UniteDeProductionDeViande )
        {
            this.uniteDeProduction = uniteDeProduction;
        }
        else {
            throw new ClassCastException();
        }
    }

    public void setUniteDeProduction(UniteDeProduction uniteDeProduction) {
        if (uniteDeProduction instanceof UniteDeProductionDeViande )
        {
            this.uniteDeProduction = uniteDeProduction;
        }
        else {
            throw new ClassCastException();
        }
    }



    @Override
    public String toString() {
        return "ProducteurDeViande";
    }
}

package fr.univamu.iut.traitement.Producteur;

import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProduction;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProductionArboriculteur;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProductionLaitier;

public class ProducteurLaitier extends Producteur{

    public ProducteurLaitier()
    {

    }
    public ProducteurLaitier(UniteDeProduction uniteDeProduction)
    {
        if (uniteDeProduction instanceof UniteDeProductionLaitier)
        {
            this.uniteDeProduction = uniteDeProduction;
        }
        else {
            throw new ClassCastException();
        }
    }

    public void setUniteDeProduction(UniteDeProduction uniteDeProduction) {
        if (uniteDeProduction instanceof UniteDeProductionLaitier )
        {
            this.uniteDeProduction = uniteDeProduction;
        }
        else {
            throw new ClassCastException();
        }
    }
    /**
     * Force la conversion en String de la classe
     * @return le nom de la classe est les informations
     */
    @Override
    public String toString() {
        return "ProducteurLaitier";
    }

    @Override
    public double comissionMarchePourcentage(double benefice) {
        return 1;
    }
}

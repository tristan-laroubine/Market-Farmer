package fr.univamu.iut.traitement.Producteur;

import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProduction;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProductionOrticulteur;

public class Orticulteur extends Producteur{


    //CONSTRUCT
    public Orticulteur()
    {

    }
    public Orticulteur(UniteDeProduction uniteDeProduction)
    {
        if (uniteDeProduction instanceof UniteDeProductionOrticulteur)
        {
            this.uniteDeProduction = uniteDeProduction;
        }
        else {
            throw new ClassCastException();
        }
    }

    public void setUniteDeProduction(UniteDeProduction uniteDeProduction) {
        if (uniteDeProduction instanceof UniteDeProductionOrticulteur )
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
        return "Orticulteur";
    }
}

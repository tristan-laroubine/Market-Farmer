package fr.univamu.iut.traitement.Producteur;

import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProduction;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProductionOrticulteur;

public class Orticulteur extends Producteur{

    public Orticulteur()
    {

    }
    public Orticulteur(UniteDeProduction uniteDeProduction)
    {
        if (uniteDeProduction instanceof UniteDeProductionOrticulteur)
        {
            this.uniteDeProduction = uniteDeProduction;
            System.out.println("salut");
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

    @Override
    public String toString() {
        return "Orticulteur";
    }
}

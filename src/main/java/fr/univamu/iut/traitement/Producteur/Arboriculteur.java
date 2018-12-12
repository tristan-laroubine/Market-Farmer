package fr.univamu.iut.traitement.Producteur;

import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProduction;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProductionArboriculteur;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProductionDeViande;

public class Arboriculteur extends Producteur {

    public Arboriculteur(){

    }
    public Arboriculteur(UniteDeProduction uniteDeProduction)
    {
        if (uniteDeProduction instanceof UniteDeProductionArboriculteur)
        {
            this.uniteDeProduction = uniteDeProduction;
        }
        else {
            throw new ClassCastException();
        }
    }

    public void setUniteDeProduction(UniteDeProduction uniteDeProduction) {
        if (uniteDeProduction instanceof UniteDeProductionArboriculteur )
        {
            this.uniteDeProduction = uniteDeProduction;
        }
        else {

            throw new ClassCastException();
        }
    }


    @Override
    public String toString() {
        return "Arboriculteur";
    }
}

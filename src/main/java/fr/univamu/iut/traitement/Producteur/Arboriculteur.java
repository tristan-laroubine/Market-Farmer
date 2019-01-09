package fr.univamu.iut.traitement.Producteur;

import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProduction;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProductionArboriculteur;


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

    /**
     * Change l'unité de production du Producteur
     * @param uniteDeProduction l'unité de production associée
     */
    public void setUniteDeProduction(UniteDeProduction uniteDeProduction) {
        if (uniteDeProduction instanceof UniteDeProductionArboriculteur )
        {
            this.uniteDeProduction = uniteDeProduction;
        }
        else {

            throw new ClassCastException();
        }
    }

    /**
     * Force la conversion en String de la classe
     * @return le nom de la classe et les informations
     */
    @Override
    public String toString() {
        return "Arboriculteur";
    }
}

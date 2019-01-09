package fr.univamu.iut.traitement.Producteur;

import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProduction;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProductionOrticulteur;

public class Orticulteur extends Producteur{


    /**
     * Constructeur defaut vide
     */
    public Orticulteur()
    {

    }

    /**
     * Constructeur Orticulteur à partir d'une unité
     * de Production
     * @param uniteDeProduction
     */
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

    /**
     * setteur Unite de production
     * L'unité de production ne peut que etre une unité
     * de production Orticulteur
     * @param uniteDeProduction
     */
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

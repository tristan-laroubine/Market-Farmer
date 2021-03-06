package fr.univamu.iut.traitement.Producteur;

import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProduction;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProductionDeViande;

public class ProducteurDeViande extends Producteur {


    /**
     * Constructeur par defaut vide
     */
    public ProducteurDeViande()
    {
    }

    /**
     * Constructeur ProducteurDeViande à partir d'une unité de Production
     * de viande
     * @param uniteDeProduction
     */
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

    /**
     * Setteur unité de production
     * @param uniteDeProduction
     */
    public void setUniteDeProduction(UniteDeProduction uniteDeProduction) {
        if (uniteDeProduction instanceof UniteDeProductionDeViande )
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
        return "ProducteurDeViande";
    }

    /**
     * Retourne le pourcentage de la commission
     * @param benefice correspond au prix qui doit être taxé
     * @return
     */
    @Override
    public double comissionMarchePourcentage(double benefice) {
        return 2;
    }
}

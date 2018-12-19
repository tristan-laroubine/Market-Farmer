package fr.univamu.iut.traitement.Acteur;

import fr.univamu.iut.traitement.Marché.Marche;
import fr.univamu.iut.traitement.Producteur.Producteur;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;

import java.util.Collection;

public class Tradeur implements Observateur {


    @Override
    public String toString() {
        return "Tradeur";
    }


    @Override
    public void update(Collection<Producteur> vendeurs, Collection<Proprietaire> acheteurs, Collection<ProduitFermier> produitsFermier) {
        System.out.println("Des éléments du marché on été modifié");
        System.out.println("Les vendeurs : " + "\n" +  vendeurs);
        System.out.println("Les acheteurs : " + "\n" +  acheteurs);
        System.out.println("Les produits fermiers : " + "\n" +  produitsFermier);

    }
}

package fr.univamu.iut.traitement.Acteur;

import fr.univamu.iut.traitement.Marché.Marche;
import fr.univamu.iut.traitement.Marché.MarcheFermier;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.PriorityQueue;

public class Tradeur extends Proprietaire implements Observateur {

    private ArrayList<Proprietaire> proprietaires;

    @Override
    public String toString() {
        return "Tradeur";
    }

    /**
     * fonction update du design pattern observateur qui permet d'avoir toutes les informations du marché
     * @param produitsFermier correspond à la liste des produits du marché
     */
    @Override
    public void update(PriorityQueue<ProduitFermier> produitsFermier) {
        System.out.println("Des éléments du marché on été modifié");
        System.out.println(produitsFermier.peek().getProprietaire().getPrenom());
    }

    /**
     * Acheter pour un autre Proprietaire
     * @param proprietaire Le proprietaire concerner
     * @param type Le Type du produit
     * @param prixMax Le Prix max du produit
     */
    public void acheterPourUnAutre(Proprietaire proprietaire, String type, Double prixMax, Marche marche)
    {
        MarcheFermier marcheFermier = (MarcheFermier) marche;
        if(marcheFermier.isProduitForThatTypeAndMaxPrice(type,prixMax))
        {
            proprietaire.proposerOffre(marcheFermier,marcheFermier.getProduitMoinsChereByTypeAndPrice(type,prixMax));
        }
    }

    /**
     * Ajoute un proprietaire
     * @param proprietaire le proprietaire ajouter
     */
    public void addProprietaire(Proprietaire proprietaire)
    {
        for (Proprietaire pro : proprietaires
        ) {
            if(pro==proprietaire)
            {
                return;
            }

        }
        proprietaires.add(proprietaire);
    }

    /**
     * Commission du marche spécifique au Tradeur
     * @param benefice correspond au prix qui doit être taxé
     * @return le benefice finale
     */
    @Override
    public double comissionMarchePourcentage(double benefice) {
        return benefice*0.05;
    }

    public ArrayList<Proprietaire> getProprietaires() {
        return proprietaires;
    }
}

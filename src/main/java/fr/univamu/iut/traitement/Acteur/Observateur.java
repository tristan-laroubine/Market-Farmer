package fr.univamu.iut.traitement.Acteur;

import fr.univamu.iut.traitement.Marché.Marche;
import fr.univamu.iut.traitement.Producteur.Producteur;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;

import java.util.Collection;

public interface Observateur {

    void update(Collection<Producteur> vendeurs, Collection<Proprietaire> acheteurs, Collection<ProduitFermier> produitsFermier);
}

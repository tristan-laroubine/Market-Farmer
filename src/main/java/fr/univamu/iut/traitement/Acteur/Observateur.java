package fr.univamu.iut.traitement.Acteur;

import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;

import java.util.Collection;
import java.util.PriorityQueue;

public interface Observateur {

    void update(PriorityQueue<ProduitFermier> produitsFermier);
}

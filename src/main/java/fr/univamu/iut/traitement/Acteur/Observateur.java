package fr.univamu.iut.traitement.Acteur;

import fr.univamu.iut.traitement.Marché.Marche;

public interface Observateur {

    void update(Proprietaire p);

    void update(Marche marche);
}

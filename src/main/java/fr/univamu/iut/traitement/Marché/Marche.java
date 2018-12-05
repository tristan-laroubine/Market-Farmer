package fr.univamu.iut.traitement.Marché;

import fr.univamu.iut.traitement.Controleur;

public abstract class Marche {

    String nom;
    String region;
    Controleur controleur;
    public Controleur getControleur() {
        return controleur;
    }
}

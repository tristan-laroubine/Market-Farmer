package fr.univamu.iut.Marché;

import fr.univamu.iut.Controleur;

public abstract class Marche {

    String nom;
    String region;
    Controleur controleur;
    public Controleur getControleur() {
        return controleur;
    }
}

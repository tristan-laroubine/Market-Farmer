package fr.univamu.iut.traitement.Marché;

import fr.univamu.iut.affichage.Controller;
import fr.univamu.iut.traitement.Acteur.Observateur;
import fr.univamu.iut.traitement.Controleur;

public abstract class Marche {

    String nom;
    String region;
    Controleur controleur;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setControleur(Controleur controleur) {
        this.controleur = controleur;
    }

    public Controleur getControleur() {
        return controleur;
    }

    abstract public void ajouterObservateur(Observateur o);
    abstract public void supprimerObservateur(Observateur o);
    abstract public void notifier();
}

package fr.univamu.iut.traitement.Marché;

import fr.univamu.iut.affichage.Controller;
import fr.univamu.iut.traitement.Acteur.Observateur;
import fr.univamu.iut.traitement.Controleur;
import fr.univamu.iut.traitement.Historique;

import java.util.ArrayList;

public abstract class Marche {

    String nom;
    String region;
    Controleur controleur;
    Historique historique;
    ArrayList<Observateur> observateurs;
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

    public void ajouterObservateur(Observateur observateur){
        observateurs.add(observateur);
    }
    public void supprimerObservateur(Observateur observateur){
        observateurs.remove(observateur);
    }
    abstract public void notifier();
}

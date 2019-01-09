package fr.univamu.iut.traitement.Marché;

import fr.univamu.iut.affichage.Controller;
import fr.univamu.iut.traitement.Acteur.Observateur;
import fr.univamu.iut.traitement.Controleur;
import fr.univamu.iut.traitement.Historique;

import java.util.ArrayList;

public abstract class Marche {

    /**
     * nom du marché
     */
    String nom;

    /**
     * region du marché
     */
    String region;

    /**
     * controleur du marché
     */
    Controleur controleur;

    /**
     * historique du marché
     */
    Historique historique;

    /**
     *  liste des observateurs du marché
     */
    ArrayList<Observateur> observateurs = new ArrayList<>();

    /**
     * renvoie le nom du marché
     * @return String
     */
    public String getNom() {
        return nom;
    }


    /**
     * modifie le nom du marché
     * @param nom correspond au nouveau nom du marché
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * renvoie le nom de la region du marché
     * @return String
     */
    public String getRegion() {
        return region;
    }

    /**
     * modifie le nom de la region du marché
     * @param region correspond au nouveau nom de la region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Modifie le controleur
     * @param controleur correspond au nouveau controleur
     */
    public void setControleur(Controleur controleur) {
        this.controleur = controleur;
    }

    /**
     * renvoie le controleur du marché
     * @return Controleur
     */
    public Controleur getControleur() {
        return controleur;
    }

    /**
     * ajoute un observateur à la liste des observateurs du marché
     * @param observateur correspond à l'observateur à ajouter
     */
    public void ajouterObservateur(Observateur observateur){
        observateurs.add(observateur);
    }

    /**
     * Supprime un observateur de la liste des observateurs du marché
     * @param observateur correspond à l'observateur à modifier
     */
    public void supprimerObservateur(Observateur observateur){
        observateurs.remove(observateur);
    }

    /**
     * renvoie l'historique des transactions du marché
     * @return Historique
     */
    public Historique getHistorique() {
        return historique;
    }

    /**
     * notifie les observateurs du marché des nouvelles modificationsg
     */
    abstract public void notifier();
}

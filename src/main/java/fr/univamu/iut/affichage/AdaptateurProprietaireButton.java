package fr.univamu.iut.affichage;

import fr.univamu.iut.traitement.Acteur.Proprietaire;
import javafx.scene.control.Button;


public class AdaptateurProprietaireButton extends Button {
    Proprietaire proprietaire;


    public void setProprietaire(Proprietaire proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Proprietaire getProprietaire() {
        return proprietaire;
    }
}

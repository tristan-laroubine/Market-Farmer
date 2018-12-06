package fr.univamu.iut.affichage;

import fr.univamu.iut.traitement.Controleur;
import javafx.scene.control.Button;

public class AdapteurControllerButton extends Button {
    Controleur controller;

    public Controleur getController() {
        return controller;
    }

    public void setController(Controleur controller) {
        this.controller = controller;
    }
}

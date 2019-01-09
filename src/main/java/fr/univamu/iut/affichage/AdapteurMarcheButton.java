package fr.univamu.iut.affichage;

import fr.univamu.iut.traitement.Marche.Marche;
import javafx.scene.control.Button;

public class AdapteurMarcheButton extends Button {
     Marche marche;

    public Marche getMarche() {
        return marche;
    }

    public void setMarche(Marche marche) {
        this.marche = marche;
    }
}

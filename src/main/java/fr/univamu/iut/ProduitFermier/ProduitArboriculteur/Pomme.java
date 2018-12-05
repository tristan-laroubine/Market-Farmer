package fr.univamu.iut.ProduitFermier.ProduitArboriculteur;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pomme extends ProduitArboriculteur {

    public Pomme(Date datePeremption) {
        this.datePeremption = datePeremption;
    }

    public Pomme(List<String> labels, Date datePeremption, int poids, int prix) {
        this.labels = labels;
        this.datePeremption = datePeremption;
        this.poids = poids;
        this.prix = prix;
    }

    public Pomme(Date datePeremption, int poids) {
        this.datePeremption = datePeremption;
        this.poids = poids;
    }


}

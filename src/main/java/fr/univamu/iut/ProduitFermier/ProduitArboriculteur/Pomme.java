package fr.univamu.iut.ProduitFermier.ProduitArboriculteur;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pomme extends ProduitArboriculteur {

    public Pomme(LocalDate datePeremption) {
        this.datePeremption = datePeremption;
    }

    public Pomme(List<String> labels, LocalDate datePeremption, Integer poids, Integer prix) {
        this.labels = labels;
        this.datePeremption = datePeremption;
        this.poids = poids;
        this.prix = prix;
    }

    public Pomme(LocalDate datePeremption, Integer poids) {
        this.datePeremption = datePeremption;
        this.poids = poids;
    }


}

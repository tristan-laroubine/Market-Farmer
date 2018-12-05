package fr.univamu.iut.ProduitFermier.ProduitOrticulteur;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class PommeDeTerre extends ProduitOrticulteur {

    public PommeDeTerre(){}

    public PommeDeTerre(LocalDate datePeremption) {
        this.datePeremption = datePeremption;
    }

    public PommeDeTerre(List<String> labels, LocalDate datePeremption, int poids, int prix) {
        this.labels = labels;
        this.datePeremption = datePeremption;
        this.poids = poids;
        this.prix = prix;
    }

    public PommeDeTerre(LocalDate datePeremption, int poids) {
        this.datePeremption = datePeremption;
        this.poids = poids;
    }
}

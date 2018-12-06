package fr.univamu.iut.traitement.ProduitFermier.ProduitOrticulteur;

import java.time.LocalDate;
import java.util.List;

public class PommeDeTerre extends ProduitOrticulteur {

    public PommeDeTerre(){}

    public PommeDeTerre(LocalDate datePeremption) {
        this.datePeremption = datePeremption;
    }

    public PommeDeTerre(List<String> labels, LocalDate datePeremption, Integer poids, double prix) {
        this.labels = labels;
        this.datePeremption = datePeremption;
        this.poids = poids;
        this.prix = prix;
    }

    public PommeDeTerre(LocalDate datePeremption, Integer poids) {
        this.datePeremption = datePeremption;
        this.poids = poids;
    }

    @Override
    public String toString() {
        return "PommeDeTerre";
    }
}

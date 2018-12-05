package fr.univamu.iut.ProduitFermier.ProduitOrticulteur;

import java.util.Date;
import java.util.List;

public class PommeDeTerre extends ProduitOrticulteur {

    public PommeDeTerre(){}

    public PommeDeTerre(Date datePeremption) {
        this.datePeremption = datePeremption;
    }

    public PommeDeTerre(List<String> labels, Date datePeremption, int poids, int prix) {
        this.labels = labels;
        this.datePeremption = datePeremption;
        this.poids = poids;
        this.prix = prix;
    }

    public PommeDeTerre(Date datePeremption, int poids) {
        this.datePeremption = datePeremption;
        this.poids = poids;
    }
}

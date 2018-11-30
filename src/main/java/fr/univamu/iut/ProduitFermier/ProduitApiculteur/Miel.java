package fr.univamu.iut.ProduitFermier.ProduitApiculteur;

import fr.univamu.iut.ProduitFermier.ProduitFermier;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Miel extends ProduitApiculteur {


    List<String> labels = new ArrayList<>();
    LocalDate datePeremption;
    int poids;

    public boolean isCertifier() {
        return certifier;
    }

    public void setCertifier(boolean certifier) {
        this.certifier = certifier;
    }

    boolean certifier = false;

    public Miel(LocalDate datePeremption) {
        this.datePeremption = datePeremption;
    }

    public Miel(List<String> labels, LocalDate datePeremption, int poids) {
        this.labels = labels;
        this.datePeremption = datePeremption;
        this.poids = poids;
    }

    public Miel(LocalDate datePeremption, int poids) {
        this.datePeremption = datePeremption;
        this.poids = poids;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public LocalDate getDatePeremption() {
        return datePeremption;
    }

    public void setDatePeremption(LocalDate datePeremption) {
        this.datePeremption = datePeremption;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public void addLabel(String label){
        this.labels.add(label);
    }

    public void removeLabel(String label){
        this.labels.remove(label);
    }

    @Override
    public void valider() {
        if (datePeremption.compareTo(LocalDate.now()) <= 0)
        {
            this.certifier = true;
            System.out.println("Je suis périmé");

        }
        else
        {
            this.certifier = false;
            System.out.println("Je ne suis pas périmé");
        }

    }
}

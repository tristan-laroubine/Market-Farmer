package fr.univamu.iut.ProduitFermier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vache extends ProduitFermier{
    List<String> labels = new ArrayList<>();
    Date datePeremption = new Date();
    int poids;

    public Vache(Date datePeremption) {
        this.datePeremption = datePeremption;
    }

    public Vache(List<String> labels, Date datePeremption, int poids) {
        this.labels = labels;
        this.datePeremption = datePeremption;
        this.poids = poids;
    }

    public Vache(Date datePeremption, int poids) {
        this.datePeremption = datePeremption;
        this.poids = poids;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public Date getDatePeremption() {
        return datePeremption;
    }

    public void setDatePeremption(Date datePeremption) {
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
    public boolean isCertifier() {
        return certifier;
    }

    public void setCertifier(boolean certifier) {
        this.certifier = certifier;
    }

    boolean certifier = false;

    @Override
    void valider() {

    }
}

package fr.univamu.iut.Acteur;

public abstract class Proprietaire {
    protected double solde = 1000;

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }
}

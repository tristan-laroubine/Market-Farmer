package fr.univamu.iut.Acteur;

public abstract class Acheteur extends Proprietaire{

    protected String nom;
    protected double solde;

    public abstract void acheter();

    public abstract void debiter();



}

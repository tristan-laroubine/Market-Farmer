package fr.univamu.iut.exo3;

public class ImprimanteLocale extends Imprimante {
    @Override
    public void imprimer() {
        System.out.println("Je suis une Imprimante Locale");
    }
    @Override
    public String toString() {
        return "imprimanteLocale ";
    }
}

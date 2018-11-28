package fr.univamu.iut.exo3;

public class AppliDomotique {
    public static void main(String[] args) {
        Imprimante imprimante = new ImprimanteLocale();
        imprimante = new Fax(imprimante);
        imprimante = new Photocopieur(imprimante);
        imprimante.imprimer();
    }
}

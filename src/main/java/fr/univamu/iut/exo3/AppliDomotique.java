package fr.univamu.iut.exo3;

public class AppliDomotique {
    public static void main(String[] args) {
        Imprimante imprimante = (new Fax(new Scanner(new ImprimanteLocale())));
        imprimante.imprimer();
    }
}

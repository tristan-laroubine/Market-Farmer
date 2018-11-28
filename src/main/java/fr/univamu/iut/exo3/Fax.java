package fr.univamu.iut.exo3;

public class Fax extends Multifonction {
    public Fax(Imprimante imprimante){
        this.imprimante = imprimante;
    }

    @Override
    void imprimer() {
        imprimante.imprimer();
        System.out.println("La Fonction Fax est activé");
    }
}

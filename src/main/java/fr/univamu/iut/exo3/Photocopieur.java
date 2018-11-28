package fr.univamu.iut.exo3;

public class Photocopieur extends Multifonction {
    Photocopieur(Imprimante imprimante){
        this.imprimante = imprimante;
    }
    @Override
    void imprimer() {
        imprimante.imprimer();
        System.out.println("La fonction Photocopieur est activé");

    }
}

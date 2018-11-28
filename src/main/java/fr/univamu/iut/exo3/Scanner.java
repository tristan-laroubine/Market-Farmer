package fr.univamu.iut.exo3;

public class Scanner extends Multifonction {
    Scanner(Imprimante imprimante){
        this.imprimante = imprimante;
    }
    @Override
    void imprimer() {
        imprimante.imprimer();
        System.out.println("La fonction Scanner est activé");

    }
}

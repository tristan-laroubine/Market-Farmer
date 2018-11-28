package fr.univamu.iut.exo3;

public class Scanner extends Multifonction {
    Scanner(Imprimante imprimante){
        this.imprimante = imprimante;
    }
    @Override
    public void imprimer() {
        imprimante.imprimer();
        System.out.println("La fonction Scanner est activé");

    }

    @Override
    public String toString() {
        return imprimante + ", mode scanner";
    }
}

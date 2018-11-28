package fr.univamu.iut.exo3;

public class Photocopieur extends Multifonction {
    public Photocopieur(Imprimante imprimante){
        this.imprimante = imprimante;
    }
    @Override
    public void imprimer() {
        imprimante.imprimer();
        System.out.println("La fonction Photocopieur est activé");

    }
    @Override
    public String toString() {
        return imprimante + ", mode Photocopieur";
    }
}

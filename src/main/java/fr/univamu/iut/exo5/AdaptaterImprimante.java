package fr.univamu.iut.exo5;

import fr.univamu.iut.exo3.Imprimante;
import fr.univamu.iut.exo4.Connectable;

public class AdaptaterImprimante  implements Connectable{
    private final Imprimante imprimante;

    AdaptaterImprimante(Imprimante imprimante)
    {
        this.imprimante = imprimante;
    }


    @Override
    public void equiper(String gadget) {

    }

    @Override
    public void demarrer() {
        System.out.println("Je démarrer l'imprimante");
        imprimante.imprimer();
    }

    @Override
    public String toString() {
        return String.valueOf(imprimante);
    }
}

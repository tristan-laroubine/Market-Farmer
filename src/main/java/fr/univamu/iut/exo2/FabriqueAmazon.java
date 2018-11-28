package fr.univamu.iut.exo2;

import fr.univamu.iut.exo1.Connectable;

public class FabriqueAmazon extends Fabrique{
    @Override
    void equiperSpe(Connectable connectable) {
        connectable.equiper("le gadget Amazon");
    }
}

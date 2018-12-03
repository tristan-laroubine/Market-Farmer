package fr.univamu.iut.ProduitFermier;

import java.util.List;

public abstract class ProduitFermier {
    public void valider(){
        setCertifier(true);
    }
    public boolean isCertifier() {
        return certifier;
    }

    public void setCertifier(boolean certifier) {
        this.certifier = certifier;
    }

    boolean certifier = false;

}

package fr.univamu.iut.ProduitFermier;

public abstract class ProduitFermier {
    public boolean valider(){
        return true;
    }
    protected  int prix;
    protected  int poids;

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

}

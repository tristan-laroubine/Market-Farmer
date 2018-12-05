package fr.univamu.iut.ProduitFermier.ProduitViande;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cochon extends ProduitViande {

    public Cochon(){

    }

    public Cochon(List<String> labels,  int poids) {
        this.labels = labels;

        this.poids = poids;
    }

    public Cochon(int poids) {

        this.poids = poids;
    }





}

package fr.univamu.iut.ProduitFermier.ProduitApiculteur;

import fr.univamu.iut.ProduitFermier.ProduitFermier;

import java.time.LocalDate;
import java.util.Date;

public abstract class ProduitApiculteur extends ProduitFermier {
    LocalDate datePeremption;

    @Override
    public boolean valider() {
        if (datePeremption.compareTo(LocalDate.now()) <= 0)
        {
            System.out.println("Je suis périmé");
            return false;

        }
        else
        {
            System.out.println("Je ne suis pas périmé");
            return true;
        }

    }

    public Date getDatePeremption() {
        return datePeremption;
    }

    public void setDatePeremption(Date datePeremption) {
        this.datePeremption = datePeremption;
    }
}

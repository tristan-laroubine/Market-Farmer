package fr.univamu.iut.ProduitFermier;

import java.time.LocalDate;
import java.util.Date;

public abstract class ProduitPeremption extends ProduitFermier{
    protected LocalDate datePeremption;

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

    public LocalDate getDatePeremption() {
        return datePeremption;
    }

    public void setDatePeremption(LocalDate datePeremption) {
        this.datePeremption = datePeremption;
    }
}

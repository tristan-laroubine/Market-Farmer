package fr.univamu.iut.traitement.ProduitFermier;

import java.time.LocalDate;

public abstract class ProduitPeremption extends ProduitFermier{
    /**
     * La date de peremption
     */
    protected LocalDate datePeremption;

    /**
     * Si le produit est valide ou non
     * @return vrai ou faux
     */
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

    /**
     * Donne la date de peremption
     * @return la date de péremption
     */
    public LocalDate getDatePeremption() {
        return datePeremption;
    }

    /**
     *Modifie la date de péremption
     * @param datePeremption la nouvelle date de péremption
     */
    public void setDatePeremption(LocalDate datePeremption) {
        this.datePeremption = datePeremption;
    }

    /**
     * Genere une date de peremption
     * @return LocalDate
     */
    protected abstract LocalDate generateDatePeremption();
}

package fr.univamu.iut.traitement;

import java.util.ArrayList;

public class Historique {

    /**
     * Correspond à la liste des transations dans un marché
     */
    private ArrayList<Transaction> transactions = new ArrayList<>();

    /**
     * ajoute une transaction dans l'historique
     * @param transaction correspond à la transaction à ajouter
     */
    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    /**
     * Affiche les transactions du marché
     */
    public void afficherTransaction()
    {
        System.out.println("Historique :");
        for (Transaction transaction : transactions)
        {
            System.out.println(transaction);
        }
    }

    /**
     * renvoie la liste des transactions du marché
     * @return ArrayList<Transaction>
     */
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * Affiche la liste des transation du marché
     * @return String
     */
    @Override
    public String toString() {
        return transactions.toString();
    }
}

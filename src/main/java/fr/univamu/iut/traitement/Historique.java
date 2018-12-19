package fr.univamu.iut.traitement;

import java.util.ArrayList;

public class Historique {
    ArrayList<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    public void afficherTransaction()
    {
        System.out.println("Historique :");
        for (Transaction transaction : transactions)
        {
            System.out.println(transaction);
        }
    }
    @Override
    public String toString() {
        return transactions.toString();
    }
}

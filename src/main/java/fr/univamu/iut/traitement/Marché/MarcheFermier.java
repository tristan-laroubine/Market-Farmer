package fr.univamu.iut.traitement.Marché;

import fr.univamu.iut.traitement.Acteur.Observateur;
import fr.univamu.iut.traitement.Acteur.Proprietaire;
import fr.univamu.iut.traitement.Controleur;
import fr.univamu.iut.traitement.Historique;
import fr.univamu.iut.traitement.Producteur.Producteur;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.Transaction;

import java.util.*;

public class MarcheFermier extends Marche {


    public MarcheFermier()
    {
        super();
    }
    private TreeSet<Producteur> vendeurs = new TreeSet<>();
    private PriorityQueue <Proprietaire>  acheteurs = new PriorityQueue<>();
    private PriorityQueue<ProduitFermier> produitsFermier = new PriorityQueue<>();
    public PriorityQueue<OffreAchat> getOffreAchats() {
        return offreAchats;
    }
    private PriorityQueue<OffreAchat> offreAchats = new PriorityQueue<>();

    public void setOffreAchats(PriorityQueue<OffreAchat> offreAchats) {
        this.offreAchats = offreAchats;
    }

    public MarcheFermier(String nom, String region, Controleur controleur)
    {
        super.nom = nom;
        super.region = region;
        super.controleur = controleur;
    }
    public MarcheFermier(String nom, String region, Controleur controleur, Historique historique)
    {
        super.nom = nom;
        super.region = region;
        super.controleur = controleur;
        super.historique = historique;
    }

    /**
     *
     */
    public void checkOffreAchatVente(){
        for (ProduitFermier produifermier: produitsFermier
             ) {
            if(controleur.choisirAcheteur(offreAchats,produifermier) != null){
                transaction(produifermier,controleur.choisirAcheteur(offreAchats,produifermier).getAcheteur());
                removeOffreToOffreAchats(controleur.choisirAcheteur(offreAchats,produifermier));
                removeProduitFermier(produifermier);
                checkOffreAchatVente();
            }
        }
    }

    /**
     * renvoie true si un produit possède déjà une offre d'achat dans le marché
     * @param produitFermier correspond au produit que l'on veut tester
     * @return boolean
     */

    public boolean isDejaOffreEnCours(Proprietaire proprietaire, ProduitFermier produitFermier)
    {
        for (OffreAchat offreAchat : offreAchats)
        {
            if (offreAchat.getProduitFermier() == produitFermier && offreAchat.getAcheteur() == proprietaire)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * ajoute une offre d'achat dans la liste des offres d'achats du marché
     * @param offreAchat correspond à l'offre d'achat à ajouter
     */

    public void addOffreToOffreAchats(OffreAchat offreAchat){
        offreAchats.add(offreAchat);
        notifier();
    }

    /**
     * supprime un offre d'achat dans la liste des offres du marché
     * @param offreAchat correspond à l'offre d'achat à supprimer
     */

    public void removeOffreToOffreAchats(OffreAchat offreAchat){
        offreAchats.remove(offreAchat);
        notifier();
    }

    /**
     * supprimer l'offre de vente de la liste du marché
     * @param produitFermier correspond au produit à supprimer
     */

    public void removeProduitFermier(ProduitFermier produitFermier){
        produitsFermier.remove(produitFermier);
        notifier();
    }
    public boolean findProduitInProduits(ProduitFermier produitFermier)
    {
        for (ProduitFermier produitFermier1 : produitsFermier)
        {
            if (produitFermier1 == produitFermier)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * renvoie vrai si un type de produit est présent dans la liste des offres de vente
     * @param type correspond au type de produit cherché
     * @return boolean
     */

    public boolean isProduitForThatType(String type)
    {
        for (ProduitFermier produitFermier : produitsFermier)
        {
            try {
                if(produitFermier.getClass() == Class.forName(type)) return true;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * renvoie le produit avec le type correspondant le moins cher
     * @param type correspond au type de produit que l'on recherche
     * @return ProduitFermier
     */

    public ProduitFermier getProduitMoinsChereByType(String type)
    {

        Comparator<ProduitFermier> produitFermierComparator = (s1, s2) -> (int) (s1.getPrix()/s1.getPoids() - s2.getPrix()/s2.getPoids());
        PriorityQueue<ProduitFermier> produitFermierPriorityQueue = new PriorityQueue<>(produitFermierComparator);
        for (ProduitFermier produitfermier : this.getProduitsFermier()) {
            try {
                if(produitfermier.getClass() == Class.forName(type)){
                    produitFermierPriorityQueue.add(produitfermier);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return produitFermierPriorityQueue.remove();
    }

    public TreeSet<Producteur> getVendeurs() {
        return vendeurs;
    }

    public PriorityQueue <Proprietaire> getAcheteurs() {
        return acheteurs;
    }

    public PriorityQueue<ProduitFermier> getProduitsFermier() {
        return produitsFermier;
    }

    public void setVendeurs(TreeSet<Producteur> vendeurs) {
        this.vendeurs = vendeurs;
        notifier();
    }

    public void setAcheteurs(PriorityQueue <Proprietaire> acheteurs) {
        this.acheteurs = acheteurs;
        notifier();
    }

    public void setProduitsFermier(PriorityQueue<ProduitFermier> produitsFermier) {
        this.produitsFermier = produitsFermier;
        notifier();
    }

    /**
     * ajoute un vendeur à la liste des vendeurs du marché
     * @param p correpond au vendeur à ajouté
     */
    public void addVendeur(Producteur p)
    {
        vendeurs.add(p);
        notifier();
    }

    /**
     * ajoute une liste de vendeurs à la liste des vendeurs du marché
     * @param ListVendeurs correspond à la liste à ajouter
     */

    public void addVendeurs(List<Producteur> ListVendeurs)
    {
        vendeurs.addAll(ListVendeurs);
        notifier();
    }

    /**
     * ajoute un acheteur à la lsite des acheteurs du marché
     * @param acheteur correspond à l'acheteur à ajouter
     */

    public void addAcheteur(Proprietaire acheteur)
    {
        acheteurs.add(acheteur);
        notifier();
    }

    /**
     * ajoute une liste d'acheteurs à la liste des acheteurs du marché
     * @param ListAcheteurs correspond à la liste d'acheteurs à ajouter
     */

    public void addAcheteurs(List <Proprietaire> ListAcheteurs)
    {
        acheteurs.addAll(ListAcheteurs);
        notifier();
    }

    /**
     * ajoute une offre de vente à la liste acuelle des offres du marché
     * @param produitFermier correspond au produit a ajouter
     */
    public void addProduit(ProduitFermier produitFermier)
    {
        produitsFermier.add(produitFermier);
        notifier();
    }
    public void addProduit(ProduitFermier produitFermier, ArrayList<Proprietaire> proprietaires)
    {
        produitsFermier.add(produitFermier);
        notifier();
        notifierProprietaires(proprietaires,produitFermier);
    }


    /**
     * ajoute une liste offre de vente à la liste acuelle des offres du marché
     * @param ListProduitFermiers correspond à la liste de prosuits a ajouter
     */

    public void addProduits(List<ProduitFermier> ListProduitFermiers)
    {
        produitsFermier.addAll(ListProduitFermiers);
        notifier();
    }

    public void notifierProprietaires(ArrayList<Proprietaire> proprietaires, ProduitFermier produitFermier)
    {
        for (Proprietaire proprietaire : proprietaires)
        {
            proprietaire.notification(produitFermier);

        }
    }
/**
 * effectue les transactions (solde) entre le producteur et l'acheteur
 * @param produitFermier correspond au produit acheté
 * @param acheteur correspond à l'acheteur du produit
 */
    private void transaction(ProduitFermier produitFermier, Proprietaire acheteur){
        Proprietaire proprietaire = produitFermier.getProprietaire();
        if (acheteur.getSolde() <  produitFermier.getPrix()) return;
        proprietaire.crediter(produitFermier.getPrix() - proprietaire.comissionMarchePourcentage(produitFermier.getPrix()));
        historique.addTransaction(new Transaction(acheteur, produitFermier.getProprietaire(), produitFermier));
        acheteur.crediter(-produitFermier.getPrix());
        proprietaire.removeProduitFermiers(produitFermier);
        produitFermier.setProprietaire(acheteur);
        acheteur.addProduitFermiers(produitFermier);
    }



    @Override
    public String toString() {
        return "MarcheFermier";
    }

    /**
     * notifie les observateurs des modification dans la marché grâce à la méthode update
     */
    @Override
    public void notifier() {
        for(Observateur o : observateurs)
        {
            o.update(this.produitsFermier);
        }
    }
}

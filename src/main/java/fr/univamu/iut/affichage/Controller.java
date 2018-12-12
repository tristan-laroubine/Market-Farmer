package fr.univamu.iut.affichage;

import fr.univamu.iut.traitement.Acteur.Proprietaire;
import fr.univamu.iut.traitement.Controleur;
import fr.univamu.iut.traitement.Marché.Marche;
import fr.univamu.iut.traitement.Marché.MarcheFermier;
import fr.univamu.iut.traitement.Marché.OffreAchat;
import fr.univamu.iut.traitement.Producteur.Producteur;
import fr.univamu.iut.traitement.Producteur.ProducteurDeViande;
import fr.univamu.iut.traitement.Producteur.ProducteurLaitier;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.ProduitFermier.ProduitPeremption;
import fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Cochon;
import fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Vache;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProductionDeViande;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProductionLaitier;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProduction;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.awt.event.MouseEvent;
import java.lang.reflect.Parameter;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public VBox vBoxLesActeurs;
    public Button buttonAdd;
    public VBox pane;
    public Marche marche = new MarcheFermier("Place d'Aix","Rhone-Alpe",new Controleur());
    @FXML
    void addButton(){
        pane.getChildren().clear();

        ComboBox<Proprietaire> proprietaireComboBox = new ComboBox<>();
        proprietaireComboBox.getItems().add(new ProducteurDeViande());
        proprietaireComboBox.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) -> {
                    System.out.println(newValue);
                    setActeur(newValue);
                }
        );
        pane.getChildren().add(proprietaireComboBox);
    }

    void setActeur(Proprietaire proprietaire){
        Label label = new Label();
        label.setText("Prenom :");
        TextArea textArea1 = new TextArea();
        textArea1.setText("Marc");
        Label label1 = new Label("Unite De Production");
        ComboBox<UniteDeProduction> uniteDeProductionComboBox = new ComboBox<>();
        pane.getChildren().addAll(label,textArea1);
        if (proprietaire instanceof ProducteurDeViande)
        {
            UniteDeProduction uniteDeProduction = new UniteDeProductionDeViande();
            uniteDeProductionComboBox.getItems().add(uniteDeProduction);
            uniteDeProductionComboBox.setValue(uniteDeProduction);
            pane.getChildren().addAll(label1,uniteDeProductionComboBox);
        }
        if (proprietaire instanceof ProducteurLaitier)
        {
            UniteDeProduction uniteDeProduction = new UniteDeProductionLaitier();
            uniteDeProductionComboBox.getItems().add(uniteDeProduction);
            uniteDeProductionComboBox.setValue(uniteDeProduction);
            pane.getChildren().addAll(label1,uniteDeProductionComboBox);
        }

        Button button = new Button("Ajouter");
        button.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
                               @Override
                               public void handle(javafx.event.ActionEvent event) {
                                   proprietaire.setPrenom(textArea1.getText());
                                   if (proprietaire instanceof Producteur) {
                                       Producteur producteur = (Producteur) proprietaire;
                                       if (proprietaire instanceof ProducteurDeViande)
                                       {
                                           ((ProducteurDeViande) producteur).setUniteDeProduction((UniteDeProductionDeViande) uniteDeProductionComboBox.getValue());
                                       }
                                   }

                                   AdaptateurProprietaireButton button = new AdaptateurProprietaireButton();
                                   button.setMinHeight(100);
                                   button.setMinWidth(100);
                                   button.setProprietaire(proprietaire);
                                   button.setText(proprietaire.getPrenom());
                                   button.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
                                       @Override
                                       public void handle(javafx.event.ActionEvent event) {
                                           pannelProprietaire(proprietaire);
                                       }
                                   });
                                   vBoxLesActeurs.getChildren().add(button);
                               }

        }
        );
        pane.getChildren().add(button);
    }

    private void pannelProprietaire(Proprietaire proprietaire) {
        pane.getChildren().clear();
        Label labelNom = new Label(proprietaire.getPrenom());
        Label labelSolde = new Label("Solde sur le compte "+proprietaire.getSolde());
        VBox produits = new VBox();
        produits.getChildren().clear();
        produits.setMinWidth(150);
        Label labelProduits = new Label("Produits :");
        pane.getChildren().addAll(labelNom,labelSolde,labelProduits);
        for (ProduitFermier produitfermier: proprietaire.getProduitFermiers()
             ) {
            Label produit = new Label();
            Label labelType = new Label(""+produitfermier);
            Label labelPrix = new Label(""+ produitfermier.getPrix());
            Label labelPoids = new Label(""+ produitfermier.getPoids());
            produit.setId("labelType");
            produit.setText(labelType.getText() + "\n" + labelPoids.getText() + "\n"+ labelPrix.getText());
            AdapteurProduitFermierButton vendreButton = new AdapteurProduitFermierButton();
            vendreButton.setText("Vendre");
            vendreButton.setId("vendre");
            vendreButton.setTranslateX(16);
            vendreButton.setTranslateY(5);
            vendreButton.setOnAction(event -> {
                proprietaire.proposerOffre((MarcheFermier) marche,produitfermier);
            });
            produits.getChildren().addAll(produit,vendreButton);
            if (produitfermier instanceof ProduitPeremption)
            {
                Label labelDatePeremption = new Label("" + ((ProduitPeremption) produitfermier).getDatePeremption());
                produits.getChildren().addAll(labelDatePeremption);
            }

        }
        pane.getChildren().add(produits);
        if(proprietaire instanceof Producteur)
        {
            Button produireProduitButton = new Button("Produire");
            produireProduitButton.setId("produire");
            produireProduitButton.setTranslateY(20);
            produireProduitButton.setTranslateX(5);
            produireProduitButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
                @Override
                public void handle(javafx.event.ActionEvent event) {
                    produireComboBoxProduit((Producteur) proprietaire);
                }
            });
            pane.getChildren().addAll(produireProduitButton);
        }

    }

    public void produireComboBoxProduit(Producteur producteur)
    {
        pane.getChildren().clear();
        ComboBox<String> produitFermierComboBox = new ComboBox<>();
        if (producteur instanceof ProducteurDeViande)
        {
            produitFermierComboBox.getItems().addAll("Cochon","Vache");
        }
        VBox attriProduit = new VBox();
        produitFermierComboBox.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) -> {
                    produiteComboBoxItem(newValue,producteur, attriProduit);
                }

        );
        pane.getChildren().addAll(produitFermierComboBox,attriProduit);
    }
    public void produiteComboBoxItem(String str, Producteur producteur, VBox vBox)
    {
        vBox.getChildren().clear();
        Label labelPrix = new Label("Prix :");
        Slider sliderPrix = new Slider();
        sliderPrix.setMin(0);
        sliderPrix.setMax(100);
        sliderPrix.setValue(50);
        Label labelPoids = new Label("Poids :");
        Slider sliderPoids = new Slider();
        sliderPoids.setMin(0);
        sliderPoids.setMax(50);
        sliderPoids.setValue(25);
        vBox.getChildren().addAll(labelPrix,sliderPrix,labelPoids,sliderPoids);

        Button buttonValide = new Button("Produire " +  str);
        buttonValide.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                switch (str){

                    case "Vache" :
                        String[] parametere = {"java.lang.Integer", "java.lang.Double"};
                        Vache vache = (Vache) producteur.produitProduit("fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Vache",parametere,(int)sliderPoids.getValue(), sliderPrix.getValue());
                        break;

                    case "Cochon":
                        String[] parametere1 = {"java.lang.Integer", "java.lang.Double"};
                        Cochon cochon = (Cochon) producteur.produitProduit("fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Cochon",parametere1,(int)sliderPoids.getValue(), sliderPrix.getValue());
                            break;
                    default:
                        System.out.println("Type non trouvé !");
                        break;
                }
                pannelProprietaire(producteur);
            }
        });
        vBox.getChildren().addAll(buttonValide);

    }

    public void initialisationMarcheEtControler()
    {
        AdapteurMarcheButton buttonMarche = new AdapteurMarcheButton();
        buttonMarche.setMarche(marche);
        buttonMarche.setText("Marche Fermier");
        buttonMarche.setMinHeight(100);
        buttonMarche.setMinWidth(100);
        buttonMarche.setOnAction(event -> {
            pannelMarche(buttonMarche.getMarche());
        });
        AdapteurControllerButton buttonController = new AdapteurControllerButton();
        buttonController.setController(marche.getControleur());
        buttonController.setText("Controlleur ");
        buttonController.setMinHeight(100);
        buttonController.setMinWidth(100);
        buttonController.setOnAction(event -> {
            pannelControlleur(buttonController.getController());
        });
        vBoxLesActeurs.getChildren().addAll(buttonMarche,buttonController);
    }

    private void pannelControlleur(Controleur controller) {
        pane.getChildren().clear();
        Label labelNom = new Label("Controlleur de Marche");
        pane.getChildren().add(labelNom);
    }

    private void pannelMarche(Marche marche) {
        if (marche instanceof MarcheFermier)
        {
            pane.getChildren().clear();
            Label labelNom = new Label("Nom : " + marche.getNom());
            Label labelRegion = new Label("Region : " + marche.getRegion());
            Label labelControlleur = new Label("Controlleur : " + marche.getControleur());
            Label labelOffreAchat = new Label("Offre d'Achat : ");

            pane.getChildren().addAll(labelNom,labelRegion,labelControlleur,labelOffreAchat);
            for (OffreAchat offreAchat: ((MarcheFermier) marche).getOffreAchats()
                 ) {
                VBox vBoxOffreAchat = new VBox();
                Label labelProduit = new Label("Produit : " + offreAchat.getProduitFermier());
                Label labelPoids = new Label("Poids : " + offreAchat.getProduitFermier().getPoids());
                Label labelPrix = new Label("Prix : " + offreAchat.getProduitFermier().getPrix());
                Label labelDate = new Label("Date de l'offre " + offreAchat.getDateOffre());
                Label labelAcheteur = new Label("Acheteur " + offreAchat.getAcheteur());
                vBoxOffreAchat.getChildren().addAll(labelProduit,labelPoids,labelPrix,labelDate,labelAcheteur);
                pane.getChildren().add(vBoxOffreAchat);
            }
            Label labelProduitsFermier = new Label("Produit Disponible : ");
            pane.getChildren().addAll(labelProduitsFermier);
            for (ProduitFermier produitFermier: ((MarcheFermier) marche).getProduitsFermier()
                    ) {
                VBox vBoxProduit = new VBox();
                Label labelProduit = new Label("Produit : " + produitFermier);
                Label labelPoids = new Label("Poids : " + produitFermier.getPoids());
                Label labelPrix = new Label("Prix : " + produitFermier.getPrix());
                Label labelAcheteur = new Label("Acheteur " + produitFermier.getProprietaire());
                vBoxProduit.getChildren().addAll(labelProduit,labelPoids,labelPrix,labelAcheteur);
                pane.getChildren().add(vBoxProduit);
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initialisationMarcheEtControler();
    }
}

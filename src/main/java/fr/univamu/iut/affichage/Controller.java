package fr.univamu.iut.affichage;

import fr.univamu.iut.traitement.Acteur.Grossiste;
import fr.univamu.iut.traitement.Acteur.Proprietaire;
import fr.univamu.iut.traitement.Acteur.Tradeur;
import fr.univamu.iut.traitement.Controleur;
import fr.univamu.iut.traitement.Historique;
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
import fr.univamu.iut.traitement.Transaction;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProductionDeViande;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProductionLaitier;
import fr.univamu.iut.traitement.UniteDeProduction.UniteDeProduction;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public VBox vBoxLesActeurs;
    public Button buttonAdd;
    public VBox pane;
    public Marche marche = new MarcheFermier("Place d'Aix","Rhone-Alpe",new Controleur(), new Historique());
    public VBox vBoxLesProduitEnVente;
    public ScrollPane panelProduitMarche;
    public VBox historiqueScrollPane;

    @FXML
    void addButton(){
        pane.getChildren().clear();

        ComboBox<Proprietaire> proprietaireComboBox = new ComboBox<>();
        proprietaireComboBox.getItems().add(new ProducteurDeViande());
        proprietaireComboBox.getItems().add(new Tradeur());
        proprietaireComboBox.getItems().add(new Grossiste());
        proprietaireComboBox.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) -> {
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
                                   pannelProprietaire(proprietaire);
                               }

        }
        );
        pane.getChildren().add(button);
    }

    private void pannelProprietaire(Proprietaire proprietaire) {
        pane.getChildren().clear();
        updateVBoxProduit(proprietaire);
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
                proprietaire.vendre(produitfermier,(MarcheFermier) marche);
                updateVBoxProduit(proprietaire);
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
        if(proprietaire instanceof Grossiste)
        {
            ComboBox<String> typeC = new ComboBox<>();
            typeC.getItems().addAll(
                    "Vache",
                    "Cochon"
            );
            typeC.setValue("Vache");
            Slider prixMax = new Slider();
            prixMax.setMin(0);
            prixMax.setMax(100);
            prixMax.setValue(50);

            Slider soldeMax = new Slider();
            soldeMax.setMin(0);
            soldeMax.setMax(proprietaire.getSolde());
            soldeMax.setValue(proprietaire.getSolde()/2);

            Label prixMaxLabel = new Label("Prix Max : ");
            Label soldeMaxLabel = new Label("Solde Max : ");
            soldeMax.valueProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    soldeMaxLabel.textProperty().setValue("Solde Max : " +
                            String.valueOf(arrondir (soldeMax.getValue(),2)));
                }
            });
            prixMax.valueProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    prixMaxLabel.textProperty().setValue("Prix Max : " +
                            String.valueOf(arrondir (prixMax.getValue(),2)));
                }
            });
            final String[] typeProduit = {"fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Vache"};
            typeC.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) -> {
                switch (newValue){
                    case "Cochon":
                        typeProduit[0] = "fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Cochon";
                        break;

                    case "Vache":
                        typeProduit[0] = "fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Vache";
                        break;
                }
                    }
            );
            Button offreEnMasse = new Button("Offre en masse");
            offreEnMasse.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                   ((Grossiste) proprietaire).proposerOffreEnGrandeQuantitee((MarcheFermier)marche, typeProduit[0],prixMax.getValue(),soldeMax.getValue());
                    updateVBoxProduit(proprietaire);
                }
            });
            pane.getChildren().addAll(typeC,prixMaxLabel,prixMax,soldeMaxLabel,soldeMax,offreEnMasse);
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
        sliderPrix.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                labelPrix.textProperty().setValue("Prix : " +
                        String.valueOf(arrondir (sliderPrix.getValue(),2)));

            }
        });
        Label labelPoids = new Label("Poids :");
        Slider sliderPoids = new Slider();
        sliderPoids.setMin(0);
        sliderPoids.setMax(50);
        sliderPoids.setValue(25);
        sliderPoids.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                labelPoids.textProperty().setValue("Poids : " +
                        String.valueOf((int)(sliderPoids.getValue())));

            }
        });
        vBox.getChildren().addAll(labelPrix,sliderPrix,labelPoids,sliderPoids);

        Button buttonValide = new Button("Produire " +  str);
        buttonValide.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                switch (str){

                    case "Vache" :
                        String[] parametere = {"java.lang.Integer", "java.lang.Double"};
                        Vache vache = (Vache) producteur.produitProduit("fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Vache",parametere,(int)sliderPoids.getValue(), arrondir(sliderPrix.getValue(),2));
                        break;

                    case "Cochon":
                        String[] parametere1 = {"java.lang.Integer", "java.lang.Double"};
                        Cochon cochon = (Cochon) producteur.produitProduit("fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Cochon",parametere1,(int)sliderPoids.getValue(), arrondir(sliderPrix.getValue(),2));
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
        updateVBoxProduit();
        pane.getChildren().clear();
        Label labelNom = new Label("Controlleur de Marche");
        pane.getChildren().add(labelNom);
    }


    private void pannelMarche(Marche marche) {
        updateVBoxProduit();
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
            Button buttonCheck = new Button("Avancer");
            buttonCheck.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    ((MarcheFermier) marche).checkOffreAchatVente();
                    updateVBoxProduit();
                    updateHistorique();
                }
            });
            pane.getChildren().add(buttonCheck);
        }
    }
    void updateVBoxProduit(Proprietaire proprietaire)
    {
        vBoxLesProduitEnVente.getChildren().clear();
        for (ProduitFermier produitFermier: ((MarcheFermier) marche).getProduitsFermier()) {
            VBox vBoxProduit = new VBox();
            Label labelProduit = new Label("Produit : " + produitFermier);
            Label labelPoids = new Label("Poids : " + produitFermier.getPoids());
            Label labelPrix = new Label("Prix : " + produitFermier.getPrix());
            Label labelAcheteur = new Label("Acheteur " + produitFermier.getProprietaire());
            vBoxProduit.getChildren().addAll(labelProduit,labelPoids,labelPrix,labelAcheteur);
            if(((MarcheFermier) marche).isDejaOffreEnCours(proprietaire, produitFermier))
            {
                Button buttonVendre = new Button("Offre en cours");
                buttonVendre.setId("buttonAcheter");
                vBoxProduit.getChildren().add(buttonVendre);
                vBoxLesProduitEnVente.getChildren().add(vBoxProduit);
            }
            else if (proprietaire != produitFermier.getProprietaire())
            {
                Button buttonVendre = new Button("Acheter");
                buttonVendre.setId("buttonVendre");
                buttonVendre.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        proprietaire.proposerOffre((MarcheFermier) marche,produitFermier);
                        updateVBoxProduit(proprietaire);
                    }
                });
                vBoxProduit.getChildren().add(buttonVendre);
                vBoxLesProduitEnVente.getChildren().add(vBoxProduit);
            }

            else{
                Button buttonVendre = new Button("Retirer");
                buttonVendre.setId("buttonAcheter");
                buttonVendre.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        ((MarcheFermier) marche).removeProduitFermier(produitFermier);
                        updateVBoxProduit(proprietaire);
                    }
                });
                vBoxProduit.getChildren().add(buttonVendre);
                vBoxLesProduitEnVente.getChildren().add(vBoxProduit);
            }

        }
    }
    void updateVBoxProduit(){
        vBoxLesProduitEnVente.getChildren().clear();
        for (ProduitFermier produitFermier: ((MarcheFermier) marche).getProduitsFermier()) {
            VBox vBoxProduit = new VBox();
            Label labelProduit = new Label("Produit : " + produitFermier);
            Label labelPoids = new Label("Poids : " + produitFermier.getPoids());
            Label labelPrix = new Label("Prix : " + produitFermier.getPrix());
            Label labelAcheteur = new Label("Acheteur " + produitFermier.getProprietaire());
            vBoxProduit.getChildren().addAll(labelProduit,labelPoids,labelPrix,labelAcheteur);
            vBoxLesProduitEnVente.getChildren().add(vBoxProduit);
        }
    }

    void updateHistorique()
    {
        historiqueScrollPane.getChildren().clear();
        for (Transaction transaction : marche.getHistorique().getTransactions()) {
            historiqueScrollPane.getChildren().add(new Label(transaction.toString()));
        }

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateHistorique();
        pannelMarche(marche);
        updateVBoxProduit();
        initialisationMarcheEtControler();
    }
    private double arrondir(double nombre,double nbApVirg)
    {
        return(double)((int)(nombre * Math.pow(10,nbApVirg) + .5)) / Math.pow(10,nbApVirg);
    }
}

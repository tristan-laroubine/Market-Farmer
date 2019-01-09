package fr.univamu.iut.affichage;

import fr.univamu.iut.traitement.Acteur.CentraleAchat;
import fr.univamu.iut.traitement.Acteur.Grossiste;
import fr.univamu.iut.traitement.Acteur.Proprietaire;
import fr.univamu.iut.traitement.Acteur.Tradeur;
import fr.univamu.iut.traitement.Controleur;
import fr.univamu.iut.traitement.Historique;
import fr.univamu.iut.traitement.Marché.Marche;
import fr.univamu.iut.traitement.Marché.MarcheFermier;
import fr.univamu.iut.traitement.Producteur.*;
import fr.univamu.iut.traitement.ProduitFermier.ProduitApiculteur.Miel;
import fr.univamu.iut.traitement.ProduitFermier.ProduitArboriculteur.Pomme;
import fr.univamu.iut.traitement.ProduitFermier.ProduitFermier;
import fr.univamu.iut.traitement.ProduitFermier.ProduitLaitier.Lait;
import fr.univamu.iut.traitement.ProduitFermier.ProduitOrticulteur.PommeDeTerre;
import fr.univamu.iut.traitement.ProduitFermier.ProduitPeremption;
import fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Cochon;
import fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Vache;
import fr.univamu.iut.traitement.Transaction;
import fr.univamu.iut.traitement.UniteDeProduction.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public VBox vBoxLesActeurs;
    public Button buttonAdd;
    public VBox pane;
    public Marche marche = new MarcheFermier("Place d'Aix","Rhone-Alpe",new Controleur(), new Historique());
    public VBox vBoxLesProduitEnVente;
    public ScrollPane panelProduitMarche;
    public VBox historiqueScrollPane;
    public ScrollPane ScrollPanePane;
    public ScrollPane ScrollPaneHistorique;
    private ArrayList<Proprietaire> proprietaires = new ArrayList<>();
    public ArrayList<Proprietaire> ajouterproprietaires = new ArrayList<>();
    @FXML
    void addButton(){
        pane.getChildren().clear();

        ComboBox<Proprietaire> proprietaireComboBox = new ComboBox<>();
        proprietaireComboBox.getItems().add(new ProducteurDeViande());
        proprietaireComboBox.getItems().add(new ProducteurLaitier());
        proprietaireComboBox.getItems().add(new Arboriculteur());
        proprietaireComboBox.getItems().add(new Orticulteur());
        proprietaireComboBox.getItems().add(new Tradeur());
        proprietaireComboBox.getItems().add(new Grossiste());
        proprietaireComboBox.getItems().add(new CentraleAchat());
        proprietaireComboBox.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) -> {
                    pane.getChildren().clear();
                    pane.getChildren().add(proprietaireComboBox);
                    setActeur(newValue);
                }
        );
        pane.getChildren().add(proprietaireComboBox);
        ScrollPanePane.setVvalue(0);

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
        if (proprietaire instanceof Arboriculteur)
        {
            UniteDeProduction uniteDeProduction = new UniteDeProductionArboriculteur();
            uniteDeProductionComboBox.getItems().add(uniteDeProduction);
            uniteDeProductionComboBox.setValue(uniteDeProduction);
            pane.getChildren().addAll(label1,uniteDeProductionComboBox);
        }
        if (proprietaire instanceof Orticulteur)
        {
            UniteDeProduction uniteDeProduction = new UniteDeProductionOrticulteur();
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
                                           (producteur).setUniteDeProduction((UniteDeProductionDeViande) uniteDeProductionComboBox.getValue());
                                       }
                                       if (proprietaire instanceof Arboriculteur)
                                       {
                                           (producteur).setUniteDeProduction((UniteDeProductionArboriculteur) uniteDeProductionComboBox.getValue());
                                       }
                                       if (proprietaire instanceof Orticulteur)
                                       {
                                           (producteur).setUniteDeProduction((UniteDeProductionOrticulteur) uniteDeProductionComboBox.getValue());
                                       }
                                       if (proprietaire instanceof Arboriculteur)
                                       {
                                           (producteur).setUniteDeProduction((UniteDeProductionArboriculteur) uniteDeProductionComboBox.getValue());
                                       }
                                       if (proprietaire instanceof ProducteurLaitier)
                                       {
                                           (producteur).setUniteDeProduction(uniteDeProductionComboBox.getValue());
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
                                           ScrollPanePane.setVvalue(0);
                                       }
                                   });
                                   vBoxLesActeurs.getChildren().add(button);
                                   if(!(proprietaire instanceof CentraleAchat))
                                   {
                                       MarcheFermier castMarche = (MarcheFermier) marche;
                                       castMarche.addProprietaireInAbonne(proprietaire);

                                   }
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
        produits.setMinHeight(produits.getHeight()+20);
        pane.getChildren().addAll(labelNom,labelSolde,labelProduits);
        pane.setMinHeight(pane.getHeight());
        for (ProduitFermier produitfermier: proprietaire.getProduitFermiers()
             ) {
            Label produit = new Label();
            Label labelType = new Label(""+produitfermier);
            Label labelPrix = new Label(""+ produitfermier.getPrix());
            Label labelPoids = new Label(""+ produitfermier.getPoids());
            produit.setId("labelType");
            produit.setMinHeight(100);

            if(produitfermier instanceof ProduitPeremption) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
                produit.setText(labelType.getText() + "\n" + "Poids : " + labelPoids.getText() + "\n"+ "Prix : " + labelPrix.getText() + "\n" + "Péremption : " + formatter.format(((ProduitPeremption) produitfermier).getDatePeremption()));
            }
            else
            {
                produit.setText(labelType.getText() + "\n" + "Poids : " + labelPoids.getText() + "\n"+ "Prix : " + labelPrix.getText());
            }
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
            pane.setMinHeight(pane.getMinHeight() + produit.getHeight() + 20);
        }
        pane.getChildren().add(produits);
        if(proprietaire instanceof Producteur)
        {
            Button produireProduitButton = new Button("Produire");
            produireProduitButton.setId("produire");
            produireProduitButton.setTranslateX(5);
            produireProduitButton.setOnAction(event -> {
                produireComboBoxProduit((Producteur) proprietaire);
                ScrollPanePane.setVvalue(0);

            });
            pane.getChildren().addAll(produireProduitButton);
        }
        if(proprietaire instanceof Grossiste)
        {
            ComboBox<String> typeC = new ComboBox<>();
            typeC.getItems().addAll(
                    "Vache",
                    "Cochon",
                    "Miel",
                    "Pomme",
                    "Lait",
                    "Pomme de Terre"
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
            switchProduit(typeC, typeProduit);
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
        if(proprietaire instanceof CentraleAchat)
        {
            ComboBox<String> typeC = new ComboBox<>();
            typeC.getItems().addAll(
                    "Vache",
                    "Cochon",
                    "Miel",
                    "Pomme",
                    "Lait",
                    "Pomme de Terre"
            );
            typeC.setValue("Vache");
            final String[] typeDuProduit = {"fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Vache"};
            switchProduit(typeC, typeDuProduit);

            ComboBox proprietaireComboBox = new ComboBox();
            proprietaireComboBox.setId("proprietaireComboBox");
            pane.getChildren().add(typeC);
            for(Proprietaire p : proprietaires){
                if(!isInListProprietaire(ajouterproprietaires,p))proprietaireComboBox.getItems().add(p);
            }
            if(proprietaireComboBox.getItems().size() != 0)
            {

                Button ajouter = new Button("Ajouter");
                ajouter.setId("ajouter");
                ajouter.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if(proprietaireComboBox.getValue() instanceof Proprietaire)
                        {
                            ajouterproprietaires.add((Proprietaire) proprietaireComboBox.getValue());
                        }
                        pannelProprietaire(proprietaire);
                    }
                });

                pane.getChildren().add(ajouter);
            }


            VBox listActeur = new VBox();
            for(Proprietaire p : ajouterproprietaires){
                Button button = new Button(p.getPrenom() + " " + p);
                button.setId("buttonProprietaireAchat");
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        ajouterproprietaires.remove(p);
                        pannelProprietaire(proprietaire);
                    }
                });
                listActeur.getChildren().add(button);
            }


            Button offreEnMasse = new Button("Achat Groupe");
            offreEnMasse.setId("offreEnMasse");
            offreEnMasse.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    CentraleAchat centraleAchat = (CentraleAchat) proprietaire;
                   centraleAchat.achatDeGroupe(typeDuProduit[0],proprietaires,marche);
                    updateVBoxProduit(proprietaire);
                }
            });
            pane.getChildren().add(proprietaireComboBox);

            pane.getChildren().add(listActeur);
            pane.getChildren().add(offreEnMasse);

        }
        ComboBox<String> typeProduitAbo = new ComboBox<>();
        typeProduitAbo.getItems().addAll(
                "Vache",
                "Cochon",
                "Miel",
                "Pomme",
                "Lait",
                "Pomme de Terre"
        );
        typeProduitAbo.setValue("Vache");
        final String[] typeDuProduitAbo = {"fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Vache"};
        switchProduit(typeProduitAbo, typeDuProduitAbo);
        Button abonner = new Button("Abonnement");
        abonner.setId("offreEnMasse");

        abonner.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                proprietaire.addTypes(typeDuProduitAbo[0]);
                pannelProprietaire(proprietaire);
            }
        });

        VBox listAbonner = new VBox();
        for(String string : proprietaire.getTypes()){
            Button button = new Button(traductTypeJavaInString(string));
            button.setId("buttonProprietaireAchat");
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    proprietaire.getTypes().remove(string);
                    pannelProprietaire(proprietaire);
                }
            });
            listAbonner.getChildren().add(button);
        }
        pane.getChildren().addAll(typeProduitAbo,abonner,listAbonner);
    }

    private void switchProduit(ComboBox<String> typeProduitAbo, String[] typeDuProduitAbo) {
        typeProduitAbo.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) -> {
                    switch (newValue){
                        case "Cochon":
                            typeDuProduitAbo[0] = "fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Cochon";
                            break;

                        case "Vache":
                            typeDuProduitAbo[0] = "fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Vache";
                            break;

                        case "Miel":
                            typeDuProduitAbo[0] = "fr.univamu.iut.traitement.ProduitFermier.ProduitApiculteur.Miel";
                            break;

                        case "Pomme":
                            typeDuProduitAbo[0] = "fr.univamu.iut.traitement.ProduitFermier.ProduitArboriculteur.Pomme";
                            break;

                        case "Lait":
                            typeDuProduitAbo[0] = "fr.univamu.iut.traitement.ProduitFermier.ProduitLaitier.Lait";
                            break;

                        case "Pomme de Terre":
                            typeDuProduitAbo[0] = "fr.univamu.iut.traitement.ProduitFermier.ProduitOrticulteur.PommeDeTerre";
                            break;
                    }
                }
        );
    }

    private String traductTypeJavaInString(String string){

        switch (string){
            case "fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Cochon":
                return "Cochon";


            case "fr.univamu.iut.traitement.ProduitFermier.ProduitViande.Vache":
                return"Vache";


            case "fr.univamu.iut.traitement.ProduitFermier.ProduitApiculteur.Miel":
                return "Miel";


            case "fr.univamu.iut.traitement.ProduitFermier.ProduitArboriculteur.Pomme":
                return "Pomme";


            case "fr.univamu.iut.traitement.ProduitFermier.ProduitLaitier.Lait":
                return "Lait";


            case "fr.univamu.iut.traitement.ProduitFermier.ProduitOrticulteur.PommeDeTerre":
                return "Pomme De Terre";

        }
        return "NULL";
    }
    private boolean isInListProprietaire(ArrayList<Proprietaire> proprietaires, Proprietaire proprietaire)
    {
        for (Proprietaire proprietaire1 : proprietaires)
        {
            if (proprietaire1==proprietaire)
            {
                return true;
            }
        }
        return false;
    }
    public void produireComboBoxProduit(Producteur producteur)
    {
        pane.getChildren().clear();
        ComboBox<String> produitFermierComboBox = new ComboBox<>();
        if (producteur instanceof ProducteurDeViande)
        {
            produitFermierComboBox.getItems().addAll("Cochon","Vache");
        }
        if (producteur instanceof Arboriculteur)
        {
            produitFermierComboBox.getItems().addAll("Pomme");
        }
        if (producteur instanceof Orticulteur)
        {
            produitFermierComboBox.getItems().addAll("PommeDeTerre");
        }
        if (producteur instanceof ProducteurLaitier)
        {
            produitFermierComboBox.getItems().addAll("Lait");
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
                    case "Pomme":
                        String[] parametere2 = {"java.lang.Integer", "java.lang.Double"};
                        Pomme pomme = (Pomme) producteur.produitProduit("fr.univamu.iut.traitement.ProduitFermier.ProduitArboriculteur.Pomme",parametere2,(int)sliderPoids.getValue(), arrondir(sliderPrix.getValue(),2));
                        break;
                    case "Lait":
                        String[] parametere3 = {"java.lang.Integer", "java.lang.Double"};
                        Lait lait = (Lait) producteur.produitProduit("fr.univamu.iut.traitement.ProduitFermier.ProduitLaitier.Lait",parametere3,(int)sliderPoids.getValue(), arrondir(sliderPrix.getValue(),2));
                        break;
                    case "Miel":
                        String[] parametere4 = {"java.lang.Integer", "java.lang.Double"};
                        Miel miel = (Miel) producteur.produitProduit("fr.univamu.iut.traitement.ProduitFermier.ProduitApiculteur.Miel",parametere4,(int)sliderPoids.getValue(), arrondir(sliderPrix.getValue(),2));
                        break;
                    case "PommeDeTerre":
                        String[] parametere5 = {"java.lang.Integer", "java.lang.Double"};
                        PommeDeTerre pommeDeTerre = (PommeDeTerre) producteur.produitProduit("fr.univamu.iut.traitement.ProduitFermier.ProduitOrticulteur.PommeDeTerre",parametere5,(int)sliderPoids.getValue(), arrondir(sliderPrix.getValue(),2));
                        break;
                    default:
                        System.out.println("Type non trouvé !");
                        break;
                }

                pannelProprietaire(producteur);
                ScrollPanePane.setVvalue(pane.getHeight());
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
            ScrollPanePane.setVvalue(0);
        });
        AdapteurControllerButton buttonController = new AdapteurControllerButton();
        buttonController.setController(marche.getControleur());
        buttonController.setText("Controlleur ");
        buttonController.setMinHeight(100);
        buttonController.setMinWidth(100);
        buttonController.setOnAction(event -> {
            pannelControlleur(buttonController.getController());
            ScrollPanePane.setVvalue(0);
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

            pane.getChildren().addAll(labelNom,labelRegion,labelControlleur);
            Button buttonCheck = new Button("Avancer");
            buttonCheck.setId("produire");
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
            Label produit = new Label(produitFermier + "\n" + "Poids : " + produitFermier.getPoids() + "\n" + "Prix : " + produitFermier.getPrix()
                    + "\n" + "Vendeur : " + produitFermier.getProprietaire().getPrenom());
            produit.setId("labelType");
            produit.setMinHeight(100);
            vBoxProduit.getChildren().addAll(produit);
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
                buttonVendre.setTranslateX(45);
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
                buttonVendre.setTranslateX(45);
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
            Label produit = new Label(produitFermier + "\n" + "Poids : " + produitFermier.getPoids() + "\n" + "Prix : " + produitFermier.getPrix()
            + "\n" + "Vendeur : " + produitFermier.getProprietaire().getPrenom());
            produit.setId("labelType");
            vBoxProduit.getChildren().addAll(produit);
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

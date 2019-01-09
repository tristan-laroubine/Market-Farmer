
package fr.univamu.iut.affichage;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("iu.fxml"));
        Controller controller = loader.getController();
        Parent root = loader.load();
        primaryStage.setTitle("Marche");
        Scene scene = new Scene(root, 1000, 600);
        scene.getStylesheets().add("http://ivax.alwaysdata.net/css/style.css");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

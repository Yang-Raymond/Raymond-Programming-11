package Friendsbook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("friendsbook.fxml"));
        Scene scne = new Scene(root);
        primaryStage.setTitle("Friendsbook");
        primaryStage.setScene(scne);
        primaryStage.show();
        
    }
    
}

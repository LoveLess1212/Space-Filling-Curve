package com.mycompany.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import processing.javafx.PSurfaceFX;

/**
 * JavaFX App
 */
public class App extends Application {

        
    public static PSurfaceFX surface;

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("primarySnowflake.fxml"));
        Parent root = loader.load();
        PrimarySnowflakeController.stage = primaryStage;
        Scene scene = new Scene(root, 1280, 720);

        
        primaryStage.setScene(scene);
        primaryStage.show();

        surface.stage = primaryStage;
        PrimarySnowflakeController.stage = primaryStage;
    } 
    
    private static Scene scene;

    /*@Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primarySnowflake"), 1335, 703);
        stage.setScene(scene);
        stage.show();
    }
        */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load(); 
    }
    

}  



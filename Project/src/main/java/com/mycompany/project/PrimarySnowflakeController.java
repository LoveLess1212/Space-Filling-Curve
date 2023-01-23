
package com.mycompany.project;


import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import processing.javafx.PSurfaceFX;
import static processing.javafx.PSurfaceFX.PApplicationFX.surface;
/**
 * FXML Controller class
 *
 * @author ACER
 */



public class PrimarySnowflakeController implements Initializable {

    public static PSurfaceFX surface;
    public static fillCurve1 p;
    protected static Stage stage;
    
    
    @FXML
    private VBox root;
    @FXML
    private VBox chosenAnimation;
    @FXML
    private Label animationName;
    @FXML
    private Button primaryButton;
    @FXML
    private Button primaryButton1;
    @FXML
    private Button primaryButton11;
    @FXML
    private Button primaryButton111;
    @FXML
    private ImageView projectImg;
    @FXML
    private Button primaryButton12;
    @FXML
    private StackPane processing;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
          Canvas canvas = (Canvas) surface.getNative();
          surface.fx.context = canvas.getGraphicsContext2D();
          processing.getChildren().add(canvas);
          canvas.widthProperty().bind(processing.widthProperty());
          canvas.heightProperty().bind(processing.heightProperty());
         
         
         
    }   

    @FXML
     private void switchToSecondary(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }  
    private void drawShapes(GraphicsContext gc) {
        //gc.setFill(Color.BLUE);
        gc.strokeOval(100, 50, 200, 200);
        gc.fillOval(155, 100, 10, 20);
        gc.fillOval(230, 100, 10, 20);
        gc.strokeArc(150, 160, 100, 50, 180, 180, ArcType.OPEN);
        
    } 
    
}



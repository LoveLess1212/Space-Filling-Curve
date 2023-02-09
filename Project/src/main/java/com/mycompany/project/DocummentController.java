/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 *
 * @author ACERsss
 *
 */
public class DocummentController implements Initializable {

    @FXML
    private Button ProjectButton;

    @FXML
    private TextArea info;

    @FXML
    private Button profileButton;

    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //PSurface surface = new PSurfaceJFX(sketch1);
        info.setEditable(false);
        info.setWrapText(true);
        info.isWrapText();

        ProjectButton.setOnAction(event -> {
            try {
                changeProjects();
            } catch (IOException ex) {
            }
        });

        profileButton.setOnAction(event -> {
            try {
                changeProfile();
            } catch (IOException ex) {
            }
        });

    }

    @FXML
    private void changeProjects() throws IOException {
        App.setRoot("Project");
    }

    @FXML
    private void changeProfile() throws IOException {
        App.setRoot("Profile");
    }

}

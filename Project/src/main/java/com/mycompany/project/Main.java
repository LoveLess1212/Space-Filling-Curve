package com.mycompany.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import javafx.application.Application;
import static javafx.application.Application.launch;
import processing.core.PApplet;
import processing.javafx.*;

public class Main {
               

    
    public static void main(String[] args) {
        
        PApplet sketch = new fillCurve1();
        String[] processingArgs = {""};
        PApplet.runSketch(processingArgs,sketch);   
        
    }
}

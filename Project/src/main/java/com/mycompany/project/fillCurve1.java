package com.mycompany.project;

import java.util.Stack;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import processing.core.PApplet;
import static processing.core.PApplet.cos;
import static processing.core.PApplet.pow;
import static processing.core.PApplet.radians;
import static processing.core.PApplet.sin;
import processing.core.PFont;
import processing.core.PVector;
import processing.core.PSurface;
import processing.javafx.PSurfaceFX;





public class fillCurve1 extends PApplet {
    
    float x, y;
    float angle;
    float depth = 4;
    int totalSteps;
    int currentStep;
    
    int frameRate = 300; // set the initial frame rate
@Override
    protected PSurface initSurface() {
        g = createPrimaryGraphics();
        PSurface genericSurface = g.createSurface();
        PSurfaceFX fxSurface = (PSurfaceFX) genericSurface;

        fxSurface.sketch = this;

        App.surface = fxSurface;     
        PrimarySnowflakeController.surface = fxSurface;
        
        
            
     
        new Thread(new Runnable() {
        public void run() {
            Application.launch(App.class);
        }
    }).start();

    while (fxSurface.stage == null) {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
        }
    }

    
        this.surface = fxSurface;
        Canvas canvas = (Canvas) surface.getNative();
        
        return surface;
    
    }
    
    public void settings() {
        size(800, 800,FX2D);
        smooth();
        
        
    }

    public void setup() {
        //noStroke();
        //colorMode(HSB,360,255,255);
        PrimarySnowflakeController.p = this;
        background(0);
        angle = radians(60);
        x = 180;
        y = height + 97;
        translate(x - 300, y - 300);
        String curveString = applyRules("A", depth);
        totalSteps = curveString.length();
        currentStep = 0;
        frameRate(frameRate); // set the frame rate
    }

    public void draw() {
       
        if (currentStep < totalSteps) {
            //stroke(255);
            //strokeWeight(2);
            String curveString = applyRules("A", depth);
            drawString(curveString.charAt(currentStep));
            currentStep++;
        } else {
            
            currentStep = 0;
            background(0);
            x = 180;
            y = height + 97;
            translate(x - 300, y - 300); // reset the origin to the center of the frame
            
        }
    }

    public void keyPressed() {
        if (key == '+') {
            frameRate(frameRate += 10); // increase the frame rate when the "+" key is pressed
        }
        if (key == '-') {
            frameRate(frameRate -= 10); // decrease the frame rate when the "-" key is pressed
        }
    }

    public String applyRules(String s, float depth) {
        if (depth == 0) {
            return s;
        }
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                result += "A-B--B+A++AA+B-";
            } else if (c == 'B') {
                result += "+A-BB--B-A++A+B";
            } else {
                result += c;
            }
        }
        return applyRules(result, depth - 1);
    }

    public void drawString(char c) {
        Stack<Turtle> stack = new Stack<Turtle>();
          stroke(153, 187, 255);
          strokeWeight((float) 1);
          
        float len = pow((float) 2.4, (float) (depth - 2.2));
        if (c == 'A' || c == 'B') {
            line(x - width / 2, y - height / 2, x - width / 2 + len * cos(angle), y - height / 2 + len * sin(angle));
            x += len * cos(angle);
            y += len * sin(angle);
        } else if (c == '+') {
            angle += radians(60);
        } else if (c == '-') {
            angle -= radians(60);
        } else if (c == '|') {
            angle += radians(180);
        } else if (c == '[') {
            stack.push(new Turtle(x, y, angle));
        } else if (c == ']') {
            Turtle previous = stack.pop();
            x = previous.x;
            y = previous.y;
            angle = previous.angle;
        }
    }

    class Turtle {

        float x, y;
        float angle;

        Turtle(float x, float y, float angle) {
            this.x = x;
            this.y = y;
            this.angle = angle;
        }
    }
}

import processing.core.PApplet;
import processing.core.PVector;
public class Sierpinski_Curve extends PApplet{
    float cx = 0;
    float cy= height ;
    int h;
    public void settings(){
        size(1000,1000);
        smooth(16);
    }
    public void setup(){
        colorMode(HSB,360,255,255);
        background(0);
    }
    public void lineTo(float newX,float newY) {
        line(cx, cy, newX, newY);
        fill(0);
        cx = newX;
        cy = newY;
    }
    public void lineN(){
        lineTo(cx,cy-2*h);
    }
    public void lineS(){
        lineTo(cx,cy+2*h);
    }
    public void lineE(){
        lineTo(cx+2*h,cy);
    }
    void lineW(){
        lineTo(cx-2*h,cy);
    }
    public void lineNW(){ lineTo(cx-h,cy-h);}
    public void lineNE(){ lineTo(cx+h,cy-h);}
    public void lineSE(){ lineTo(cx+h,cy+h);}
    public void lineSW(){ lineTo(cx-h,cy+h);}
    void sierN(int i){
        if (i == 1) {
            lineNE(); lineN();
            lineNW();
        }
        else {
            sierN(i-1); lineNE();
            sierE(i-1); lineN();
            sierW(i-1); lineNW();
            sierN(i-1);
        }
    }


    void sierE(int i){
        if (i == 1) {
            lineSE(); lineE();
            lineNE();
        }
        else {
            sierE(i-1); lineSE();
            sierS(i-1); lineE();
            sierN(i-1); lineNE();
            sierE(i-1);
        }
    }

    void sierS(int i){
        if (i == 1) {
            lineSW(); lineS();
            lineSE();
        }
        else {
            sierS(i-1); lineSW();
            sierW(i-1); lineS();
            sierE(i-1); lineSE();
            sierS(i-1);
        }
    }

    void sierW(int i){
        if (i == 1) {
            lineNW(); lineW();
            lineSW();
        }
        else {
            sierW(i-1); lineNW();
            sierN(i-1); lineW();
            sierS(i-1); lineSW();
            sierW(i-1);
        }
    }
    void sierpinskiCurve(int level) {
        sierN(level);
        lineNE();
        sierE(level);
        lineSE();
        sierS(level);
        lineSW();
        sierW(level);
        lineNW();
    }
    public void draw() {
        background(0);
        stroke(255);
        strokeWeight(2);
        h = 2;
        sierpinskiCurve(4);
        noLoop();
    }
    public static void main(String[] args) {
        String[] name = new String[]{"Sierpinski_Curve"};
        Sierpinski_Curve mySketch = new Sierpinski_Curve();
        PApplet.runSketch(name, mySketch);
    }
}

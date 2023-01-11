import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PVector;

public class fillCurve1 extends PApplet{
    int level =4    ;
    int N = (int) pow(2,level);
    int total = N*N;
    PVector[] path = new PVector[total];

    public void settings(){
        size(1024,1024);
        smooth();
    }
    public void setup(){
        noStroke();
        colorMode(HSB,360,255,255);
        background(0);
        for (int i = 0; i < total; i++) {
            path[i] = Hilbert(i);
            float len = width/N ;
            path[i].mult(len);
            path[i].add(len/2,len/2);
        }
        surface.setTitle("Hilbert Curve!");
        surface.setResizable(true);
        surface.setLocation(100, 100);
    }

    int counter = 0 ;
    public void draw(){
        background(0);
        stroke(255);
        strokeWeight(2);
//        beginShape();
        for (int j = 1; j <  counter; j++) {
            float hue = map (j, 0 , path.length,0,360);
            stroke(hue,255,255);
            line(path[j].x,path[j].y,path[j-1].x,path[j-1].y);
        }
//        endShape();
        counter+= 1;
        if (counter >= path.length){
            counter = 0;
        }
        text("Level: "+ level,0,40);

    }


    public PVector Hilbert (int i){
        PVector[] point = {
                new PVector(0,0),
                new PVector(0,1),
                new PVector(1,1),
                new PVector(1,0)
        };
        int index = i &3;
        PVector v = point[index];

        for (int j = 1; j < level; j++) {
            int len = (int)pow(2,j);
            i = i >>>2;
            index = i & 3;
            if (index == 0 ){ // roltate left
                float temp = v.x;
                v.x = v.y;
                v.y = temp;
            }
            else if (index == 1){
                v.y += len;
            }
            else if (index == 2){
                v.x +=len;
                v.y +=len;
            }
            else if (index == 3){
                float temp = len - 1 - v.x; // len now =
                v.x = 2* len-1-v.y  ;
                v.y = temp;
            }
        }
        return v;
    }

    public static void main(String[] args) {
        String[] name = new String[] {"fillCurve1"};
        PApplet.main(name);
    }
}

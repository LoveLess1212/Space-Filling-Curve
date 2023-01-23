import processing.core.PApplet;
import processing.core.PVector;

public class PeanoTest extends PApplet {
    int level =1;
    int N = (int) pow(3,level);
    int total = N*N;
    PVector[] path = new PVector[total];
    public void settings(){
        size(512,512);
        smooth();
    }
    public void setup(){
        colorMode(HSB,360,255,255);
        background(0);
        for (int i = 0; i < total; i++) {
            path[i] = Peano(i);
            float len = width/N ;
            path[i].mult(len);
            path[i].add(len/2,len/2);
        }
    }
    float counter = 0;
    public void draw(){
        background(0);
        stroke(255);
        noFill();
        beginShape();
        for (int i = 0; i < counter; i++) {
            vertex(path[i].x,path[i].y);
        }
        endShape();
        counter += 0.1;
        if (counter >= path.length){
            counter =0;
        }
    }
    public PVector Peano(int i) {
        PVector[] point = {
                new PVector(0, 0),
                new PVector(0, 1),
                new PVector(0, 2),
                new PVector(1, 2),
                new PVector(1, 1),
                new PVector(1, 0),
                new PVector(2, 0),
                new PVector(2, 1),
                new PVector(2,2)
        };


        return point[i];
    }
    public static void main(String[] args){
        String[] name = new String[] {"PeanoTest"};
        PApplet.main(name);
    }
}

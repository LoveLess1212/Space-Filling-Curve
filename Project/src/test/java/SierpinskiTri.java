import processing.core.PApplet;
import processing.core.PFont;

public class SierpinskiTri extends PApplet {
    final int length =700;
    int level = 1;
    int max = 2;
    PFont sourceLight;
    public void settings() {
        size(800, 800);
    }
    public void setup() {
        colorMode(HSB,360,255,255);
        sourceLight = createFont("Font/arial.ttf", 30);
        textFont(sourceLight);
        noStroke();
    }
    int counter =0;
    public void draw(){
        background(0);
        int count = (int ) (map(millis(),0,10000,1,10) % 10)+1;
        divide(width/2-length/2,width/2+length*(sqrt(3)/4),length,1,count);
        text("counter" +count ,0,40);
        text("time: "+ millis(),0,70);

    }
    @Override
    public void keyPressed() {
        if (key == CODED) {
            if (keyCode == UP && max < 13) {
                max ++;
            } else if (keyCode == DOWN && max > 1) {
                max --;
            }
        }
    }

    // this thing work, don't touch it :)))
    //create a loop of creating a triangle
    public void divide(float x, float y , float length,int level , int max){
        if(level >= max ){
            tri(x,y,length);
        }else{ // create smaller triangle
            divide(x,y,length/2,level+1,max);// at the left vertex
            divide(x+length/4,y-length*(sqrt(3)/4),length/2,level+1,max);// at the right vertex
            divide(x+length/2,y,length/2,level+1,max);//start at the top vertex
        }

    }

    public void tri(float x, float y, float length){
        triangle(x,y,x+length,y,x+length/2,  (y-length*(float)(Math.sqrt(3)/2)));
        fill(counter %360, 255,255);
        counter++;
    }

    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "SierpinskiTri" };
        PApplet.main(appletArgs);
    }
}
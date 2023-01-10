import processing.core.PApplet;
import processing.core.PVector;

public class fillCurve3 extends PApplet{
    int level =6;
    int N = (int)pow(2,level);
    //    int total =  14;
    int total =  4 * (int)pow(4,level-1);

    PVector[] path = new PVector[total];


    public void settings(){
        int size = 512;
        size(size,size);
        smooth();
    }
    public void setup(){
        colorMode(HSB,360,255,255);
        background(0);
        for (int i = 0; i < total; i++) {
            path[i] = Tri(i);
            float len = (width /N) ; // fix later - value now: 128
            path[i].mult(len);
           path[i].add(len/2,len/2);
        }
    }

    float counter = 0 ;
    public void draw(){
        background(0);
        stroke(255);
        strokeWeight(2);
//        beginShape();
        for (int j = 1; j < counter; j++) {
            float hue = map (j, 0 , path.length,0,360);
            stroke(hue,255,255);
            line(path[j].x,path[j].y,path[j-1].x,path[j-1].y);
        } // this is drawing part :V
        strokeWeight(4);
//        for (int j = 1; j < counter; j++) {
//            point(path[j].x,path[j].y);
////            text((int)path[j-1].x, (float) (path[j-1].x), (float) (path[j-1].y));
////            text((int)path[j-1].y, (float) (path[j-1].x+10), (float) (path[j-1].y+10));
////            text((int)j-1, (float) (path[j-1].x), (float) (path[j-1].y));
//        }
//        endShape();
        counter+= 1; // this is for change the speed of the animation - the higher the more speed
        if (counter >= path.length){
            counter = 0;
        }
        text("Level: "+ level,0,40);

    } // dont touch it until you done the algo :))))))))


    public PVector Tri(int i){
        PVector[] point = {
                new PVector(0,0),
                new PVector(1,0),
                new PVector(0,1),
                new PVector(1,1)
        };
        int index = i &3;
        PVector v = point[index];

        for (int j = 1; j < level; j++) {
            int len = (int)pow(2,j);
            i = i >>>2;
            index = i & 3;
            if (index == 0 ){

            }
            else if (index == 1){
                v.x += len;
            }
            else if (index == 2){
                v.y += len;

            }
            else if (index == 3){
                v.x +=len;
                v.y +=len;

            }
        }
        return v;
    }

    public static void main(String[] args) {
        String[] name = new String[] {"fillCurve1"};
        PApplet.main(name);
    }
}

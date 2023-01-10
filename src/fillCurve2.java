import processing.core.PApplet;
import processing.core.PVector;

public class fillCurve2 extends PApplet{
    int level =4 ;
    int N = (int)pow(2,level);
//    int total =  14;
    int total =  3 * (int)pow(4,level-1);

    PVector[] path = new PVector[total];


    public void settings(){
        int size = 1024;
        size(size,size);
        smooth();
    }
    public void setup(){
        colorMode(HSB,360,255,255);
        background(0);
        for (int i = 0; i < total; i++) {
            path[i] = Tri(i);
            float len = 2*(512 /N) ; // fix later - value now: 128
            path[i].mult(len);
           path[i].add(0,len);
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
        for (int j = 1; j < counter; j++) {
            point(path[j].x,path[j].y);
            text((int)path[j-1].x, (float) (path[j-1].x), (float) (path[j-1].y));
            text((int)path[j-1].y, (float) (path[j-1].x+10), (float) (path[j-1].y+10));
//            text((int)j-1, (float) (path[j-1].x), (float) (path[j-1].y));
        }
//        endShape();
        counter+= 0.1;
        if (counter >= path.length){
            counter = 0;
        }
        text("Level: "+ level,0,40);

    } // dont touch it until you done the algo :))))))))


    public PVector Tri(int i){
        PVector[] point = {
                new PVector(0,0),
                new PVector(0.5F,0.5F),
                new PVector(1,0)
        };
        int newIndexMod = i %3;
        i = i /3;
        PVector v = point[newIndexMod];

        for (int j = 1; j < level; j++) {
            int len = (int)pow(2,j-1); // now = 1,2

            int newIndexDiv = i & 3;
            if (newIndexDiv == 0) {
                float temp = v.x;
                v.x = v.y;
                v.y = temp;
            }
            else if (newIndexDiv ==1) {
                v.y += len;
            }

            else if (newIndexDiv ==2 ) {
                v.x +=len;
                v.y +=len;
            }
            else if (newIndexDiv ==3){
                float temp = len - v.x; // len now = 1 , 2
                v.x = 2* len-v.y  ;
                v.y = temp;

            }
            i = i >>>2;
        }
        return v;
    }

    public static void main(String[] args) {
        String[] name = new String[] {"fillCurve2"};
        PApplet.main(name);
    }
}

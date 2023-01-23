import processing.core.PApplet;
import processing.core.PVector;

public class PeanoCurve extends PApplet {
    int level =3;
    int N = (int) pow(3,level);
//    int total = N*N;
    int total = N*N;
    PVector[] path = new PVector[total];
    public void settings(){
        size(1024,1024);
        smooth();
    }
    public void setup(){
        colorMode(HSB,360,255,255);
        background(0);
        for (int i = 0; i < total; i++) {
            path[i] = Peano(i);
            float len = 512/N ;
            path[i].mult(len);
//            path[i].add(len/2,len/2);
//            path[i].add(2* len,len);
        }
    }
    float counter = 0;
    public void draw(){
        background(0);
        stroke(255);
        noFill();
            beginShape();
        for (int i = 0; i < total; i++) {
            vertex(path[i].x,path[i].y);
        }
         endShape();

        for (int i = 0; i < total; i++) {
            text(i,path[i].x,path[i].y);
        }
        counter = (float) (counter +0.1);
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
        int mod = i%9;

        PVector v = point[mod];
        for (int j = 1; j < level; j++) {
            int div= (int) (i/(pow(3,j+1)));
            //int len = (int) (pow(3,level)+1);
            if (div / 3 == 0){
                v.y = pow(3,j+1) - v.y-1- (div%3)*3;
                if(div == 1){
                    v.x = 2-v.x;
                }
                v.x += 10;
            }
            else if (div / 3 == 1){
                v.y = v.y+ (div%3)*3;
                if(div %2 ==0 ){
                    v.x = 2-v.x;
                }
                v.x += 10;
            }
            else if (div /3 == 2){

                v.y = pow(3,j+1) - v.y-1- (div%3)*3;
                if(div %2 ==1 ){
                    v.x = 2-v.x;
                }
                v.x +=6*j+10;
            }
        }
        return v;
    }
    public static void main(String[] args){
        String[] name = new String[] {"PeanoCurve"};
        PApplet.main(name);
    }
}

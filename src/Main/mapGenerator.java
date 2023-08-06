package Main;




import java.awt.*;

public class mapGenerator {
    protected int map[][];
    public int brickWidth;
    public int brickHeight;

    public int temp=0;

    public mapGenerator(int row, int col){



        map= new int[row][col];
        for(int i=0 ; i< map.length ; i++){
            for(int j=0 ; j<map[0].length ; j++){


                if((i*j+temp*temp+1)%10==0)
                {
                    map[i][j]=1;

                }
            }
        }



        brickWidth= 580/col;
        brickHeight= 240/row;


    }








    // every brick er color change %3,5,8 diye change

    public void draw(Graphics2D g){
        for(int i=0 ; i< map.length ; i++){
            for(int j=0 ; j<map[0].length ; j++){
                if(map[i][j]>0){

                    if((i*j+temp*temp+1)%10==0)
                        g.setColor(Color.orange);

                    g.fillRect(j*brickWidth+80, i*brickHeight+50 , brickWidth, brickHeight);
                    g.setStroke(new BasicStroke(3));
//                    g.setColor(Color.black);
//                    g.drawRect(j*brickWidth+80, i*brickHeight+50 , brickWidth, brickHeight);
                }
            }
        }
    }

    public void setBrickValue( int row){

        temp+=row;

    }




}

package Main;




import java.awt.*;

public class mapGenerator {
    protected int map[][];
    public int brickWidth;
    public int brickHeight;





    public mapGenerator(int temp,int row, int col){



        map= new int[row][col];
        for(int i=0 ; i< map.length ; i++){
            for(int j=0 ; j<map[0].length ; j++){


                if((i*j+1)%(temp+4)==0)
                {
                    map[i][j]=1;

                }
            }
        }



        brickWidth= 580/col;
        brickHeight= 240/row;


    }







    public void draw(Graphics2D g){
        for(int i=0 ; i< map.length ; i++){
            for(int j=0 ; j<map[0].length ; j++){
                if(map[i][j]>0){

                    if(map[i][j]== 1)
                    {
                        if((i+j)%3==1)

                            g.setColor(Color.green);
                        else if((i+j)%3==2)
                            g.setColor(Color.blue);
                        else
                            g.setColor(Color.ORANGE);
                    }

                    g.fillRect(j*brickWidth+80, i*brickHeight+50 , brickWidth, brickHeight);
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j*brickWidth+80, i*brickHeight+50 , brickWidth, brickHeight);
                }
            }
        }
    }
}

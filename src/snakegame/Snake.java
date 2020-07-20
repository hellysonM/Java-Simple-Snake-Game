
package snakegame;

import java.awt.Color;
import java.awt.Graphics;


public class Snake implements Block{
    public  int X;
    public  int Y;
    

    public Snake(int x,int y) {
        X = x;
        Y = y;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(X, Y, DrawPanel.BLOCK_SIZE, DrawPanel.BLOCK_SIZE);
    }

    @Override
    public int getX() {
        return this.X;
    }

    @Override
    public int getY() {
       return this.Y;
    }

    public void moveX(int x){
        this.X+=x;
    }
    
    public void moveY(int y){
        this.Y+=y;
        
    }
    
    @Override
    public void setX(int x) {
        this.X = x;
    }

    @Override
    public void setY(int y) {
        this.Y = y;
    }

    public String toString(){
       
         return String.format("X : %d | Y : %d",this.getX(),this.getY());
                 
    }
            
            
         
    
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Hellyson
 */
public class Apple implements Block {
    public  int X;
    public  int Y;
    
    public Apple(int x,int y) {
        X = x;
        Y = y;
    }

    @Override
    public void draw(Graphics g) {
      g.setColor(Color.RED);
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

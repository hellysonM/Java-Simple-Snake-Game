package snakegame;

import java.awt.Graphics;

public interface Block {
   public void draw(Graphics g);
   public int getX();
   public int getY();
   public void setX(int x);
   public void setY(int y);
  
}

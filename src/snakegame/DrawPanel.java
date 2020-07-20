package snakegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

import javax.swing.JPanel;

public final class DrawPanel extends JPanel implements Runnable,KeyListener{
    
    public static final int BLOCK_SIZE = 20;
    public static final int BLOCK_MOVE = 20;
    
    
    private int direction = 1;// 0 - left / 1 - righ / 2 - up / 3 - down
    private Thread thread;
    
    Snake firstBlock;
    private Apple a; 
    ArrayList<Block>blocks;       
    public static int BLOCK_ARRAY_SIZE;
    
    public DrawPanel(){
      
        blocks = new ArrayList<>();
        
        BLOCK_ARRAY_SIZE = blocks.size();
        
        Random r = new Random();
        
        
        
        a = new Apple((r.nextInt(37)+1)*BLOCK_SIZE,(r.nextInt(26)+1)*BLOCK_SIZE);
        
        
        Snake b = new Snake(BLOCK_SIZE,BLOCK_SIZE);
        
        blocks.add(b);
        
        firstBlock = (Snake)blocks.get(0);

        this.addKeyListener(this);
        this.setFocusable(true);
        
        thread = new Thread(this);
        thread.start();
        
       
    }
    
        
    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g); 
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        g.setColor(Color.GRAY);
        
        for(Block b : blocks) {
            b.draw(g);
        }
        a.draw(g);
        
        g.setColor(Color.MAGENTA);
        g.drawRect(BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE*37, BLOCK_SIZE*26);
        
    }
    
    @Override
    public void run() {
             
            while(true){

                 if(blocks.get(0).getX()== a.getX() &&
                      blocks.get(0).getY()== a.getY()){
                   
                     Random r = new Random();
                     
                     a.setX((r.nextInt(37)+1)*BLOCK_SIZE);
                     a.setY((r.nextInt(26)+1)*BLOCK_SIZE);
 
                    BLOCK_ARRAY_SIZE = blocks.size()-1;
                    
                     switch (direction) {
                         case 0:
                             blocks.add(new Snake(blocks.get(BLOCK_ARRAY_SIZE).getX()+BLOCK_SIZE, blocks.get(BLOCK_ARRAY_SIZE).getY()));
                             break;
                         case 1:
                             blocks.add(new Snake(blocks.get(BLOCK_ARRAY_SIZE).getX()-BLOCK_SIZE, blocks.get(BLOCK_ARRAY_SIZE).getY()));
                             break;
                         case 2:
                             blocks.add(new Snake(blocks.get(BLOCK_ARRAY_SIZE).getX(), blocks.get(BLOCK_ARRAY_SIZE).getY()+BLOCK_SIZE));
                             break;
                         case 3:
                             blocks.add(new Snake(blocks.get(BLOCK_ARRAY_SIZE).getX(), blocks.get(BLOCK_ARRAY_SIZE).getY()-BLOCK_SIZE));
                             break;
                         default:
                             break;
                     }         
                }
                 
                 for(Block block : blocks) {
                    if(block.getX()>740)
                       block.setX(20);
                    if(block.getY()>520)
                        block.setY(20);
                    if(block.getX()<20)
                        block.setX(740);
                    if(block.getY()<20)
                        block.setY(520);
                           
                }
                 
                 for (int i = 1; i < blocks.size(); i++) {
                    if(blocks.get(i).getX()==blocks.get(0).getX() && blocks.get(i).getY()==blocks.get(0).getY()){
                        JOptionPane.showMessageDialog(this,"Você perdeu");
                        System.exit(0);
                    }       
                }
                 
                repaint();
                
                
                switch(direction){
                    case 0:
                        SnakeMovement(-BLOCK_MOVE,0)
                            ;break;
                    case 1 :
                        SnakeMovement(BLOCK_MOVE, 0)
                            ;break;
                    case  2 :
                        SnakeMovement(0, -BLOCK_MOVE)
                            ;break;
                    case  3 :
                        SnakeMovement(0, BLOCK_MOVE)
                            ;break;
                }
                   
                
                
             try { 
                thread.sleep(50); 
             }
 
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
                
              
        } 
    }
    
    
   public void SnakeMovement(int moveX,int moveY) {
      
     
       
        ArrayList<Block> old = new ArrayList<>();

        for(Block block : blocks){
            old.add(new Snake(block.getX(), block.getY()));
        }
        
        

        firstBlock.moveX(moveX);
        firstBlock.moveY(moveY);
     
        if(blocks.size()>1){

            for (int i = 1; i < blocks.size(); i++) {
                
                blocks.get(i).setX(old.get(i-1).getX());
                blocks.get(i).setY(old.get(i-1).getY());
            }
         }
   }
    

    @Override
    public void keyPressed(KeyEvent e) {
  
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                if(direction!=0){
                    
                    this.direction = 1;
                    //SnakeMovement(BLOCK_MOVE, 0);
                    
                }       break;
            case KeyEvent.VK_LEFT:
                if(direction!=1){
                    
                    this.direction = 0; 
                    //SnakeMovement(-BLOCK_MOVE,0);
                    
                }   break;
            case KeyEvent.VK_UP:
                if(direction!=3){
                    
                    this.direction = 2;  
                   // SnakeMovement(0,-BLOCK_MOVE);
                    
                }   break;
            case KeyEvent.VK_DOWN:
                if(direction !=2){
                    
                    this.direction = 3;
                   // SnakeMovement(0,BLOCK_MOVE);
                    
                }   break;
            default:
                break;
        }
   
    }

   
    @Override
    public void keyReleased(KeyEvent e) {        
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

  
    
    
}

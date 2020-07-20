package snakegame;

import javax.swing.JFrame;

public class Game extends JFrame {
    
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    
    
    
    public Game(){
        
        super("SNAKE GAME BY: HELLYSON");
        
        DrawPanel panel = new DrawPanel();
       
        super.add(panel);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setSize(WIDTH,HEIGHT);
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        super.setVisible(true);
         
        
    }
    

    public static void main(String[] args) {
       
       Game game = new Game();
       
        
    }  
}

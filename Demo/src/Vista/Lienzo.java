/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;







/**
 *
 * @author jairo
 */
public class Lienzo extends Canvas{
    public Graphics g;
    public BufferStrategy estrategia;
  
    
    
    public Lienzo(){      
        this.setBackground(Color.WHITE);
           
    }
    
    public void iniciar(){
          this.createBufferStrategy(2);
          estrategia=this.getBufferStrategy();
    }
    
   
  
    
    
   
}

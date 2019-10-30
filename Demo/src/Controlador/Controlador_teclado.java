/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author jairo
 */
public class Controlador_teclado implements KeyListener {

    private Hilo h;

    public Controlador_teclado(Hilo h) {
        this.h = h;
    }
    
    
    
    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode()==KeyEvent.VK_UP){
            this.h.cambiar_accion("saltar");
        }
        if(ke.getKeyCode()==KeyEvent.VK_C){
            this.h.cambiar_accion("caminar");
        }
        if(ke.getKeyCode()==KeyEvent.VK_SPACE){
            this.h.cambiar_accion("morir");
        }
        if(ke.getKeyCode()==KeyEvent.VK_Z){
            this.h.cambiar_accion("atacar");
        }
        if(ke.getKeyCode()==KeyEvent.VK_X){
            this.h.cambiar_accion("escudar");
        }
        if(ke.getKeyCode()==KeyEvent.VK_V){
            this.h.cambiar_accion("parado");
        }
        if(ke.getKeyCode()==KeyEvent.VK_LEFT){
            this.h.cambiar_dir("izquierda");
        }
        if(ke.getKeyCode()==KeyEvent.VK_RIGHT){
            this.h.cambiar_dir("derecha");
        }
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
    
}

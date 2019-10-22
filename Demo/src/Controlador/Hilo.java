/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Lienzo;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import personajes.*;


/**
 *
 * @author jairo
 */
public class Hilo implements Runnable {

    Lienzo l;
    private final int tam=50;
    private Personaje prototipo=new Deku();
    private Fabrica_personaje fp;
    private ArrayList<Personaje> clones=new ArrayList<Personaje>();
    private boolean vivo=true;
    public Hilo(Lienzo l) {
        this.l = l;
        
        
        
    }
    
    
    @Override
    public void run() {
        l.iniciar();
        Graphics g=l.estrategia.getDrawGraphics();
        prototipo.setAccion("c");
        prototipo.asignarAccion();
        while(vivo){
        
       
        
        g.drawImage(prototipo.getImagen(), prototipo.getX(),prototipo.getY(),tam,tam, l);
        prototipo.avanzar();
        for(int i=0;i<clones.size();i++){
             g.drawImage(clones.get(i).getImagen(),clones.get(i).getX(),clones.get(i).getY(),tam,tam, l);
             clones.get(i).avanzar();
        }
        
        l.estrategia.show();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        l.paint(g);
    }
        
    }
    
    
    //cambiar el tipo de personaje
    public void asignar_tipo(String t){
        
        switch(t){
            case "deku":
                fp=new Fabrica_deku();
                break;
            case "zora":
                fp=new Fabrica_zora();
                break;
            case "goron":
                fp=new Fabrica_goron();
                break;    
            case "gerudo":
                fp=new Fabrica_gerudo();
                break;
            default:
                break;
           
        }
        
        prototipo=fp.get_personaje(prototipo.getAccion(),prototipo.getDireccion(),prototipo.getX(),prototipo.getY());
       
    }
    // clonar el personaje prototipo
    
    public void clonar(){
        try {
            clones.add(prototipo.clonar());
            int i=clones.size()-1;
            if(i==0){
            int x=clones.get(i).getX();
            clones.get(i).setX(x+tam);
            clones.get(i).asignarAccion();
            }else{
               int x=clones.get(i-1).getX();
               int y=clones.get(i-1).getY();
               if(x<l.getWidth()-tam){
               clones.get(i).setX(x+tam);
               clones.get(i).setY(y);
               }else{
                  clones.get(i).setX(0);
                  clones.get(i).setY(y+tam);
               }
               clones.get(i).asignarAccion(); 
            }
            } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void cambiar_accion(String s){
        this.prototipo.setAccion(s);
        this.prototipo.asignarAccion();
    }
    public void cambiar_dir(String d){
        this.prototipo.setDireccion(d);
        
    }
    
}

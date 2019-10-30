/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Lienzo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
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
    private final int tam1x=10;
    private final int tam1y=10;
    private final int dis=100;
    private Personaje prototipo=new Deku();
    private Poblacion poblacion=new Poblacion();
    private Fabrica_personaje fp;
    private ArrayList<Personaje> clones=new ArrayList<>();
    private ArrayList<Proyectil> pro=new ArrayList<>();
    private boolean vivo=true;
    private  Graphics g;
    private Rectangle r=null;
    public Hilo(Lienzo l) {
        this.l = l;       
    }
    public void setR(Rectangle r) {
        this.r = r;
       
    }
    
    @Override
    public void run() {
        l.iniciar();
        g=l.estrategia.getDrawGraphics();
        prototipo.setAccion("p");
        prototipo.asignarAccion();
        g.setColor(Color.lightGray);
       
        while(vivo){
        
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, tam, tam);
        g.drawImage(prototipo.getImagen(), prototipo.getX(),prototipo.getY(),tam,tam, l);
        prototipo.avanzar();
        for(int i=0;i<clones.size();i++){
             if(poblacion.getPoblacion().contains(clones.get(i))){
                 g.setColor(Color.lightGray);
                 g.fillRect(clones.get(i).getX(), clones.get(i).getY(), tam, tam);
                 
             }
             
            g.drawImage(clones.get(i).getImagen(), clones.get(i).getX(),clones.get(i).getY(),tam,tam, l);
            clones.get(i).avanzar(); 
            if(clones.get(i).getAccion().charAt(0)=='a'){
                
                pro.add(clones.get(i).get_proyectil());
            }
             }
        for(int i=0;i<pro.size();i++){
            g.drawImage(pro.get(i).getImagen(), pro.get(i).getX(),pro.get(i).getY()+10,tam1x,tam1y, l);
            pro.get(i).mover();
            if(pro.get(i).getX()-tam1x<=0 || pro.get(i).getX()-tam1x>=l.getWidth()){
                pro.remove(pro.get(i));
                        
            }
        }
        
        if(r!=null){
            g.setColor(Color.BLACK);
            g.drawRect(r.x,r.y,r.width,r.height);
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
            clones.get(i).setX(dis+x+tam);
            clones.get(i).asignarAccion();
            }else{
               int x=clones.get(i-1).getX();
               int y=clones.get(i-1).getY();
               if(x+2*tam+3*dis<=l.getWidth()){
               clones.get(i).setX(x+tam+dis);
               clones.get(i).setY(y);
               }else{
                  clones.get(i).setX(dis);
                  clones.get(i).setY(y+tam);
               }
               clones.get(i).asignarAccion(); 
            }
            } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void cambiar_accion(String s){
        this.poblacion.setAccion(s);
        this.poblacion.asignarAccion();
        
    }
    public void cambiar_dir(String d){
        this.poblacion.setDireccion(d);
        
    }
    public void intersectar(int x,int y){
        for(int i=0;i<clones.size();i++){
            if(clones.get(i).getX()<=x && clones.get(i).getX()+tam>=x){
                 if(clones.get(i).getY()<=y && clones.get(i).getY()+tam>=y){
                     if(poblacion.getPoblacion().contains(clones.get(i))){
                         poblacion.quitar(clones.get(i));
                     }else{
                         poblacion.agregar(clones.get(i));
                     }                     
                
            }
                
            }
        }
    }
    public void intersectar(Rectangle r){
        for(int i=0;i<clones.size();i++){
            if(probar(clones.get(i),r)){
                if(!poblacion.getPoblacion().contains(clones.get(i))){
                    poblacion.agregar(clones.get(i));
                    
                }
            }
        }
    }


    private boolean probar(Personaje p,Rectangle r){
        return (p.getX()>=r.x || p.getX()+tam>=r.x) &&
                (p.getY()>=r.y || p.getY()+tam>=r.y) &&
                 (p.getX()<=r.x+r.width || p.getX()+tam<=r.x+r.width) &&
                (p.getY()<=r.y+r.height || p.getY()+tam<=r.y+r.height);
    }
}
   

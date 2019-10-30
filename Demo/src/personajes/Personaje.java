/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personajes;

import java.awt.image.BufferedImage;

/**
 *
 * @author jairo
 */
public abstract class Personaje implements Cloneable{
    protected String direccion;
    protected BufferedImage imagenes[];
    protected int indice;
    protected int x,y;
    protected String accion;
    protected Fabrica_proyectil fp;
    public void setAccion(String accion) {
        this.accion = accion;
        indice=0;
    }
   
    protected String ruta="src/personajes/imagenes/";
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public Personaje clonar() throws CloneNotSupportedException{
        return (Personaje) super.clone();
    }
    
    
    
    public BufferedImage getImagen(){
        return this.imagenes[this.indice];
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
        asignarAccion();
    }
    
    
    public  void avanzar(){
        this.indice=(this.indice+1)%this.imagenes.length;
    }
    public abstract void asignarAccion();
    public  Proyectil get_proyectil(){
        int dx;
        if(this.direccion.charAt(0)=='i'){
            dx=-50;
        }else{
            dx=50;
        }
        
        return this.fp.get_proyectil(x+dx, y, dx);
    };
    public String getDireccion() {
        return direccion;
    }

    public String getAccion() {
        return accion;
    }
    
    
}

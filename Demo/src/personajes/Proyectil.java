/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personajes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author jairo
 */
public abstract class Proyectil {
    protected int x,y,dx;
    protected String ruta="src/personajes/imagenes/";
    protected BufferedImage imagen;
    public void mover(){
        x+=dx;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Proyectil(int x, int y, int dx) {
        this.x = x;
        this.y = y;
        this.dx = dx;
    }
    public void leer_imagen(){
        try {
            this.imagen=ImageIO.read(new File(this.ruta));
        } catch (IOException ex) {
            Logger.getLogger(Proyectil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public BufferedImage getImagen(){
        return this.imagen;
    }
    
    
}

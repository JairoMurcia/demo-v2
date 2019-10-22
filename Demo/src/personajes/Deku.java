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
public class Deku extends Personaje {

    public Deku() {
        this.direccion="d";
        this.indice=0;
         this.ruta+="deku/";
    }
    
    
    
    
    @Override
    public void asignarAccion() {
        
        
       String s=ruta;
        char c=accion.toLowerCase().charAt(0);
        int cant=1;
        switch (c) {
            case 'c':
                cant=4;
                break;
            case 'm':
                cant=4;
                break;
            case 's':
                cant=2;
                break;
            case 'p':
                cant=1;
                break;    
            default:
                break;
        }
        
       
         s+=c;
        if(direccion.charAt(0)=='d'){
                s+='d';
            }else{
                s+='i';
            }
        this.imagenes=new BufferedImage[cant];
        
        for(int i=0;i<cant;i++){
            try {
                this.imagenes[i]=ImageIO.read(new File(s+(i+1)+".png"));
            } catch (IOException ex) {
                Logger.getLogger(Deku.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
   }
    
}

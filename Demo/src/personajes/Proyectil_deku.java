/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personajes;

/**
 *
 * @author jairo
 */
public class Proyectil_deku extends Proyectil {

    public Proyectil_deku(int x,int y , int dx) {
        super(x,y,dx);
        this.ruta+="deku/pro.png";   
        this.leer_imagen();
    }
    
}

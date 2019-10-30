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
public class Proyectil_zora extends Proyectil {

    public Proyectil_zora(int x, int y, int dx) {
        super(x,y,dx);
        this.ruta+="zora/pro.png";
        this.leer_imagen();
    }
    
}

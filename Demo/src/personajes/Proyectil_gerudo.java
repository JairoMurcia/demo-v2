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
public class Proyectil_gerudo extends Proyectil {

    public Proyectil_gerudo(int x, int y, int dx) {
        super(x,y,dx);
        this.ruta+="gerudo/pro.png";
        this.leer_imagen();
    }
    
}

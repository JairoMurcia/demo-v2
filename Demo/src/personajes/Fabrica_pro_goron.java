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
public class Fabrica_pro_goron extends Fabrica_proyectil {

    @Override
    public Proyectil get_proyectil(int x, int y, int dx) {
        return new Proyectil_goron(x,y,dx);
    }

    
    
}

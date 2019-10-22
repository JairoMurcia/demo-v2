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
public class Fabrica_deku extends Fabrica_personaje {

    
    public Personaje get_personaje() {
        return new Deku();
    }

    @Override
    public Personaje get_personaje(String accion, String direccion, int x, int y) {
        Personaje d =new Deku();
        d.setAccion(accion);
        d.setDireccion(direccion);
        d.setX(x);
        d.setY(y);
        return d;
    }
    
    
}

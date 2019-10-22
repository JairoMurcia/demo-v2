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
public class Fabrica_goron extends Fabrica_personaje{

    @Override
    public Personaje get_personaje() {
        return new Goron();
    }
     @Override
    public Personaje get_personaje(String accion, String direccion, int x, int y) {
        Personaje d =new Goron();
        d.setAccion(accion);
        d.setDireccion(direccion);
        d.setX(x);
        d.setY(y);
        return d;
    }
}

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
public abstract class Fabrica_personaje {
    
    public abstract Personaje get_personaje();
    public abstract Personaje get_personaje(String accion,String direccion,int x,int y);
}

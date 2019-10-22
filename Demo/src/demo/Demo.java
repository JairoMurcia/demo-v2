/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import Controlador.*;
import Vista.Ventana;

/**
 *
 * @author jairo
 */
public class Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ventana v=new Ventana();
        Hilo h=new Hilo(v.l);
        Controlador_teclado ct=new Controlador_teclado(h);
        Controlador_botones cb=new Controlador_botones(h);
        v.agregar_listeners(cb, ct);
        v.mostrar();
        h.run();
        
    }
    
}

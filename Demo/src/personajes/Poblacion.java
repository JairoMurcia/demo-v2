/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personajes;

import java.util.ArrayList;

/**
 *
 * @author jairo
 */
public class Poblacion extends Personaje {
    private ArrayList<Personaje> poblacion=new ArrayList<>();
    
    
    @Override
    public void setDireccion(String d){
        for(int i=0;i<poblacion.size();i++){
            poblacion.get(i).setDireccion(d);
           
        }
    }
    public void agregar(Personaje p){
        poblacion.add(p);
    }
    public void quitar(Personaje p){
        poblacion.remove(p);
    }

    public ArrayList<Personaje> getPoblacion() {
        return poblacion;
    }
    
    @Override
    public void asignarAccion() {
       for(int i=0;i<poblacion.size();i++){
            poblacion.get(i).setAccion(this.accion);
            poblacion.get(i).asignarAccion();
        }
    }
}

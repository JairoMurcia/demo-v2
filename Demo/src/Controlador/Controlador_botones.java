/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author jairo
 */
public class Controlador_botones implements ActionListener {
    private Hilo h;
    
    public Controlador_botones(Hilo h){
        this.h=h;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("clonar")){
            h.clonar();
        }
        if(ae.getActionCommand().equals("deku")){
            h.asignar_tipo("deku");
        }
        if(ae.getActionCommand().equals("goron")){
           h.asignar_tipo("goron");
        }
        if(ae.getActionCommand().equals("gerudo")){
            h.asignar_tipo("gerudo");
        }
        if(ae.getActionCommand().equals("zora")){
           h.asignar_tipo("zora");
        }
        if(ae.getActionCommand().equals("teclas")){
           JFrame f=new JFrame();
           String s="<html><body>Presione la tecla correspondiente a cada accion<br>";
           s+="caminar :tecla c <br>";
           s+="saltar:flecha hacia arriba<br>";
           s+="cambia de direccion:flecha izquierda y derecha<br> ";
           s+="morir : barra espaciadora";
           s+="quedarse parado: tecla v<br>";
           s+="cubrirse: tecla x<br>";
           s+="atacar:tecla z";
           s+="Solo se puede cambiar las accciones";
           s+="a personajes seleccionados los cuales tienen un recuadro gris atras.<br>";
           s+="Para seleccionar haga click sobre uno o seleccione varios dejando presionado y arrastrando el mouse<br>";
           s+="se puede deselecionar haciendo click sobre la imagen otra vez</body></html>";
           JLabel l=new JLabel(s);
           f.add(l);
           f.setSize(300,280);
           f.setLocationRelativeTo(null);
           f.setVisible(true);
        }
    }
    
    
}

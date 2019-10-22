/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Hilo;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;


import javax.swing.JFrame;
import javax.swing.JRadioButton;

/**
 *
 * @author jairo
 */
public class Ventana extends JFrame {
    public Lienzo l;
    private JButton clonar=new JButton("Clonar");
    private JRadioButton deku=new JRadioButton("Deku");
    private JRadioButton goron=new JRadioButton("Goron");
    private JRadioButton gerudo=new JRadioButton("Gerudo");
    private JRadioButton zora=new JRadioButton("Zora"); 
    private ButtonGroup grupo=new ButtonGroup();
    private JButton teclas=new JButton("Instrucciones");
    public Ventana(){
        Container c=getContentPane();
        c.setLayout(null);
        l=new Lienzo();
        c.add(l);
        l.setBounds(10,10,450,440);
        c.add(clonar);
        clonar.setBounds(10,460,120,20);
        c.add(deku);
        deku.setBounds(130,460,60,20);
        c.add(goron);
        goron.setBounds(190,460,60,20);
        c.add(gerudo);
        gerudo.setBounds(250,460,80,20);
        c.add(zora);
        zora.setBounds(330,460,60,20);
        c.add(teclas);
        teclas.setBounds(390,460,120,20);
        
        grupo.add(deku);
        grupo.add(goron);
        grupo.add(gerudo);
        grupo.add(zora);
        deku.setSelected(true);
    }
     public void mostrar(){
        this.setSize(500,530);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       
        
    }
     public void agregar_listeners(ActionListener al,KeyListener ke){
        clonar.addActionListener(al);
        clonar.setActionCommand("clonar");
        clonar.setFocusable(false);
        clonar.setFocusTraversalKeysEnabled(true);
       
        teclas.addActionListener(al);
        teclas.setActionCommand("teclas");
        teclas.setFocusable(false);
        teclas.setFocusTraversalKeysEnabled(true);
        
        deku.addActionListener(al);
        deku.setActionCommand("deku");
        deku.setFocusable(false);
        deku.setFocusTraversalKeysEnabled(true);
        gerudo.addActionListener(al);
        gerudo.setActionCommand("gerudo");
        gerudo.setFocusable(false);
        gerudo.setFocusTraversalKeysEnabled(true);
        zora.addActionListener(al);
        zora.setActionCommand("zora");
        zora.setFocusable(false);
        zora.setFocusTraversalKeysEnabled(true);
        goron.addActionListener(al);
        goron.setActionCommand("goron");
        goron.setFocusable(false);
        goron.setFocusTraversalKeysEnabled(true);
        addKeyListener(ke);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
     }

    
}

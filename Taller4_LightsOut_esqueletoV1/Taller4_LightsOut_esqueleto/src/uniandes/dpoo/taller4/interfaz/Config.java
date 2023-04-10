package uniandes.dpoo.taller4.interfaz;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Config extends JPanel implements ActionListener{
    private ButtonGroup group ;
    private JComboBox<String> opcionesTamanos;
    private JRadioButton facil  ;
    private JRadioButton medio ;
    private JRadioButton dificil ;
    private VentanaLightsOut parent;
    private String[] tamanos = {"3x3", "4x4", "5x5", "6x6","7x7"};

    public JComboBox<String> getTamanos(){
        return this.opcionesTamanos;
    }

    public Config(VentanaLightsOut parent){
        super(new GridLayout(1,0));
        this.parent = parent;
        group = new ButtonGroup();
        opcionesTamanos = new JComboBox<String>(tamanos);
        opcionesTamanos.setSelectedIndex(4);

        Label labelTamanos = new Label("Tamano");
        Label labelDificultad = new Label("Dificultad:");
        facil = new JRadioButton("facil");
        facil.setSelected(true);
        medio = new JRadioButton("medio");
        dificil = new JRadioButton("dificil");

        group.add(facil);
        group.add(medio);
        group.add(dificil);

        opcionesTamanos.addActionListener(this);
        facil.addActionListener(this);
        medio.addActionListener(this);
        dificil.addActionListener(this);

        this.add(labelTamanos);
        this.add(opcionesTamanos);
        this.add(labelDificultad);
        this.add(facil);
        this.add(medio);
        this.add(dificil);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.opcionesTamanos)){
            System.out.println("tamanio tocado");

        }

    }

}

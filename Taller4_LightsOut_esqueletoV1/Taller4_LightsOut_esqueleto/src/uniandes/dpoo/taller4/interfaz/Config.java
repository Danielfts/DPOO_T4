package uniandes.dpoo.taller4.interfaz;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.*;
import uniandes.dpoo.taller4.modelo.Tablero;

public class Config extends JPanel implements ActionListener {
    private ButtonGroup group;
    private JComboBox<String> opcionesTamanos;
    private JRadioButton facil;
    private JRadioButton medio;
    private JRadioButton dificil;
    private VentanaLightsOut parent;
    private String[] tamanos = { "3x3", "4x4", "5x5", "6x6", "7x7" };
    private Tablero tab;
    private TableroVista tableroVista;
    private Control control;
    private int size;

    public JComboBox<String> getTamanos() {
        return this.opcionesTamanos;
    }

    public Config(VentanaLightsOut parent, TableroVista tableroVista, Control control) {
        super(new GridLayout(1, 0));
        this.parent = parent;
        this.tableroVista = tableroVista;
        this.control = control;
        this.control.setTablero(tab);
        group = new ButtonGroup();
        opcionesTamanos = new JComboBox<String>(tamanos);
        opcionesTamanos.setSelectedIndex(2);

        Label labelTamanos = new Label("Tamano");
        Label labelDificultad = new Label("Dificultad:");
        facil = new JRadioButton("facil");
        facil.setActionCommand("1");
        facil.setSelected(true);
        medio = new JRadioButton("medio");
        medio.setActionCommand("5");
        dificil = new JRadioButton("dificil");
        dificil.setActionCommand("10");

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

        this.control.setDificultad(1);

    }

    public void setTablero(Tablero tab){
        this.tab = tab;
    }

    public void cambiarTablero(int size) {
        this.parent.cambiarTablero(size);
    }

    public int getTabSize(){
        return this.size;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.opcionesTamanos)) {
            System.out.println("tamanio tocado");
            JComboBox<String> cb = (JComboBox<String>) e.getSource();
            String data = (String) cb.getSelectedItem();
            System.out.println(data.substring(0, 1));
            this.size = Integer.parseInt(data.substring(0, 1));
            cambiarTablero(size);
        }
        else{
            System.out.println("dificultad cambiada " + e.getActionCommand());
            control.setDificultad(Integer.parseInt(e.getActionCommand()));
        }

    }

}

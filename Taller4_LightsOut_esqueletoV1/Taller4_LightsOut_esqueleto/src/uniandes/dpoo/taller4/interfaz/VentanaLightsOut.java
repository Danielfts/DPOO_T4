package uniandes.dpoo.taller4.interfaz;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import uniandes.dpoo.taller4.modelo.*;


public class VentanaLightsOut extends JFrame{

    private Tablero tab;
    private Top10 top10;
    private Config config;
    private Info info;
    private Control control;
    private TableroVista tableroVista;
    private int size = 5;

    public VentanaLightsOut(){
        FlatLightLaf.install();
        top10 = new Top10();
        tab = new Tablero(size);
        info = new Info(this);
        tableroVista = new TableroVista(this);
        control = new Control(this);
        config = new Config(this, tableroVista, control);

        config.setTablero(tab);
        info.setTablero(tab);
        tableroVista.setTablero(tab, size);

        this.addMouseListener(tableroVista);
        this.addMouseListener(info);
        setLayout(new BorderLayout());
        
        this.add(config, BorderLayout.NORTH);
        this.add(info, BorderLayout.SOUTH);
        this.add(control, BorderLayout.EAST);
        this.add(tableroVista, BorderLayout.CENTER);
        setTitle("lol");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    public int getTabSize(){
        return size;
    }

    public void cambiarTablero(int n){
        this.size = n;
        tab = new Tablero(size);
        control.setTablero(tab);
        tableroVista.setTablero(tab, size);
    }

    public static void main(String[] args) {
        new VentanaLightsOut();
    }
}

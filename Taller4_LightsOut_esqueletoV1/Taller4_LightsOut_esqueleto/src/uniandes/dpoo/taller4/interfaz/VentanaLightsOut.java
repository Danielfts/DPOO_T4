package uniandes.dpoo.taller4.interfaz;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import uniandes.dpoo.taller4.modelo.*;


public class VentanaLightsOut extends JFrame{

    private Tablero tablero;
    private Top10 top10;
    private Config config;
    private Info info;
    private Control control;
    private TableroVista tableroVista;

    public VentanaLightsOut(){
        FlatLightLaf.install();
        tablero = new Tablero(5);
        top10 = new Top10();

        info = new Info(this);
        config = new Config(this);
        control = new Control(this);
        tableroVista = new TableroVista(this,5);
        config.getTamanos().addActionListener(tableroVista);

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
    public static void main(String[] args) {
        new VentanaLightsOut();
    }
}

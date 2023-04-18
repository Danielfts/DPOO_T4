package uniandes.dpoo.taller4.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;
import java.io.*;

public class Control extends JPanel implements ActionListener{
    private VentanaLightsOut parent;
    private JButton nuevo;
    private JButton reiniciar;
    private JButton botTop10;
    private JButton cambiarJugador;
    private Tablero tab;
    private Top10 top10;
    private int dificultad;
    private JDialog top10Dialog;
    
    public Control(VentanaLightsOut parent){
        super(new GridLayout(0,1));
        this.parent = parent;
        this.tab = new Tablero(5);
        nuevo = new JButton("NUEVO");
        reiniciar = new JButton("REINICIAR");
        botTop10 = new JButton("TOP-10");
        cambiarJugador = new JButton("CAMBIAR JUGADOR");

        nuevo.addActionListener(this);
        reiniciar.addActionListener(this);
        botTop10.addActionListener(this);
        cambiarJugador.addActionListener(this);

        this.add(nuevo);
        this.add(reiniciar);
        this.add(botTop10);
        this.add(cambiarJugador);
    }
    public void setDificultad(int d){
        this.dificultad = d;
    }

    public void setTablero(Tablero tab){
        this.tab = tab;

    }

    public void setTop10(Top10 top10){
        this.top10 = top10;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(reiniciar)){
            this.tab.reiniciar();
            System.out.println("reiniciar");
        }
        else if(e.getSource().equals(nuevo)){
            System.out.println("nuevo tablero");
            parent.cambiarTablero(parent.getTabSize());

            this.tab.desordenar(dificultad);

        }
        else if(e.getSource().equals(botTop10)){
            System.out.println("top10");
            File file = new File("Taller4_LightsOut_esqueletoV1/Taller4_LightsOut_esqueleto/data/top10.csv");
            this.top10.cargarRecords(file);
            this.top10Dialog = new Top10Dialog(top10.darRegistros());
        }
        else if(e.getSource().equals(cambiarJugador)){
            System.out.println("cambiar jugador");
            //NameDialog d = new NameDialog(parent);
            String S =JOptionPane.showInputDialog(parent,"Ingrese el nuevo nombre:");
            if(S.strip() != ""){
                parent.cambiarJugador(S);
            }
        }
    }

    
    
}

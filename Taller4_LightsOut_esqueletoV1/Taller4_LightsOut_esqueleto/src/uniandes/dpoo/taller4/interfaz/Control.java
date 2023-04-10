package uniandes.dpoo.taller4.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import uniandes.dpoo.taller4.modelo.Tablero;

public class Control extends JPanel implements ActionListener{
    private VentanaLightsOut parent;
    private JButton nuevo;
    private JButton reiniciar;
    private JButton top10;
    private JButton cambiarJugador;
    private Tablero tab;
    private int dificultad;
    
    public Control(VentanaLightsOut parent){
        super(new GridLayout(0,1));
        this.parent = parent;
        this.tab = new Tablero(5);
        nuevo = new JButton("NUEVO");
        reiniciar = new JButton("REINICIAR");
        top10 = new JButton("TOP-10");
        cambiarJugador = new JButton("CAMBIAR JUGADOR");

        nuevo.addActionListener(this);
        reiniciar.addActionListener(this);
        top10.addActionListener(this);
        cambiarJugador.addActionListener(this);

        this.add(nuevo);
        this.add(reiniciar);
        this.add(top10);
        this.add(cambiarJugador);
    }
    public void setDificultad(int d){
        this.dificultad = d;
    }

    public void setTablero(Tablero tab){
        this.tab = tab;

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
        else if(e.getSource().equals(top10)){
            System.out.println("top10");
        }
        else if(e.getSource().equals(cambiarJugador)){
            System.out.println("cambiar jugador");
        }
    }

    
    
}

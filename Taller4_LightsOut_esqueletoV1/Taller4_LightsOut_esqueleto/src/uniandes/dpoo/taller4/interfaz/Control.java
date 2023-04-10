package uniandes.dpoo.taller4.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Control extends JPanel implements ActionListener{
    private VentanaLightsOut parent;
    private JButton nuevo;
    private JButton reiniciar;
    private JButton top10;
    private JButton cambiarJugador;
    
    public Control(VentanaLightsOut parent){
        super(new GridLayout(0,1));
        this.parent = parent;

        nuevo = new JButton("NUEVO");
        reiniciar = new JButton("REINICIAR");
        top10 = new JButton("TOP-10");
        cambiarJugador = new JButton("CAMBIAR JUGADOR");

        this.add(nuevo);
        this.add(reiniciar);
        this.add(top10);
        this.add(cambiarJugador);
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    
    
}

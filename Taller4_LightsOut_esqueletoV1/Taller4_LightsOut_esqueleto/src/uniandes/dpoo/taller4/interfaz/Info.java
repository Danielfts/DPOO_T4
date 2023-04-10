package uniandes.dpoo.taller4.interfaz;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import uniandes.dpoo.taller4.modelo.Tablero;

public class Info extends JPanel implements ActionListener, MouseListener{
    private VentanaLightsOut parent;
    private Tablero tab;
    private JTextArea jugadas;
    private JTextArea jugador;

    public Info(VentanaLightsOut parent){
        super(new GridLayout(1,0));
        this.parent = parent;
        Label label1 = new Label("Jugadas");
        jugadas = new JTextArea("0");
        jugadas.setEditable(false);
        Label label2 = new Label("Jugador");
        jugador = new JTextArea("Daniel");
        jugador.setEditable(false);

        this.add(label1);
        this.add(jugadas);
        this.add(label2);
        this.add(jugador);
    }

    public void setTablero(Tablero tab){
        this.tab = tab;
    }


    @Override
    public void actionPerformed(ActionEvent arg0) {
        
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        this.jugadas.setText(Integer.toString( tab.darJugadas()));
        repaint();
    }
    
    @Override
    public void mouseEntered(MouseEvent arg0) {
        
    }
    
    @Override
    public void mouseExited(MouseEvent arg0) {
        
    }
    
    @Override
    public void mousePressed(MouseEvent arg0) {
        this.jugadas.setText(Integer.toString( tab.darJugadas()));
        repaint();
        
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        
    }
}

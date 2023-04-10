package uniandes.dpoo.taller4.interfaz;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Info extends JPanel implements ActionListener{
    private VentanaLightsOut parent;

    public Info(VentanaLightsOut parent){
        super(new GridLayout(1,0));
        this.parent = parent;
        Label label1 = new Label("Jugadas");
        JTextArea jugadas = new JTextArea("0");
        jugadas.setEditable(false);
        Label label2 = new Label("Jugador");
        JTextArea jugador = new JTextArea("Daniel");
        jugador.setEditable(false);

        this.add(label1);
        this.add(jugadas);
        this.add(label2);
        this.add(jugador);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}

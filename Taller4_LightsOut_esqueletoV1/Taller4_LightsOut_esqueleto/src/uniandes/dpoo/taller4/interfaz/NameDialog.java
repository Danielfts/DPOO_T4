package uniandes.dpoo.taller4.interfaz;

import java.awt.Label;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.GridLayout;

public class NameDialog extends JDialog{
    
    public NameDialog(JFrame f){
        super(f, "Nombre");
        JPanel p = new JPanel(new GridLayout(0,1));
        JLabel l = new JLabel("Ingrese el nuevo nombre");
        JTextField field = new JTextField();
        p.add(l);
        p.add(field);
        add(p);
        setSize(100,200);
        setVisible(true);
    }

}

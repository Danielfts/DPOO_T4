package uniandes.dpoo.taller4.interfaz;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableroVista extends JPanel implements ActionListener{
    private VentanaLightsOut parent;
    private int size;
    private Config config;


    public TableroVista(VentanaLightsOut parent, int size) {
        this.parent = parent;
        this.size = size;
    }

    public void setSize (int size){
        this.size = size;
        repaint();
    }

    

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.lightGray);
        int width = (int) Math.round((getWidth() / this.size) * 0.95);
        int hgap = (int) Math.round((getWidth() / this.size) * 0.05);
        int height = (int) Math.round((getHeight() / this.size) * 0.95);
        int vgap = (int) Math.round((getHeight() / this.size) * 0.05);

        int diameter = (int) (width * 0.1);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int x = ((i + 1) * (hgap)) + (i * width);
                int y = ((j + 1) * (vgap)) + (j * height);
                g2d.fillRoundRect(x, y, width - hgap, height - vgap, diameter, diameter);
            }
        }

        SwingUtilities.invokeLater(() -> {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<String> cb = (JComboBox<String>)e.getSource();
        String data = (String)cb.getSelectedItem();
        System.out.println(data.substring(0,1));
        int n =Integer.parseInt(data.substring(0,1)); 
        setSize(n);
    }


}

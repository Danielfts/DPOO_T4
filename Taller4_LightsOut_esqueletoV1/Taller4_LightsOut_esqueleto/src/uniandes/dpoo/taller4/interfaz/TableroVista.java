package uniandes.dpoo.taller4.interfaz;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import uniandes.dpoo.taller4.modelo.Tablero;

public class TableroVista extends JPanel implements ActionListener, MouseListener {
    private VentanaLightsOut parent;
    private int size;
    private Config config;
    private Tablero tab;
    private int ultima_fila;
    private int ultima_columna;

    public TableroVista(VentanaLightsOut parent) {
        this.parent = parent;
    }

    public void setTablero(Tablero tab, int size) {
        this.tab = tab;
        setSize(size);
    }

    public void setSize(int size) {
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
        boolean[][] celdas = this.tab.darTablero();
        int diameter = (int) (width * 0.1);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (celdas[i][j]) {
                    g2d.setColor(Color.yellow);
                } else {
                    g2d.setColor(Color.DARK_GRAY);
                }
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

    }


    @Override
    public void mouseClicked(MouseEvent arg0) {

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {

    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int click_x = e.getX();
        int click_y = e.getY();
        int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
        tab.jugar(casilla[1], casilla[0]);
        this.ultima_fila = casilla[0];
        this.ultima_columna = casilla[1];
        repaint();
        System.out.println("x "+ click_x + " / "+getWidth());
        System.out.println("y "+ click_y + " / "+getHeight());
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {

    }

    private int[] convertirCoordenadasACasilla(int x, int y) {
        int ladoTablero = this.size;
        int altoPanelTablero = getHeight();
        int anchoPanelTablero = getWidth();
        int altoCasilla = altoPanelTablero / ladoTablero;
        int anchoCasilla = anchoPanelTablero / ladoTablero;
        int fila = (int) (y / altoCasilla);
        int columna = (int) (x / anchoCasilla);
        System.out.println(fila + " " + columna);
        return new int[] { fila, columna };
    }

}

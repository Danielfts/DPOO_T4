package uniandes.dpoo.taller4.interfaz;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.nio.Buffer;

import uniandes.dpoo.taller4.modelo.Tablero;

import java.util.Map;
import java.util.HashMap;

import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.io.File;
import java.io.IOException;

public class TableroVista extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
    private VentanaLightsOut parent;
    private int size;
    private Config config;
    private Tablero tab;
    private int ultima_fila;
    private int ultima_columna;
    private boolean[][] celdas;
    private static BufferedImage imagen;
    private static BufferedImage scaled;

    public TableroVista(VentanaLightsOut parent) {
        cargarImagen("Taller4_LightsOut_esqueletoV1/Taller4_LightsOut_esqueleto/data/luz.png");
        this.parent = parent;
    }
    
    public void setTablero(Tablero tab, int size) {
        this.tab = tab;
        this.celdas = this.tab.darTablero().clone();
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
        int diameter = (int) (width * 0.1);
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (this.celdas[i][j]) {
                    g2d.setColor(Color.yellow);
                } else {
                    g2d.setColor(Color.DARK_GRAY);
                }
                int x = ((i + 1) * (hgap)) + (i * width);
                int y = ((j + 1) * (vgap)) + (j * height);
                g2d.fillRoundRect(x, y, width - hgap, height - vgap, diameter, diameter);
                scaleImage(imagen, width, height);
                g2d.drawImage(scaled,(int)(x+ width*0.15),(int)(y+ height*0.15),null);
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

    private static void cargarImagen(String path){
        try {
            imagen =  ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void scaleImage (BufferedImage img, int w, int h){
        Image tmp = img.getScaledInstance((int) (0.6*w), (int) (0.6* h), Image.SCALE_SMOOTH);
        BufferedImage scale = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D bGr = scale.createGraphics();
        bGr.drawImage(tmp, 0, 0, null);
        bGr.dispose();
        scaled = scale;
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
        Point p = e.getPoint();
        double click_x = p.getX();
        double click_y = p.getY();
        int[] casilla = convertirCoordenadasACasilla((int)click_x, (int)click_y);
        tab.jugar(casilla[1], casilla[0]);
        this.ultima_fila = casilla[0];
        this.ultima_columna = casilla[1];
        this.celdas = this.tab.darTablero().clone();
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
        int altoCasilla = (int) Math.round(altoPanelTablero / ladoTablero);
        int anchoCasilla = (int) Math.round(anchoPanelTablero / ladoTablero);
        int fila = (int) Math.round(y / altoCasilla);
        int columna = (int) Math.round(x / anchoCasilla);
        System.out.println(fila + " " + columna);
        System.out.println("ancho " +anchoCasilla+ " alto " + altoCasilla);
        return new int[] { fila, columna };
    }

    @Override
    public void mouseDragged(MouseEvent arg0) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        /* System.out.println(e.getX()+ "," + e.getY());
        int[] casilla = convertirCoordenadasACasilla(e.getY(), e.getX());
        boolean celda = this.celdas[casilla[0]][casilla[1]];
        if (celda){
            this.celdas[casilla[0]][casilla[1]] = false;
        }
        else{
            this.celdas[casilla[0]][casilla[1]] = true;
        }
        repaint(); */
    }

}

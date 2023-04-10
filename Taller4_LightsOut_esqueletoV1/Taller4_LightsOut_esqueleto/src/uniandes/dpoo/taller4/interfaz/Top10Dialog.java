package uniandes.dpoo.taller4.interfaz;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.util.Collection;
import uniandes.dpoo.taller4.modelo.RegistroTop10;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;

public class Top10Dialog extends JDialog {
    private ArrayList<String> listaRegistros;

    public Top10Dialog(Collection<RegistroTop10> registros){
        this.listaRegistros = new ArrayList<String>();
        for(RegistroTop10 r: registros){
            String s = r.toString();
            System.out.println(s);
            listaRegistros.add(s);
        }
        String[] strs = new String[listaRegistros.size()];
        strs = listaRegistros.toArray(strs);
        JList<String> listRegs = new JList<String>( strs);
        listRegs.setCellRenderer(new StringRenderer());
        setLayout(new BorderLayout(5,5));
        add(listRegs, BorderLayout.CENTER);
        pack();
        setTitle("Top 10 jugadores");
        setVisible(true);

    }
    
}

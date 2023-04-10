package uniandes.dpoo.taller4.interfaz;

import javax.swing.ListCellRenderer;
import java.awt.*;
import javax.swing.*;
import javax.swing.SwingConstants;

public class StringRenderer implements ListCellRenderer<String> {
    
    @Override
    public Component getListCellRendererComponent(JList<? extends String> list, String value, int index,
            boolean isSelected, boolean cellHasFocus) {
        JLabel etiqueta = new JLabel(value.toUpperCase());
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setOpaque(true);
        //etiqueta.setFont(new Font(value, index, index));
        etiqueta.setForeground(Color.white);
        if (isSelected)
            etiqueta.setBackground(Color.gray);
        else
            etiqueta.setBackground(Color.LIGHT_GRAY);
        if (cellHasFocus)
            etiqueta.setForeground(Color.cyan);
        return etiqueta;
    }

}

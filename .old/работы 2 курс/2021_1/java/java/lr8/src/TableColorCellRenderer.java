/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*; 

import java.util.ArrayList; 

import javax.swing.*; 

import javax.swing.border.EmptyBorder; 

import javax.swing.table.DefaultTableCellRenderer; 

import javax.swing.table.TableCellRenderer; 

import javax.swing.table.TableColumn; 
/**
 *
 * @author Artem
 */
public class TableColorCellRenderer extends JTextArea implements TableCellRenderer {
    private static final TableCellRenderer Renderer = new DefaultTableCellRenderer(); 

     

    public TableColorCellRenderer() { 

        setLineWrap(true); 

        setWrapStyleWord(true); 

        setOpaque(true); } 

    @Override 

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) { 

        setBackground(Color.WHITE); 
        table.setRowHeight(60);
        setText((value == null) ? "" : value.toString()); 
        if (column == 1) { 
            setBackground(Color.MAGENTA);
        }
        if (column == 5) { 

            if (value.equals("Отправлено")) { setBackground(Color.yellow); } 

            if (value.equals("Доставлено")) { setBackground(Color.green); } 
            
            if (value.equals("Ожидает вручения")) { setBackground(Color.red); }
        } 
        if (column == 6) { 
            
            if (value.equals("Мужской")) { setBackground(Color.blue); }
            if (value.equals("Женский")) { setBackground(Color.pink); }
        }
        
        

        setEditable(false); 

        int rendererWidth = getPreferredSize().width; 

        TableColumn tableColumn = table.getColumnModel().getColumn(column); 

        tableColumn.setPreferredWidth(Math.max(rendererWidth + table.getIntercellSpacing().width, tableColumn.getPreferredWidth())); 

        setSize(table.getColumnModel().getColumn(column).getWidth(), getPreferredSize().height); 

        return this; } 
}

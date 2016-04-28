package com.kitri4.GGY.Member;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
  
/**
 * @version 1.0 11/09/98
 */
public class ButtonRenderer extends JButton implements TableCellRenderer {

	ImageIcon[] i;
  public ButtonRenderer(ImageIcon[] img) {
    setOpaque(true);
    this.i= img;
//    System.out.println("s");
    //this.setIcon(img[1]);
  }
   
  public Component getTableCellRendererComponent(JTable table, Object value,
                   boolean isSelected, boolean hasFocus, int row, int column) {
//	this.setText("ÇÑ½Å");
    if (isSelected) {
//      setForeground(table.getSelectionForeground());
//      setBackground(table.getSelectionBackground());
      setIcon(i[row]);
    } else{
//      setForeground(table.getForeground());
//      setBackground(UIManager.getColor("Button.background"));
      setIcon(i[row]);
    }
    setIcon(i[row]);
    return this;
  }
}
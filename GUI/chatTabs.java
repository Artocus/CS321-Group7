package GUI;

import javax.swing.*;
import java.awt.*;
import java.net.Socket;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class chatTabs{

  JTabbedPane tPane;
  
  public chatTabs()
  {
    //tabbed panes
    tPane = new JTabbedPane();
    JComponent panel1 = makeTextPanel("Panel #1");
    tPane.addTab("Tab 1", panel1);
    JComponent panel2 = makeTextPanel("Maybe chat rooms go here");
    tPane.addTab("Chat Rooms", panel2);
    JComponent panel3 = makeTextPanel("Lemme slide in them dm's");
    tPane.addTab("Direct Messages",panel3);
    
    
  }
  //helper function to make tabs easy might change/delete later
  static JComponent makeTextPanel(String text) {
    JPanel panel = new JPanel(false);
    JLabel filler = new JLabel(text);
    filler.setHorizontalAlignment(JLabel.CENTER);
    filler.setOpaque(true);
    
    panel.setLayout(new GridLayout(1, 1));
    panel.add(filler);
    return panel;
  }
  
  public static void main (String[] args){}
}
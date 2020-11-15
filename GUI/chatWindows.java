package GUI;

import javax.swing.*;
import java.awt.*;
import java.net.Socket;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class chatWindows{
  chatMenubar mb;
  chatTabs tab;
  
  chatWindows(){
    mb = new chatMenubar();
    tab = new chatTabs();
    
    JFrame frame = new JFrame("Chat Frame / CLUB HOUSE GAMES 2.INFINITY :D");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 600); 
    frame.setVisible(true);
    
    JPanel panel = new JPanel(); //panel insvisible until you add stuff
    
    //text area test
    JTextArea textArea = new JTextArea();
    
    //JComboBox
    String options[] = {"option 1", "option 2", "option 3"};
    JComboBox jbox = new JComboBox(options);
    //jbox.setBounds(40,40,90,20);
    
    //scrollbars?
    JScrollBar sBar = new JScrollBar();
    
    //legacy behavior
    //frame.getContentPane().add(BorderLayout.SOUTH, panel);
    //frame.getContentPane().add(BorderLayout.NORTH, mb.menuBar);
    //frame.getContentPane().add(BorderLayout.WEST, textArea);
    //test stuff
    //frame.getContentPane().add(BorderLayout.EAST, sBar);
    //frame.getContentPane().add(BorderLayout.CENTER, tab.tPane);
    
    frame.getContentPane().add(BorderLayout.NORTH, mb.menuBar);
    frame.getContentPane().add(BorderLayout.WEST, tab.tPane);
    
    
  }
  
  public static void lightMode()
  {
    //frame.getContentPane().setBackground(Color.WHITE);
    //tPane.setBackground(Color.WHITE);
    //label.setBackground(Color.WHITE);
  }
  
  //turn the colors of the windows grey
  public static void darkMode()
  {
     
    //frame.getContentPane().setBackground(Color.GRAY);
    //tPane.setBackground(Color.GRAY);
    //label.setBackground(Color.GRAY);
    //tPane.setBackgroundAt(0,Color.GRAY);
  }
}
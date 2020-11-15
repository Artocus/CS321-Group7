package GUI;

import javax.swing.*;
import java.awt.*;
import java.net.Socket;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

class chatLoginScreen{
  chatWindows cw;
  
  chatLoginScreen(){
    
    JFrame logframe = new JFrame("Welcome");
    logframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    logframe.setSize(800, 600); 
    logframe.setVisible(true);
    
    //buttons go here
    JButton enterButton = new JButton("Enter");
    logframe.add(enterButton);
    
    ActionListener a = new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        if(e.getSource() == enterButton)
          //chatGUI.testMessage();
          
        cw = new chatWindows();
        //logframe.dispatchEvent(new WindowEvent(logframe, WindowEvent.WINDOW_CLOSING));
      }
    };
    enterButton.addActionListener(a);
    
  }
}
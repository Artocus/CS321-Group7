package GUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.net.Socket;

public class ChatClient extends JFrame implements ActionListener {

    private String screenName;

    // GUI stuff
    private JTextArea  enteredText = new JTextArea(10, 32);
    private JTextField typedText   = new JTextField(32);

    // socket for connection to chat server
    private Socket socket;

    // for writing to and reading from the server


    public ChatClient(String screenName){ //String hostName) {

        // connect to server


        // create GUI stuff
        enteredText.setEditable(false);
        enteredText.setBackground(Color.LIGHT_GRAY);
        typedText.addActionListener(this);

        Container content = getContentPane();
        content.add(new JScrollPane(enteredText), BorderLayout.CENTER);
        content.add(typedText, BorderLayout.SOUTH);


        // display the window, with focus on typing box
        setTitle( screenName );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        typedText.requestFocusInWindow();
        setVisible(true);

    }

    // process TextField after user hits Enter
    public void actionPerformed(ActionEvent e) {

        typedText.setText("");
        typedText.requestFocusInWindow();
    }

    // listen to socket and print everything that server broadcasts

        
    
        
    public static void main(String[] args)  {
       String test = "test1";
        ChatClient client = new ChatClient(test);
        
    }
}





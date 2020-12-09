package GUI;
import static javax.swing.JOptionPane.showMessageDialog;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Acer Customer
 */
public class RoomPanel extends javax.swing.JPanel {
	
    /**
     * Creates new form GUItest
     */
    public RoomPanel() {
        initComponents();
    }
    
    public void UpdateUserList(String[] users) {
    	userList.setModel(new javax.swing.AbstractListModel<String>() {
            public int getSize() { return users.length; }
            public String getElementAt(int i) { return users[i]; }
        });
    }
    
    public void UpdateChatLog(String[] messages) {
    	for(; chatLogIndex < messages.length; chatLogIndex++) {
    		String[] messageBreakdown = messages[chatLogIndex].split(",");
    		if(messageBreakdown[1].equals("chat"))
    			chatBoxHistory.append("\n["+messageBreakdown[0]+"]: " + messageBreakdown[2]);
    		else if (messageBreakdown[1].equals("newUser"))
    			chatBoxHistory.append("\n"+messageBreakdown[0]+" joined");
    		else if (messageBreakdown[1].equals("leaveRoom"))
    			chatBoxHistory.append("\n"+messageBreakdown[0]+" left");
    	}
    	chatBoxHistory.setCaretPosition(chatBoxHistory.getDocument().getLength());
    }
    
    public String[] GetMessages() {
    	String[] messages = new String[currentMessages.size()];
    	messages = currentMessages.toArray(messages);
    	currentMessages.removeAll(currentMessages);
    	return messages;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sideTabs = new javax.swing.JTabbedPane();
        userTab = new javax.swing.JScrollPane();
        userList = new javax.swing.JList<>();
        chatPane = new javax.swing.JScrollPane();
        chatBoxHistory = new javax.swing.JTextArea();
        chatBoxSend = new javax.swing.JTextField();
        chatButtonSend = new javax.swing.JButton();
        gamePane = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        currentMessages = new ArrayList<String>();

        userTab.setViewportView(userList);

        sideTabs.addTab("Users", userTab);

        chatBoxHistory.setEditable(false);
        chatBoxHistory.setColumns(20);
        chatBoxHistory.setLineWrap(true);
        chatBoxHistory.setRows(5);
        chatBoxHistory.setText("");
        chatPane.setViewportView(chatBoxHistory);

        chatBoxSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chatBoxSendActionPerformed(evt);
            }
        });

        chatButtonSend.setText("-->");
        chatButtonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chatButtonSendActionPerformed(evt);
            }
        });

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.setText("aaaaand this is where I'd put a game.\n\n\n\n\n\n\t\t\tIF I HAD ONE");
        gamePane.setViewportView(jTextArea3);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sideTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chatPane, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chatBoxSend)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chatButtonSend))
                    .addComponent(gamePane))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sideTabs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gamePane, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(chatPane, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chatButtonSend)
                    .addComponent(chatBoxSend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void menuDropdownHelpMenuDragMouseEntered(javax.swing.event.MenuDragMouseEvent evt) {//GEN-FIRST:event_menuDropdownHelpMenuDragMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_menuDropdownHelpMenuDragMouseEntered

    private void helpOptionAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpOptionAboutActionPerformed
        // TODO add your handling code here:
        showMessageDialog(null, "This software was created by:\n\nRam Kammari\nArt Olsen\nNathaniel Potgiesser\nDiego Rivera\nFelix Tang");
    }//GEN-LAST:event_helpOptionAboutActionPerformed

    private void helpOptionNobodycameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpOptionNobodycameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_helpOptionNobodycameActionPerformed

    private void chatBoxSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chatBoxSendActionPerformed
        // TODO add your handling code here:
        if (!chatBoxSend.getText().equals("")){
            currentMessages.add(chatBoxSend.getText());
            chatBoxSend.setText("");
        }
        chatBoxSend.requestFocus();
    }//GEN-LAST:event_chatBoxSendActionPerformed

    private void chatButtonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chatButtonSendActionPerformed
        // TODO add your handling code here:
        chatBoxSendActionPerformed(evt);
    }//GEN-LAST:event_chatButtonSendActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea chatBoxHistory;
    private javax.swing.JTextField chatBoxSend;
    private javax.swing.JButton chatButtonSend;
    private javax.swing.JScrollPane chatPane;
    private javax.swing.JScrollPane gamePane;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTabbedPane sideTabs;
    private javax.swing.JList<String> userList;
    private javax.swing.JScrollPane userTab;
    private int chatLogIndex = 0;
    // End of variables declaration//GEN-END:variables
    private List<String> currentMessages;
}

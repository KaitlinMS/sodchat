package Messages;

import java.util.ArrayList;
import org.jdesktop.application.Action;
import sod.SODApp;
import java.net.*;
import java.io.*;
import dk.ange.octave.*;

//---------------Contructors--------------------
public class MessageController extends javax.swing.JFrame {

    private ArrayList<Socket> socketList;
    private Collaboration.Collaboration collab;
    private StringWriter octaveWriter;
    private boolean octaveEnabled;
    private OctaveEngine octave;

    public MessageController(ArrayList<Socket> sockets, Collaboration.Collaboration col) {
        initComponents();
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        octaveEnabled = false;
        socketList = sockets;
        collab = col;
        for (int i = 0; i < socketList.size(); i++) {
            (new MessageNetWrapper(socketList.get(i), this)).start();
        }
        this.setVisible(true);
    }

    //----------------I/O-------------------
    public void receiveMsg(String msg, Socket fromSocket) {
        Display(msg);
        MessageNetWrapper.sendMessage(socketList, fromSocket, msg);
        if (octaveEnabled == true) {
            evalOctave(msg);
        }
    }

    @Action
    public void Send() {
        SODApp sod = SODApp.getApplication();
        String msgSend = sod.setSet.getUserName() + ": " + messageField.getText();
        messageField.setText("");
        Display(msgSend);
        MessageNetWrapper.sendMessage(socketList, null, msgSend);
        if (octaveEnabled == true) {
            evalOctave(msgSend);
        }
    }

    public void Alert(String alert) {
        Display(alert);
        MessageNetWrapper.sendMessage(socketList, null, alert);
    }

    public void Display(String msg) {
        chatPane.setText(chatPane.getText().concat(msg + "\n"));
        chatPane.setCaretPosition(chatPane.getDocument().getLength());
    }

    //---------------Octave----------------------
    public void initOctave() {
        try{
            octaveEnabled = true;
            octave = new OctaveEngineFactory().getScriptEngine();
        }
        catch(Exception e){
            octaveEnabled = false;
            Display("Octave could not be initialized!");
        }
    }

    public void evalOctave(String msg) {
        try {
            int i = msg.indexOf(": !");
            if (i != -1) {
                msg = msg.substring(i + 2);
            }
            if (msg.startsWith("!")) {
                octaveWriter = new StringWriter();
                octave.setWriter(octaveWriter);
                octave.setErrorWriter(octaveWriter);
                octave.eval(msg.substring(1));
                Display(octaveWriter.toString());
                MessageNetWrapper.sendMessage(socketList, null, octaveWriter.toString());
            }
        } catch (Exception e) {
            Display("Octave failed to eval" + msg + "This octave session must now reset");
            MessageNetWrapper.sendMessage(socketList, null, ("Octave failed to eval" + msg + "This octave session must now reset"));
            octave = new OctaveEngineFactory().getScriptEngine();
        }
    }

    //------------------Housekeeping------------
    public void removeSocket(Socket s) {
        socketList.remove(s);
        Alert("User has left the collaboration");
    }

    public void addSocket(Socket s) {
        (new MessageNetWrapper(s, this)).start();
    }

    public void closeSockets() {
        try {
            for (int i = 0; i < socketList.size(); i++) {
                socketList.get(i).close();
            }
        } catch (Exception e) {
        }
    }

    public void dispose() {
        collab.close();
        closeSockets();
        super.dispose();
        if (octaveEnabled) {
            octave.destroy();
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sendButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatPane = new javax.swing.JTextPane();
        messageField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(sod.SODApp.class).getContext().getActionMap(MessageController.class, this);
        sendButton.setAction(actionMap.get("Send")); // NOI18N
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(sod.SODApp.class).getContext().getResourceMap(MessageController.class);
        sendButton.setText(resourceMap.getString("sendButton.text")); // NOI18N
        sendButton.setName("sendButton"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        chatPane.setEditable(false);
        chatPane.setName("chatPane"); // NOI18N
        jScrollPane1.setViewportView(chatPane);

        messageField.setText(resourceMap.getString("messageField.text")); // NOI18N
        messageField.setName("messageField"); // NOI18N
        messageField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                messageFieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(messageField, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sendButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(messageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void messageFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_messageFieldKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            if (messageField.getText().length() > 0) {
                Send();
            }
        }
    }//GEN-LAST:event_messageFieldKeyPressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane chatPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField messageField;
    private javax.swing.JButton sendButton;
    // End of variables declaration//GEN-END:variables
}

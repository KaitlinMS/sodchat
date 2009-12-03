/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FileTransfer.java
 *
 * Created on 28-Nov-2009, 4:41:46 PM
 */
package sod;

import FileTransfer.*;
import sod.*;
import org.jdesktop.application.Action;
import javax.swing.*;
import java.io.*;
import java.net.*;
import FileTransfer.FileTransferNetWrapper;

/**
 *
 * @author Adrian
 */
public class FileTransfer extends javax.swing.JFrame {

    private String filePath;
    private String fileName;
    private boolean incoming;
    private String contactName;
    private String contactIp;
    private Socket sock;

    //Receiving Tranfer Request
    public FileTransfer(Boolean inc, String conName, String fName, Socket s) {
        initComponents();
        this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);

        incoming = inc;
        fileName = fName;
        contactName = conName;
        contactIp = s.getInetAddress().getHostAddress();
        sock = s;
        setUp();
    }

    //Sending Transfer Request
    public FileTransfer(Boolean inc, String conName, String conIp) {
        initComponents();
        this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);

        incoming = inc;
        contactName = conName;
        contactIp = conIp;
        fileName = "";
        setUp();

    }

    private void setUp() {
        nameLabel.setText(contactName);
        ipLabel.setText(contactIp);
        pathLabel.setText("");
        if (incoming) {
            sendAcceptButton.setText("Accept");
            directionLabel.setText("Imcoming file: " + fileName);
        } else {
            sendAcceptButton.setText("Send");
            directionLabel.setText("Outgoing");
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

        jLabel1 = new javax.swing.JLabel();
        directionLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        setButton = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        sendAcceptButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        ipLabel = new javax.swing.JLabel();
        pathLabel = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();

        setName("Form"); // NOI18N
        setResizable(false);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(sod.SODApp.class).getContext().getResourceMap(FileTransfer.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        directionLabel.setText(resourceMap.getString("directionLabel.text")); // NOI18N
        directionLabel.setName("directionLabel"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(sod.SODApp.class).getContext().getActionMap(FileTransfer.class, this);
        setButton.setAction(actionMap.get("setPath")); // NOI18N
        setButton.setText(resourceMap.getString("setButton.text")); // NOI18N
        setButton.setName("setButton"); // NOI18N

        jProgressBar1.setName("jProgressBar1"); // NOI18N

        sendAcceptButton.setAction(actionMap.get("sendAccept")); // NOI18N
        sendAcceptButton.setText(resourceMap.getString("sendAcceptButton.text")); // NOI18N
        sendAcceptButton.setName("sendAcceptButton"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        nameLabel.setText(resourceMap.getString("nameLabel.text")); // NOI18N
        nameLabel.setName("nameLabel"); // NOI18N

        ipLabel.setText(resourceMap.getString("ipLabel.text")); // NOI18N
        ipLabel.setName("ipLabel"); // NOI18N

        pathLabel.setText(resourceMap.getString("pathLabel.text")); // NOI18N
        pathLabel.setEnabled(false);
        pathLabel.setName("pathLabel"); // NOI18N

        cancelButton.setAction(actionMap.get("Cancel")); // NOI18N
        cancelButton.setText(resourceMap.getString("cancelButton.text")); // NOI18N
        cancelButton.setName("cancelButton"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(ipLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(directionLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pathLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sendAcceptButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(setButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nameLabel)
                    .addComponent(ipLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(directionLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(setButton)
                    .addComponent(pathLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendAcceptButton)
                    .addComponent(cancelButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Action
    public void setPath() {
        ///EXAMPLE ONLY -- CODE TO HANDLE PATH IN FOR LOADING FILE
        if (incoming == false) {
            final JFileChooser fc = new JFileChooser();
            int returnVal = fc.showOpenDialog(fc);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                filePath = file.getPath();
                fileName = file.getName();
                pathLabel.setText(filePath);
                sendAcceptButton.setEnabled(true);
            }
        } else {
            ///OR DIRECTORY PATH OUT FOR SAVING A FILE
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int returnVal = fc.showSaveDialog(fc);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                filePath = file.getPath();
                pathLabel.setText(filePath);
                sendAcceptButton.setEnabled(true);
            }
        }
    }

    @Action
    public void sendAccept() {
        if (incoming) {
            FileTransferNetWrapper ftnw = new FileTransferNetWrapper(incoming, filePath, fileName, sock);
            ftnw.start();
            sendAcceptButton.setEnabled(false);

        } else {
            try {
                SODApp sod = SODApp.getApplication();
                String uname = sod.setSet.getUserName();
                sock = sod.netcontroller.Send("ftr,xfr," + uname + "," + fileName + ",2", contactIp);
                FileTransferNetWrapper ftnw = new FileTransferNetWrapper(incoming, filePath, fileName, sock);
                ftnw.start();
                sendAcceptButton.setEnabled(false);
            } catch (Exception e) {
                new ErrorPrompt("Could not initialize file transfer");
                this.dispose();
            }
        }
    }

    @Action
    public void Cancell() {

        this.dispose();
    }

    @Action
    public void Cancel() {
        try {
            if (incoming) {
                FileTransferNetWrapper.Decline(sock);
                sock.close();
                this.dispose();
            } else {
                //sock.close();
                this.dispose();
            }
        } catch (Exception e) {
            //this.dispose();
        }
        ;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel directionLabel;
    private javax.swing.JLabel ipLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField pathLabel;
    private javax.swing.JButton sendAcceptButton;
    private javax.swing.JButton setButton;
    // End of variables declaration//GEN-END:variables
}

/*
 * DiscussionView.java
 * Displays several options for creating a new collaboration or joining an
 * existing collaboration.
 */
package sod;

import org.jdesktop.application.Action;

/**
 *
 * @author Adrian
 */
public class DiscussionView extends javax.swing.JFrame {

    // Methods
    // Creates new form DiscussionView.
    public DiscussionView(String[] Names) {
        initComponents();
        contactList.setListData(Names);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ipLabel = new javax.swing.JLabel();
        joinIPField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        joinButton = new javax.swing.JButton();
        hostOptionsLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        contactList = new javax.swing.JList();
        inviteLabel = new javax.swing.JLabel();
        privateCheck = new javax.swing.JCheckBox();
        octaveCheck = new javax.swing.JCheckBox();
        hostButton = new javax.swing.JButton();
        joinNameField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        nameLabel2 = new javax.swing.JLabel();
        hostNameField = new javax.swing.JTextField();

        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(sod.SODApp.class).getContext().getResourceMap(DiscussionView.class);
        ipLabel.setText(resourceMap.getString("ipLabel.text")); // NOI18N
        ipLabel.setName("ipLabel"); // NOI18N

        joinIPField.setText(resourceMap.getString("joinIPField.text")); // NOI18N
        joinIPField.setName("joinIPField"); // NOI18N

        jSeparator1.setName("jSeparator1"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(sod.SODApp.class).getContext().getActionMap(DiscussionView.class, this);
        joinButton.setAction(actionMap.get("Join")); // NOI18N
        joinButton.setText(resourceMap.getString("joinButton.text")); // NOI18N
        joinButton.setName("joinButton"); // NOI18N

        hostOptionsLabel.setText(resourceMap.getString("hostOptionsLabel.text")); // NOI18N
        hostOptionsLabel.setName("hostOptionsLabel"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        contactList.setName("contactList"); // NOI18N
        jScrollPane1.setViewportView(contactList);

        inviteLabel.setText(resourceMap.getString("inviteLabel.text")); // NOI18N
        inviteLabel.setName("inviteLabel"); // NOI18N

        privateCheck.setText(resourceMap.getString("privateCheck.text")); // NOI18N
        privateCheck.setName("privateCheck"); // NOI18N

        octaveCheck.setText(resourceMap.getString("octaveCheck.text")); // NOI18N
        octaveCheck.setName("octaveCheck"); // NOI18N

        hostButton.setAction(actionMap.get("Host")); // NOI18N
        hostButton.setText(resourceMap.getString("hostButton.text")); // NOI18N
        hostButton.setName("hostButton"); // NOI18N

        joinNameField.setName("joinNameField"); // NOI18N

        nameLabel.setText(resourceMap.getString("nameLabel.text")); // NOI18N
        nameLabel.setName("nameLabel"); // NOI18N

        nameLabel2.setText(resourceMap.getString("nameLabel2.text")); // NOI18N
        nameLabel2.setName("nameLabel2"); // NOI18N

        hostNameField.setText(resourceMap.getString("hostNameField.text")); // NOI18N
        hostNameField.setName("hostNameField"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ipLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(joinIPField, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(joinNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(joinButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(hostOptionsLabel)
                        .addGap(339, 339, 339)))
                .addContainerGap())
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(privateCheck)
                        .addGap(91, 91, 91)
                        .addComponent(nameLabel2)
                        .addGap(12, 12, 12)
                        .addComponent(hostNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(octaveCheck)
                    .addComponent(inviteLabel))
                .addGap(81, 81, 81))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                .addComponent(hostButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ipLabel)
                    .addComponent(joinIPField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joinButton)
                    .addComponent(nameLabel)
                    .addComponent(joinNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(hostOptionsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(privateCheck)
                            .addComponent(nameLabel2)
                            .addComponent(hostNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(octaveCheck)
                        .addGap(18, 18, 18)
                        .addComponent(inviteLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(hostButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Action
    public void Host() {
        int[] i;
        if (contactList.isSelectionEmpty() == false) {
            i = contactList.getSelectedIndices();
        } else {
            int[] j = {-1};
            i = j;
        }
        SODApp sod = SODApp.getApplication();
        sod.hostChat(privateCheck.isSelected(), octaveCheck.isSelected(), hostNameField.getText(), i);
        this.dispose();
    }

    @Action
    public void Join() {
        String jip = joinIPField.getText();
        String jnm = joinNameField.getText();
        SODApp sod = SODApp.getApplication();

        sod.joinChat(jip, jnm, false);
        this.dispose();

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList contactList;
    private javax.swing.JButton hostButton;
    private javax.swing.JTextField hostNameField;
    private javax.swing.JLabel hostOptionsLabel;
    private javax.swing.JLabel inviteLabel;
    private javax.swing.JLabel ipLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton joinButton;
    private javax.swing.JTextField joinIPField;
    private javax.swing.JTextField joinNameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nameLabel2;
    private javax.swing.JCheckBox octaveCheck;
    private javax.swing.JCheckBox privateCheck;
    // End of variables declaration//GEN-END:variables
}

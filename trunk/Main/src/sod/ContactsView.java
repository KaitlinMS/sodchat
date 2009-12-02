/*
 * ContactsView.java
 */

package sod;

import org.jdesktop.application.Action;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;

/**
 * The application's main frame.
 */
public class ContactsView extends FrameView {

    public ContactsView(SingleFrameApplication app) {
        super(app);
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuItem3 = new javax.swing.JMenuItem();

        mainPanel.setName("mainPanel"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setName("jList1"); // NOI18N
        jScrollPane1.setViewportView(jList1);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(sod.SODApp.class).getContext().getResourceMap(ContactsView.class);
        jList1.getAccessibleContext().setAccessibleName(resourceMap.getString("jList1.AccessibleContext.accessibleName")); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenuBar1.setName("jMenuBar1"); // NOI18N

        jMenu2.setText(resourceMap.getString("jMenu2.text")); // NOI18N
        jMenu2.setIconTextGap(0);
        jMenu2.setName("jMenu2"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(sod.SODApp.class).getContext().getActionMap(ContactsView.class, this);
        jMenuItem6.setAction(actionMap.get("Transfer")); // NOI18N
        jMenuItem6.setText(resourceMap.getString("jMenuItem6.text")); // NOI18N
        jMenuItem6.setName("jMenuItem6"); // NOI18N
        jMenu2.add(jMenuItem6);

        jMenuItem5.setAction(actionMap.get("newMessage")); // NOI18N
        jMenuItem5.setText(resourceMap.getString("jMenuItem5.text")); // NOI18N
        jMenuItem5.setName("jMenuItem5"); // NOI18N
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu1.setText(resourceMap.getString("jMenu1.text")); // NOI18N
        jMenu1.setName("jMenu1"); // NOI18N

        jMenuItem2.setAction(actionMap.get("RemoveContact")); // NOI18N
        jMenuItem2.setIcon(resourceMap.getIcon("jMenuItem2.icon")); // NOI18N
        jMenuItem2.setText(resourceMap.getString("jMenuItem2.text")); // NOI18N
        jMenuItem2.setName("jMenuItem2"); // NOI18N
        jMenu1.add(jMenuItem2);

        jMenuItem7.setAction(actionMap.get("ChangeName")); // NOI18N
        jMenuItem7.setText(resourceMap.getString("jMenuItem7.text")); // NOI18N
        jMenuItem7.setName("jMenuItem7"); // NOI18N
        jMenu1.add(jMenuItem7);

        jMenuItem1.setAction(actionMap.get("AddContact")); // NOI18N
        jMenuItem1.setIcon(resourceMap.getIcon("jMenuItem1.icon")); // NOI18N
        jMenuItem1.setText(resourceMap.getString("jMenuItem1.text")); // NOI18N
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        jMenu1.add(jMenuItem1);

        jMenuItem4.setAction(actionMap.get("showDiscussionSettings")); // NOI18N
        jMenuItem4.setIcon(resourceMap.getIcon("jMenuItem4.icon")); // NOI18N
        jMenuItem4.setText(resourceMap.getString("jMenuItem4.text")); // NOI18N
        jMenuItem4.setName("jMenuItem4"); // NOI18N
        jMenu1.add(jMenuItem4);

        jSeparator1.setName("jSeparator1"); // NOI18N
        jMenu1.add(jSeparator1);

        jMenuItem3.setAction(actionMap.get("showSettings")); // NOI18N
        jMenuItem3.setIcon(resourceMap.getIcon("jMenuItem3.icon")); // NOI18N
        jMenuItem3.setText(resourceMap.getString("jMenuItem3.text")); // NOI18N
        jMenuItem3.setName("jMenuItem3"); // NOI18N
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setComponent(mainPanel);
        setMenuBar(jMenuBar1);
    }// </editor-fold>//GEN-END:initComponents

    @Action
    public void newMessage() {
        //SODApp.getApplication().newMessage();
    }

    @Action
    public void Transfer() {
        SODApp.getApplication().showTransfer();
    }

    @Action
    public void showDiscussionSettings() {
        SODApp.getApplication().showDiscuss();
    }

    @Action
    public void AddContact() {
        SODApp.getApplication().showAdd();
    }

    @Action
    public void showSettings() {
        SODApp.getApplication().showSettings();
    }

    @Action
    public void RemoveContact() {
        SODApp.getApplication().removeContact(jList1.getSelectedIndex());
    }
    
    @Action
    public void ChangeName() {
        SODApp.getApplication().showChange(jList1.getSelectedIndex());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JList jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
    

    public void updateList(){
        //String[] n = SODApp.getApplication().concontroller.getAllNames();
        //To display just names use n instead
        Contacts.Contact[] a = SODApp.getApplication().concontroller.getAllContacts();
        jList1.setListData(a);
    }

}

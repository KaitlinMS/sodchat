/*
 * SODApp.java
 */

package sod;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class SODApp extends SingleFrameApplication {
    public FileTransfer transWindow;
    public DiscussionView setDiscuss;
    public NewContact setAdd;
    public Settings setSet;
    public ContactsView contacts;
    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        contacts = new ContactsView(this);
        show(contacts);
        transWindow = new FileTransfer();
        setDiscuss = new DiscussionView();
        setAdd = new NewContact();
        setSet = new Settings();
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of SODApp
     */
    public static SODApp getApplication() {
        return Application.getInstance(SODApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(SODApp.class, args);
    }

    public void newMessage(){
        show(new MessageView());
    }

     public void showTransfer(){
        transWindow.setVisible(true);
    }

     public void showDiscuss(){
        setDiscuss.setVisible(true);
    }

     public void showAdd(){
        setAdd.setVisible(true);
    }

     public void showSettings(){
        setSet.setVisible(true);
    }

     public void addContact(String IP, String Name){
         contacts.addToList(Name);
     }
}

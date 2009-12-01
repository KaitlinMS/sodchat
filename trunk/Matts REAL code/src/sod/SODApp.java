/*
 * SODApp.java
 */

package sod;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;
import java.net.*;

import Contacts.ContactController;

/**
 * The main class of the application.
 */
public class SODApp extends SingleFrameApplication {
    public FileTransfer transWindow;
    public DiscussionView setDiscuss;
    public NewContact setAdd;
    public Settings setSet;
    public ContactsView contacts;

    public ContactController concontroller;
    public NetworkController netcontroller;

    //Controllers
    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        concontroller = new ContactController();
        netcontroller = new NetworkController();

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

     public void showChange(int i){
        if (i != -1)new ChangeName(concontroller.getAllIps()[i]);
    }

     public void showSettings(){
        setSet.setVisible(true);
    }

     public void addContact(String IP, String Name){
        concontroller.addContact(IP, Name, setSet.getUserName());
        contacts.updateList();
     }

     public void removeContact(int i){
        if (i != -1) concontroller.removeContact(i);
        contacts.updateList();
     }

     public void changeName(String IP, String Name){
        concontroller.changeName(IP, Name);
        contacts.updateList();
     }

     public void conNetEvent(Socket s, String command){
        System.out.println("CONTACT EVENT!");
     }

     public void msgNetEvent(Socket s, String command){

     }

     public void colNetEvent(Socket s, String command){

     }

     public void ftrNetEvent(Socket s, String command){
         
     }
}

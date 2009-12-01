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
    //public DiscussionView setDiscuss;
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

    public void hostChat(Boolean p, Boolean o, int[] contacts){
            try {
                for (int i = 0; i < contacts.length; i++) {
                    netcontroller.Send("col,inv,"+setSet.getUserName()+",1", concontroller.getAllIps()[i]);
            }
        } catch (Exception e) {}
        show(new MessageView());
    }

    public void joinChat(){
        
    }

     public void showTransfer(){
        transWindow.setVisible(true);
    }

     public void showDiscuss(){
       show(new DiscussionView(concontroller.getAllNames()));
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
        try{
            netcontroller.Send("con,req,"+setSet.getUserName()+",1", IP);
        }
        catch(Exception e){}
     }

     public void removeContact(int i){
        if (i != -1) concontroller.removeContact(i);
        contacts.updateList();
     }

     public void changeName(String IP, String Name){
        concontroller.changeName(IP, Name);
        contacts.updateList();
     }

     public void conNetEvent(Socket s, String[] event){
         if(event[0].equals("req")){
             concontroller.contactRequest(s.getInetAddress().getHostAddress(), event[1]);
             contacts.updateList();
         }
     }

     public void msgNetEvent(Socket s, String[] event){
        System.out.println("Message Event");
     }

     public void colNetEvent(Socket s, String[] event){
        System.out.println("Colab Event");
     }

     public void ftrNetEvent(Socket s, String[] event){
         System.out.println("File transfer Event");
     }

     
}

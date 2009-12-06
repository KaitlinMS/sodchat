/*
 * SODApp.java
 */
package sod;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;
import java.net.*;
import java.io.*;

import Contacts.ContactController;
import Collaboration.CollaborationController;
import FileTransfer.FileTransferController;
import Network.NetworkController;

/**
 * The main class of the application.
 */
public class SODApp extends SingleFrameApplication {

    public NewContact setAdd;
    public Settings setSet;
    public ContactsView contacts;
    public ContactController concontroller;
    public NetworkController netcontroller;
    public CollaborationController colcontroller;
    public currentIP cIP;

    //Controllers
    /**
     * At startup create and show the main frame of the application.
     */
    @Override
    protected void startup() {

        concontroller = new ContactController();
        netcontroller = new NetworkController();
        colcontroller = new CollaborationController();
        cIP = new currentIP();
        contacts = new ContactsView(this);
        show(contacts);
        setSet = new Settings();
        setSet.setVisible(false);
        //showSettings();
        setAdd = new NewContact();
        try {
            BufferedReader dataFileIn = new BufferedReader(new FileReader("username.dat"));
            String name = dataFileIn.readLine();
            if (name != null) {
                setSet.changeUserName(name);
            }
            dataFileIn.close();
        } catch (IOException e) {
            setSet.setVisible(true);
        }
        try {
            BufferedReader dataFileIn = new BufferedReader(new FileReader("contactlist.dat"));
            String savedContact;
            while ((savedContact = dataFileIn.readLine()) != null) {
                addContact(savedContact);
            }
            dataFileIn.close();
        } catch (IOException e) {
        }
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override
    protected void configureWindow(java.awt.Window root) {
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

    //-------------Contact Methods-----------------

    public void showAdd() {
        setAdd.setVisible(true);
    }
    
    public void addContact(String IP) {
        concontroller.addContact(IP);
        contacts.updateList();
        try {
            netcontroller.Send("con,req," + getUserName(), IP);
        } catch (Exception e) {
        }
    }

    public void removeContact(int i) {
        if (i != -1) {
            concontroller.removeContact(i);
        }
        contacts.updateList();
    }

    public void conNetEvent(Socket s, String[] event) {

        //Incoming contact request event
        if (event[0].equals("req")) {
            concontroller.contactRequest(s.getInetAddress().getHostAddress(), event[1]);
            contacts.updateList();
            try {
                netcontroller.Send("con,rep," + getUserName(), s.getInetAddress().getHostAddress());
                s.close();
            } catch (Exception e) {
            }
        }
        else if (event[0].equals("rep")) {
            concontroller.contactRequest(s.getInetAddress().getHostAddress(), event[1]);
            contacts.updateList();
        }
    }

    //--------------Collaboration Methods---------------------

    public void showDiscuss() {
        (new DiscussionView(concontroller.getAllNames())).setVisible(true);
    }

    public void hostChat(Boolean p, Boolean o, String hostingName, int[] contacts) {
        String[] invitedIps = new String[contacts.length];
        String[] ips = concontroller.getAllIps();
        if(hostingName.equals("Default"))
            hostingName = ips[contacts[0]];
        if (contacts[0] == -1) {
            invitedIps = new String[0];
        }
        try {
            for (int i = 0; i < contacts.length; i++) {
                int j = contacts[i];
                invitedIps[i] = ips[j];
                if (j != -1) {
                    netcontroller.Send("col,inv,"+getUserName()+","+hostingName+"," +p.toString(), concontroller.getAllIps()[j]);
                }
            }
            colcontroller.hostNew(p, o, hostingName, invitedIps);
        } catch (Exception e) {
            colcontroller.hostNew(p, o, hostingName, invitedIps);
        }
    }

    public void joinChat(String ip, String name, Boolean priv) {
        try {
            ip = InetAddress.getByName(ip).getHostAddress();
            Socket j = netcontroller.Establish("col,jon," + name, ip);
            colcontroller.joinNew(j, name, priv);
        } catch (Exception e) {
            new ErrorPrompt("Could not join collaboration");
        }
    }

    public void colNetEvent(Socket s, String[] event) {
        //Invitation to a chat event
        //Arguments: 1 - Other users name, 2 - Chat Name, 3 - privacy
        if (event[0].equals("inv")) {
            (new InvitationRequest(event[1], s.getInetAddress().getHostAddress(), event[2], event[3].equals("true"))).setVisible(true);
            try {
                s.close();
            } catch (Exception e) {
            }
        } //Parse a join request
        else if (event[0].equals("jon")) {
            colcontroller.joinRequest(s, event[1], s.getInetAddress().getHostAddress());
        }
    }

    //-------------File Transfer Methods--------------

    public void showTransfer() {
        if (contacts.contactsList.isSelectionEmpty() != true) {
            String contactIp = concontroller.getAllIps()[contacts.contactsList.getSelectedIndex()];
            String contactName = concontroller.getName(contactIp);
            (new FileTransferController(false, contactName, contactIp)).setVisible(true);
        }
    }

    public void ftrNetEvent(Socket s, String[] event) {
        if (event[0].equals("xfr")) {
            String contactName = event[1];
            String fileName = event[2];
            (new FileTransferController(true, contactName, fileName, s)).setVisible(true);
        }
    }

    //--------------Settings Methods--------------------

    public void showSettings() {
        setSet.setVisible(true);
    }

    public void showIP() {
        cIP.setVisible(true);
    }

    public String getUserName(){
        return setSet.getUserName();
    }
}

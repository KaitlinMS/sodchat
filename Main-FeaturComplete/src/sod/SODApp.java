/*
 * SODApp.java
 */
package sod;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;
import java.net.*;

import Contacts.ContactController;
import Collaboration.CollaborationController;

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

    //Controllers
    /**
     * At startup create and show the main frame of the application.
     */
    @Override
    protected void startup() {
        concontroller = new ContactController();
        netcontroller = new NetworkController();
        colcontroller = new CollaborationController();

        contacts = new ContactsView(this);
        show(contacts);
        setAdd = new NewContact();
        setSet = new Settings();

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

    public void showDiscuss() {
        (new DiscussionView(concontroller.getAllNames())).setVisible(true);
    }

    public void hostChat(Boolean p, Boolean o, String hostingName, int[] contacts) {
        String[] invitedIps = new String[contacts.length];
        if (contacts[0] == -1) {
            invitedIps = new String[0];
        }
        String[] ips = concontroller.getAllIps();
        try {
            for (int i = 0; i < contacts.length; i++) {
                int j = contacts[i];
                invitedIps[i] = ips[i];
                if (j != -1) {
                    netcontroller.Send("col,inv," + setSet.getUserName() + "," + hostingName + ",2", concontroller.getAllIps()[j]);
                }
            }
            colcontroller.hostNew(p, o, hostingName, invitedIps);
        } catch (Exception e) {
            colcontroller.hostNew(p, o, hostingName, invitedIps);
        }
    }

    public void joinChat(String ip, String name) {
        try {
            ip = InetAddress.getByName(ip).getHostAddress();
            Socket j = netcontroller.Send("col,jon," + name + ",1", ip);
            colcontroller.joinNew(j, name);
        } catch (Exception e) {
            new ErrorPrompt("Could not join collaboration");
        }
    }

    public void showTransfer() {
        if(contacts.jList1.isSelectionEmpty() != true){
            String contactIp = concontroller.getAllIps()[contacts.jList1.getSelectedIndex()];
            String contactName = concontroller.getName(contactIp);
            (new FileTransfer(false, contactName, contactIp)).setVisible(true);
        }
    }

    public void showAdd() {
        setAdd.setVisible(true);
    }

    public void showChange(int i) {
        if (i != -1) {
            new ChangeName(concontroller.getAllIps()[i]);
        }
    }

    public void showSettings() {
        setSet.setVisible(true);
    }

    public void addContact(String IP, String Name) {
        concontroller.addContact(IP, Name, setSet.getUserName());
        contacts.updateList();
        try {
            netcontroller.Send("con,req," + setSet.getUserName() + ",1", IP);
        } catch (Exception e) {
        }
    }

    public void removeContact(int i) {
        if (i != -1) {
            concontroller.removeContact(i);
        }
        contacts.updateList();
    }

    public void changeName(String IP, String Name) {
        concontroller.changeName(IP, Name);
        contacts.updateList();
    }

    public void conNetEvent(Socket s, String[] event) {

        //Incoming contact request event
        if (event[0].equals("req")) {
            concontroller.contactRequest(s.getInetAddress().getHostAddress(), event[1]);
            contacts.updateList();
            try {
                s.close();
            } catch (Exception e) {
            }
        }
    }

    public void msgNetEvent(Socket s, String[] event) {
        System.out.println("Message Event");
    }

    public void colNetEvent(Socket s, String[] event) {
        //Invitation to a chat event
        //Arguments: 1 - Other users name, 2 - Chat Name
        if (event[0].equals("inv")) {
            (new InvitationRequest(event[1], s.getInetAddress().getHostAddress(), event[2])).setVisible(true);
            try {
                s.close();
            } catch (Exception e) {
            }
        } //Parse a join request
        else if (event[0].equals("jon")) {
            colcontroller.joinRequest(s, event[1], s.getInetAddress().getHostAddress());
        }
    }

    public void ftrNetEvent(Socket s, String[] event) {
        if (event[0].equals("xfr")) {
            String contactName = event[1];
            String fileName = event[2];
            (new FileTransfer(true, contactName, fileName, s)).setVisible(true);
        }
    }
}

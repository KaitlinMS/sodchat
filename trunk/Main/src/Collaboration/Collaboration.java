/*
 * Collaboration.java
 * Handles the creation of collaborations and their options.
 */

package Collaboration;

import java.net.*;
import sod.MessageView;
import java.util.ArrayList;
import sodmessaging.*;

public class Collaboration extends Thread {

    //Variables
    private MessageView mview;
    private MessageController mc;
    private ArrayList<Socket> socketList;
    private String Name;
    private Boolean priv = false;
    private Boolean oct = false;
    private String[] invited;

    public Collaboration(Socket s, String name) {
        socketList = new ArrayList();
        mc = new MessageController(socketList);
        socketList.add(s);
        Name = name;

    }

    public Collaboration(Boolean p, Boolean o, String name, String[] inv) {
        socketList = new ArrayList();
        mc = new MessageController(socketList);
        Name = name;
        priv = p;
        oct = o;
        invited = inv;

    }

    public void addMember(Socket s) {
        socketList.add(s);
        mc.addContact(s);
    }

    public String toString() {
        return Name;
    }

    public void close() {
    }

    public Boolean getPrivate() {
        return priv;
    }

    public Boolean getOct() {
        return oct;
    }

    public Boolean isInvited(String ip) {
        System.out.println("Handling join request ");
        for (int i = 0; i < invited.length; i++) {
            if (ip.equals(invited[i])) {
                return true;
            }
        }
        return false;
    }

    public void run() {
    }
}
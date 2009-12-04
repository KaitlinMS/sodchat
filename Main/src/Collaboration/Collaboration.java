/*
 * Collaboration.java
 * Handles the creation of collaborations and their options.
 */

package Collaboration;

import java.net.*;
import Messages.MessageController;
import java.util.ArrayList;

//import sodmessaging.*;

public class Collaboration {

    //Variables
    private MessageController msgcontroller;
    private CollaborationController colcontroller;
    private ArrayList<Socket> socketList;
    private String Name;
    private Boolean priv = false;
    private Boolean oct = false;
    private String[] invited;

    public Collaboration(Socket s, String name, CollaborationController ccont) {
        colcontroller = ccont;
        socketList = new ArrayList();
        socketList.add(s);
        Name = name;
        msgcontroller = new MessageController(socketList, this);
    }

    public Collaboration(Boolean p, Boolean o, String name, String[] inv, CollaborationController ccont) {
        colcontroller = ccont;
        socketList = new ArrayList();
        Name = name;
        priv = p;
        oct = o;
        invited = inv;
        msgcontroller = new MessageController(socketList, this);

        if(o==true){
            msgcontroller.initOctave();
        }
    }

    public void addMember(Socket s) {
        socketList.add(s);
        msgcontroller.addSocket(s);
    }

    public String toString() {
        return Name;
    }

    public void close() {
        colcontroller.End(this);
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

}

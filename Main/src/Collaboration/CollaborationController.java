/*
 * CollaborationController.java
 * Handles acquisition and application of collaboration settings, as well as
 * messaging in a collaboration.
 */

package Collaboration;

import java.net.*;
// Unused package:
//import java.io.*;
import java.util.ArrayList;

public class CollaborationController {

    // Variable declarations
    public CollaborationNetWrapper cnw;
    private ArrayList<Collaboration> collaborations;

    // Methods
    public CollaborationController() {
        collaborations = new ArrayList();
        cnw = new CollaborationNetWrapper();

    }

    public void hostNew(Boolean priv, Boolean oct, String chatName, String[] ips) {
        newCollab(priv, oct, chatName, ips);
    }

    public void joinNew(Socket js, String chatName) {
        try {
            Boolean b = cnw.canJoin(js);
            if (b) {
                newCollab(js, chatName);
            } else {
                js.close();
            }

        } catch (Exception e) {
        }
    }

    public void End(String name) {
    }

    public void newCollab(Socket s, String name) {
        collaborations.add(new Collaboration(s, name));
    }

    public void newCollab(Boolean p, Boolean o, String chatName, String[] ips) {
        collaborations.add(new Collaboration(p, o, chatName, ips));
    }

    public void joinRequest(Socket s, String chatName, String ip) {
        Boolean exists = false;
        int i;
        Collaboration collab;
        for (i = 0, collab = collaborations.get(i); i < collaborations.size(); i++, collab = collaborations.get(i)) {
            if (collab.toString().equals(chatName)) {
                exists = true;
                break;
            }
        }
        if (exists == false) {
            cnw.respond(s, "DNE");
        } else if (collab.getPrivate() && collab.isInvited(ip) != true) {
            cnw.respond(s, "PRIVATE");
        } else {
            cnw.respond(s, "ACCEPT");
            collab.addMember(s);
        }
    }
}

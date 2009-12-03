/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sodmessaging;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Morgan
 */
public class MessageController {
private ArrayList<Socket> contacts;
private MessageView view;

public MessageController (ArrayList<Socket> sockets)
{
 contacts = sockets;
 view = new MessageView(contacts);
 view.setVisible(true);
 for (int i=0; i < contacts.size(); i++ )
     new IncomingMessageWrapper (view, contacts.get(i));
}

public void addContact (Socket s)
{
    try{
    DataOutputStream out = new DataOutputStream( s.getOutputStream() );
                out.writeUTF("Connected.");
    new IncomingMessageWrapper (view, s);
    }
    catch (UnknownHostException e) {
        System.err.println("Don't know about host:");
        System.exit(1);
        }
    catch (IOException e) {
        System.err.println("Couldn't get I/O for the connection");
        System.exit(1);
        }
}

public void updateContacts (Socket s) {
    
}

}





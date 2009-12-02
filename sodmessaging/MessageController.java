/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sodmessaging;

import java.net.*;
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
 System.out.println(contacts.size());
 view = new MessageView(contacts);
 view.setVisible(true);
 for (int i=0; i < contacts.size(); i++ )
     new IncomingMessageWrapper (view, contacts.get(i));
}

public void addContact (Socket s)
{
    new IncomingMessageWrapper (view, s);
}

public void updateContacts (Socket s) {
    
}

}





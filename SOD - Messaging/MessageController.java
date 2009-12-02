/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sodmessaging;

import java.net.*;

/**
 *
 * @author Morgan
 */
public class MessageController {
private Socket [] contacts;
private MessageView view;

public MessageController (Socket [] sockets)
{
 contacts = sockets;
 view = new MessageView(contacts);
 view.setVisible(true);
 for (int i=0; i < contacts.length; i++ ) 
     new IncomingMessageWrapper (view, contacts[i]);
}

public void updateContacts (Socket s) {
    
}

}





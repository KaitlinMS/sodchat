/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sodmessaging;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
/**
 *
 * @author Morgan
 */
public class OutgoingMessageWrapper {

public OutgoingMessageWrapper (String message, ArrayList<Socket> s){
    if (s.size() != 0){PrintWriter out = null;
    try{        
            for (int i=0; i < s.size(); i++ ){
                out = new PrintWriter(s.get(i).getOutputStream(), true);
                out.println(message);
            }
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
}
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sodmessaging;
import java.io.*;
import java.net.*;
/**
 *
 * @author Morgan
 */
public class OutgoingMessageWrapper {

public OutgoingMessageWrapper (String message, Socket [] s){
    PrintWriter out = null;
    try{        
            for (int i=0; i < s.length; i++ ){
                out = new PrintWriter(s[i].getOutputStream(), true);
                out.println(message);
            }
             out.close();
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

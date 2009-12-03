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
    if (s.size() != 0){
    try{        
            for (int i=0; i < s.size(); i++ ){
                DataOutputStream outd = new DataOutputStream( s.get(i).getOutputStream() );
                outd.writeUTF(message);
            }
        }
    catch (UnknownHostException e) {
        System.err.println("Don't know about host:");
        System.exit(1);
        }
    catch (IOException e) {
        System.err.println(e);
        System.exit(1);
        }
}
}
}

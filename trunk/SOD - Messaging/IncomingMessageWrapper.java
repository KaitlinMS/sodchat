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
public class IncomingMessageWrapper extends Thread{

private MessageView view;
private Socket s;
public IncomingMessageWrapper (MessageView view, Socket s)
{
    this.view = view;
    this.s = s;

    start();
}
    public void run(){
        try{
            DataInputStream in = new DataInputStream( s.getInputStream() );
            while (true) {
                String message = in.readUTF();
                view.write(message);
            }
        }
        catch( EOFException ie ) {}
        catch( IOException ie ) {
            ie.printStackTrace();
        }
        finally{
            //removeConnection( s ); //This socket should be closed when we reach here as it is no longer active
    }
}
}

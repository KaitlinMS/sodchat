/*
 * NetworkSender.java
 * Handles network events for offline users.  These methods use their own
 * thread, allowing offline users to recieve messages once they are online.
 */

package Network;

import java.io.*;
import java.net.*;

public class NetworkSender extends Thread {

    private int port;
    private String msg;
    private String ip;
    private Socket sendSocket;

    public NetworkSender(String message, String sip, int PORT) {
        msg = message;
        ip = sip;
        port = PORT;
    }

    public Socket Send(String message, String sip) throws Exception {
        try {
            sendSocket = new Socket(InetAddress.getByName(ip), port);
            PrintWriter sout = new PrintWriter(sendSocket.getOutputStream(), true);
            sout.println(message);
            return sendSocket;
        } catch (Exception e) {
            throw e;
        }
    }

    public Socket returnSocket(){
        super.start();
        return sendSocket;
    }

    public void run() {
        try {
            Send(msg, ip);
        } catch (Exception e) {
        }
    }
}

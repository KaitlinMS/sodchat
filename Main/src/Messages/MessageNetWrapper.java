/*
 * MessageNetWrapper.java
 * Handles network connections related to messaging.
 */
package Messages;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class MessageNetWrapper extends Thread {

    // Varibable Declaration
    Socket soc;
    BufferedReader in;
    MessageController mcontroller;
    Boolean Alive;

    // Methods
    public MessageNetWrapper(Socket s, MessageController mc) {
        try {
            soc = s;
            mcontroller = mc;
            in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            Alive = true;
        } catch (Exception e) {
            mcontroller.removeSocket(soc);
            Alive = false;
        }
    }

    public void receiveMessage() {
        try {
            String incMsg = in.readLine();
            if (incMsg == null) { // Ignore blank messages.
                mcontroller.removeSocket(soc);
                Alive = false;
            } else {
                mcontroller.receiveMsg(incMsg, soc);
            }
        } catch (Exception e) {
            mcontroller.removeSocket(soc);
            Alive = false;
        }
    }

    public static void sendMessage(ArrayList<Socket> sockets, Socket fromSocket, String msg) {
        for (int i = 0; i < sockets.size(); i++) {
            try {
                Socket sendTo = sockets.get(i);
                PrintWriter out = new PrintWriter(sendTo.getOutputStream(), true);
                // Only receive messages from a separate socket.
                if (fromSocket != sendTo) {
                    out.println(msg);
                }
            } catch (Exception e) {
            }
        }
    }

    public void run() {
        while (Alive) {
            receiveMessage();
        }
        try {
            soc.close();
            in.close();
        } catch (Exception e) {
        }
    }
}

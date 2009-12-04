package Messages;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class MessageNetWrapper extends Thread {

    Socket soc;
    MessageController mcontroller;
    Boolean Alive;

    public MessageNetWrapper(Socket s, MessageController mc) {
        soc = s;
        mcontroller = mc;
        Alive = true;
    }

    public void receiveMessage() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            String incMsg = in.readLine();
            if (incMsg == null) {
                mcontroller.removeSocket(soc);
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
        } catch (Exception e) {
        }
    }
}

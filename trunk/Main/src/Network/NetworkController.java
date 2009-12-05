package Network;

import sod.*;
import java.net.*;
import java.io.*;

public class NetworkController extends Thread {

    //Listening Variables
    private static final int PORT = 44355;
    private ServerSocket ss;
    //Thread Variables
    private Socket ts;
    private BufferedReader in;
    //Main App
    SODApp sod;

    public NetworkController() {
        try {
            ss = new ServerSocket(PORT);
            sod = SODApp.getApplication();
            this.start();
        } catch (Exception e) {
        }
    }

    private void Listen() {
        try {
            ts = ss.accept();
            in = new BufferedReader(new InputStreamReader(ts.getInputStream()));

            String command = in.readLine();

            if (command.startsWith("con,")) {
                sod.conNetEvent(ts, parseNetEvent(command.substring(4)));
            } else if (command.startsWith("col,")) {
                sod.colNetEvent(ts, parseNetEvent(command.substring(4)));
            } else if (command.startsWith("ftr,")) {
                sod.ftrNetEvent(ts, parseNetEvent(command.substring(4)));
            }

        } catch (Exception e) {
        }
    }

    private void udpListen() {
        try {
            DatagramSocket udpSocket = new DatagramSocket(PORT);
            byte[] msg = new byte[1024];
            DatagramPacket toReceive = new DatagramPacket(msg, msg.length);
            udpSocket.receive(toReceive);
            String command = new String(msg);

            if (command.startsWith("con,")) {
                sod.conNetEvent(ts, parseNetEvent(command.substring(4)));
            } else if (command.startsWith("col,")) {
                sod.colNetEvent(ts, parseNetEvent(command.substring(4)));
            } else if (command.startsWith("ftr,")) {
                sod.ftrNetEvent(ts, parseNetEvent(command.substring(4)));
            }

        } catch (Exception e) {
        }
    }

    public Socket Send(String message, String ip) throws Exception {
        /*Socket sendSocket;
        try {
            sendSocket = new Socket(InetAddress.getByName(ip), PORT);
            PrintWriter sout = new PrintWriter(sendSocket.getOutputStream(), true);
            sout.println(message);
            return sendSocket;
        } catch (Exception e) {
            throw e;
        }*/
        return new NetworkSender(message, ip, PORT).returnSocket();
    }

    public static void udpSend(String message, String ip) throws Exception {
        DatagramSocket sendSocket = new DatagramSocket(PORT, InetAddress.getByName(ip));
        byte[] toSend = message.getBytes();
        DatagramPacket dPacket = new DatagramPacket(toSend, toSend.length, sendSocket.getInetAddress(), PORT);
        sendSocket.send(dPacket);
    }

    private String[] parseNetEvent(String cmd) {
        return cmd.split(",");
    }

    public void run() {
        while (true) {
            Listen();
        }
    }
}

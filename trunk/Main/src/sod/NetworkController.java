package sod;
import java.net.*;
import java.io.*;

public class NetworkController extends Thread{

    //Listening Variables
    private static final int PORT = 44355;
    private ServerSocket ss;

    //Thread Variables
    private Socket ts;
    private BufferedReader in;

    //Main App
    SODApp sod;

    public NetworkController(){
        try{
            ss = new ServerSocket(PORT);
            sod = SODApp.getApplication();
            this.start();
        }
        catch(Exception e){}
    }

    private void Listen(){
        try{
            ts = ss.accept();
            in = new BufferedReader(new InputStreamReader(ts.getInputStream()));

            String command = in.readLine();
            System.out.println(command);
            
            if(command.startsWith("con,"))
                sod.conNetEvent(ts, parseNetEvent(command.substring(4)));

            else if(command.startsWith("msg,"))
                sod.msgNetEvent(ts, parseNetEvent(command.substring(4)));

            else if(command.startsWith("col,")){
                sod.colNetEvent(ts, parseNetEvent(command.substring(4)));
            }

            else if(command.startsWith("ftr,"))
                sod.ftrNetEvent(ts, parseNetEvent(command.substring(4)));
            
            //ss.close();
            in.close();

        }
        catch(Exception e){}
    }

    public Socket Send(String message, String ip) throws Exception{
        Socket sendSocket;
        try{
            sendSocket = new Socket(InetAddress.getByName(ip), PORT);
            PrintWriter sout = new PrintWriter(sendSocket.getOutputStream(), true);
            sout.println(message);
            return sendSocket;
        }
        catch(Exception e){throw e;}
    }

     private String[] parseNetEvent(String cmd){
        int i = Integer.parseInt(cmd.substring(cmd.length() -1));
        String[] parsed = new String[i+1];

        int j, start, end;
        for(j =0, start = 0, end = 0; j<=i; j++){
            end = cmd.indexOf(',', start);
            parsed[j] = cmd.substring(start, end);
            start = end + 1;
        }
        return parsed;
     }

    public void run(){
        while(true){
            Listen();
        }
    }


}

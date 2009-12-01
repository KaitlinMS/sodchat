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
        }
        catch(Exception e){}
    }

    private void Listen(){
        try{
            ts = ss.accept();
            in = new BufferedReader(new InputStreamReader(ts.getInputStream()));

            String command = in.readLine();

            if(command.startsWith("con,"))
                sod.conNetEvent(ts, command.substring(4));

            else if(command.startsWith("msg,"))
                sod.msgNetEvent(ts, command.substring(4));

            else if(command.startsWith("col,"))
                sod.colNetEvent(ts, command.substring(4));

            else if(command.startsWith("ftr,"))
                sod.colNetEvent(ts, command.substring(4));

            ss.close();
            in.close();

        }
        catch(Exception e){}
    }

    public void Send(String message){
        
    }

    public void run(){
        while(true){
            Listen();
        }
    }


}

package Contacts;

import java.net.*;
import java.io.*;

public class ContactNetWrapper extends Thread{

	/*Variables*/
        private Socket soc;
	private BufferedReader in;	//Client Networking Variables
	private PrintWriter out;
        String command;
        String[] parameters;

    	ContactNetWrapper(Socket s, String cmd, String[] param) {
		try{
			soc = s;
                        command = cmd;
                        parameters = param;
                        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                        out = new PrintWriter(soc.getOutputStream());
                        
			this.start();
			this.setPriority(Thread.MIN_PRIORITY);
		}
		catch(UnknownHostException e){new ErrorPrompt("UnknownHost: Check that port 44355 is free");}
		catch(IOException e){new ErrorPrompt("Error: Check that there are no other instances of SOD open");}
	}

	public void response(String yn){
		try{

                    }
		catch(Exception e){new ErrorPrompt("Unknown Host: Check inputted IP");}
                
        }
	
	public void run(){

        }

}

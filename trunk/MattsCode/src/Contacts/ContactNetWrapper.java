package Contacts;

import java.net.*;
import java.io.*;

public class ContactNetWrapper extends Thread{

	/*Variables*/
	private static final int CONTACT_PORT = 44355;

	private ServerSocket ss;	//Server Networking Variables
	private Socket cs;
	private BufferedReader sin;

	private Socket ac;		//Client Networking Variables
	private PrintWriter cout;
        
	private ContactList cl;

    	ContactNetWrapper(ContactList clist) {
		try{
			ss = new ServerSocket(CONTACT_PORT);
			this.start();
			this.setPriority(Thread.MIN_PRIORITY);
		}
		catch(UnknownHostException e){new ErrorPrompt("UnknownHost: Check that port 44355 is free");}
		catch(IOException e){new ErrorPrompt("I/O Exception");}
                cl = clist;
	}
	
	public void listen(){
		String name = null;
		try{
			cs = ss.accept();
			sin = new BufferedReader(new InputStreamReader(cs.getInputStream()));
			
                        //Wait for request message
                        cs.setSoTimeout(20000);

                        //Add the new contact
			name = sin.readLine();
                        String ip = cs.getInetAddress().getHostAddress();
                        cl.add(new Contact(ip, name));

                        cs.close();
                        sin.close();

			
		}
		catch(UnknownHostException e){new ErrorPrompt("Unknown Host: Possible contact request failure");}
		catch(SocketException e){new ErrorPrompt("Socket Exceptiop: Possible contact request failure");}
		catch(IOException e){new ErrorPrompt("I/O Exception");}
	}

	public void notify(Contact c, String yn){
		try{
			InetAddress ip = InetAddress.getByName(c.getIp());
                        
			ac = new Socket(ip, CONTACT_PORT);
			cout = new PrintWriter(ac.getOutputStream(), true);

                        //Send notification that they have been addeds
                        cout.println(yn);

			ac.close();
			cout.close();
                    }
		catch(UnknownHostException e){new ErrorPrompt("Unknown Host: Check inputted IP");}
		catch(SocketException e){new ErrorPrompt("Socket Exception: Check inputted IP");}
                catch(SocketTimeoutException e){new ErrorPrompt("Network Timeout: Check Entered IP or User may be busy");}
		catch(IOException e){new ErrorPrompt("I/O Exception");}
	} 
	
	public void run(){
		while(true)
			listen();
	}

}

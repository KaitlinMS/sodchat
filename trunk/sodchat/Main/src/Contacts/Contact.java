package Contacts;

import java.net.*;

public class Contact {

	private InetAddress ip;
	private String name;

	public Contact(String i, String n){
		try{
			ip = InetAddress.getByName(i);
			name = n;
		}
		catch(UnknownHostException e){}	
	}

	public String getIp(){
                return ip.getHostAddress();

	}

	public String getName(){
                String n = new String(name);
		return n;
	}

        public void changeName(String nn){
            name = nn;
        }

        public String toString(){
            return name + " - " + ip.getHostAddress();
        }
}

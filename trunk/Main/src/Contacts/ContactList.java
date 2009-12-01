package Contacts;

import java.net.*;
import java.util.ArrayList;

public class ContactList {
	private ArrayList<Contact> c;

	ContactList(){
		c = new ArrayList<Contact>();
	}

	public Boolean search(String ip){
		try{
			int i = 0;
			String s = InetAddress.getByName(ip).getHostAddress();
			while(i < c.size()){
				if(c.get(i).getIp().equals(s)) 
					return true;
				i++;
			}
			return false;
		}
		catch(UnknownHostException e){return false;}	
	}

	public void remove(String ip){
		try{
			int i = 0;
			String s = InetAddress.getByName(ip).getHostAddress();
                        //Removes all contacts associated with ip
			while(i < c.size()){
				if(c.get(i).getIp().equals(s))
					{c.remove(i); i--;}
				i++;
			}
		}
		catch(UnknownHostException e){}	
	}

	public void remove(int i){
            c.remove(i);
	}

	public void add(Contact con){
		c.add(con);
	}

	public String getName(String ip){
		try{
			String s = InetAddress.getByName(ip).getHostAddress();
			int i = 0;
			while(i < c.size()){
				if(c.get(i).getIp().equals(s))
					return c.get(i).getName();
				i++;
			}
			return "Does not Exist";
		}
		catch(UnknownHostException e){return "Bad IP";}			
	}

	public Contact[] getAll(){
		Contact[] a = new Contact[c.size()];
		return c.toArray(a);
	}

	public String[] getAllNames(){
		String[] a = new String[c.size()];
                for(int i = 0; i< c.size(); i++)
                    a[i] = c.get(i).getName();
                return a;
	}

        public String[] getAllIps(){
		String[] a = new String[c.size()];
                for(int i = 0; i< c.size(); i++)
                    a[i] = c.get(i).getIp();
                return a;
	}

        public int getLength(){
            return c.size();
        }
	
}

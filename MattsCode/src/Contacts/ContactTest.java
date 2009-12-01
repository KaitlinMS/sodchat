package Contacts;

import java.net.*;
import java.io.*;

public class ContactTest {

    	public static void main(String[] args) {
		try{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			ContactController cc = new ContactController();
			String input;

			while(true){
				input = in.readLine();
				//if (input.equals("ac")) cc.addContact();
				//if (input.equals("rc")) cc.removeContact();
				if (input.equals("cn")) cc.changeName();
				if (input.equals("gn")) {input = in.readLine(); cc.getName(input);}
				if (input.equals("ce")) {input = in.readLine(); cc.getName(input);}
			}
		}catch(IOException e){}
	}
}


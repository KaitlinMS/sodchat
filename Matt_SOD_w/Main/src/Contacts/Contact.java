/*
 * Contact.java
 * Data structure that holds the information for contacts
 */

package Contacts;

import java.net.*;

public class Contact {

    // Variable declaration
    private InetAddress ip;
    private String name;

    // Methods
    public Contact(String i, String n) {
        try {
            ip = InetAddress.getByName(i);
            name = n;
        } catch (UnknownHostException e) {
        }
    }

    public String getIp() {
        return ip.getHostAddress();
    }

    public String getName() {
        String n = new String(name);
        return n;
    }

    public void changeName(String nn) {
        name = nn;
    }

    public String toString() {
        return name + " - " + ip.getHostAddress();
    }
}

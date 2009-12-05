/*
 * ContactList.java
 * Handles the storage of contacts as well as the removal and addition of contacts
 */
package Contacts;

import java.net.*;
import java.util.ArrayList;

public class ContactList {

    // Variable declarations
    private ArrayList<Contact> c;

    // Methods
    ContactList() {
        c = new ArrayList<Contact>();
    }

    // Converts the given IP address into a proper IP address and searches
    // the contact list for that existing IP address.
    public Boolean search(String ip) {
        try {
            int i = 0;
            String s = InetAddress.getByName(ip).getHostAddress();
            while (i < c.size()) {
                if (c.get(i).getIp().equals(s)) {
                    return true;
                }
                i++;
            }
            return false;
        } catch (UnknownHostException e) {
            return false;
        }
    }

    // Converts the given IP into a proper IP, then removes all contacts
    // associated with that IP address.
    public void remove(String ip) {
        try {
            int i = 0;
            String s = InetAddress.getByName(ip).getHostAddress();
            while (i < c.size()) {
                if (c.get(i).getIp().equals(s)) {
                    c.remove(i);
                    i--;
                }
                i++;
            }
        } catch (UnknownHostException e) {
        }
    }

    public void remove(int i) {
        c.remove(i);
    }

    public void add(Contact con) {
        c.add(con);
    }

    // This method is not used but may be used in the future.
    // Searches the contact list for a given IP address and returns the
    // contact's name.
    public String getName(String ip) {
        try {
            String s = InetAddress.getByName(ip).getHostAddress();
            int i = 0;
            while (i < c.size()) {
                if (c.get(i).getIp().equals(s)) {
                    return c.get(i).getName();
                }
                i++;
            }
            return "Does not Exist";
        } catch (UnknownHostException e) {
            return "Bad IP";
        }
    }

    // Not used but may be in the future.
    // Returns all contacts stored.
    public Contact[] getAll() {
        Contact[] a = new Contact[c.size()];
        return c.toArray(a);
    }

    public String[] getAllNames() {
        String[] a = new String[c.size()];
        for (int i = 0; i < c.size(); i++) {
            a[i] = c.get(i).getName();
        }
        return a;
    }

    public String[] getAllIps() {
        String[] a = new String[c.size()];
        for (int i = 0; i < c.size(); i++) {
            a[i] = c.get(i).getIp();
        }
        return a;
    }

    public int getLength() {
        return c.size();
    }

    public void saveList() {
    }
}

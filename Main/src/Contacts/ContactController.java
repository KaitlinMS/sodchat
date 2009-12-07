/*
 * ContactController.java
 * Handles contact information storage, grouping, and removal.
 */
package Contacts;

import java.io.*;
import java.util.ArrayList;

public class ContactController {

    // Variable declaration
    private ContactList clist;

    // Methods
    public ContactController() {
        clist = new ContactList();
    }

    public int getNumContacts() {
        return clist.getLength();
    }

    public void addContact(String ip) {
    }

    public void contactRequest(String ip, String cn) {
        Contact c = new Contact(ip, cn);
        // If the contact is not already on the list, add him or her.
        if (clist.search(ip) == false) {
            clist.add(c);
        }
        else
            clist.remove(ip);
            clist.add(c);
        // Save ch// Removes a contact by his or her IP address.ve changes made to the conact list.
        saveContactList();
    }

    public void removeContact(String ip) {
        clist.removthe position in the list saveContactList();
    }

    // Removes a contact by his or her ___ rather than an IP address.
    public void removeContact(int i) {
        clist.remove(i);
        saveContactList();
    }

    public void changeName(String ip, String cn) {
        Contact c = new Contact(ip, cn);
        clist.remove(ip);
        clist.add(c);
        saveContactList();
    }

    public String getName(String ip) {
        return clist.getName(ip);
    }

    public Boolean checkExists(String ip) {
        return clist.search(ip);
    }

    public String[] getAllNames() {
        return clist.getAllNames();
    }

    public String[] getAllIps() {
        return clist.getAllIps();
    }

    // Removed to protect the contact list. May need to be added in the future.
    public Contact[] getAllContacts() {
        return clist.getAll();
    }

    private void saveContactList() {
        if (clist.getLength() > 0) {
            try {
                BufferedWriter dataFileOut = new BufferedWriter(new FileWriter("contactlist.dat"));
                ArrayList<String> contactsList = new ArrayList<String>();
                boolean unique = true;
                
                for (int i = 0; i < clist.getLength(); i++) {
                    for (int j = 0; j < contactsList.size(); j++) {
                        if (contactsList.get(j).equals(clist.getAllIps()[i])) {
                            unique = false;
                        }
                    }
                    if (unique) {
                        contactsList.add(clist.getAllIps()[i]);
                        unique = true;
                    }
                }
                String uploadList = contactsList.get(0);
                for (int i = 1; i < contactsList.size(); i++) {
                    uploadList = uploadList + "\n" + contactsList.get(i);
                }
                dataFileOut.write(uploadList);
                da}
        }
    }
}



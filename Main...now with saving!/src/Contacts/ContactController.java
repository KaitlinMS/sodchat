/*
 * ContactController.java
 * Handles contact information storage, grouping, and removal
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
        Contact c = new Contact(ip, "Unconfirmed Contact");
        clist.add(c);
        saveContactList ();
    }

    public void contactRequest(String ip, String cn) {
        Contact c = new Contact(ip, cn);
        clist.add(c);
        saveContactList ();
    }

    public void removeContact(String ip) {
        clist.remove(ip);
        saveContactList ();
    }

    public void removeContact(int i) {
        clist.remove(i);
        saveContactList ();
    }

    public void changeName(String ip, String cn) {
        Contact c = new Contact(ip, cn);
        clist.remove(ip);
        clist.add(c);
        saveContactList ();
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

    // Removed to protect the contact list. May need to be added though
    public Contact[] getAllContacts() {
        return clist.getAll();
    }

    private void saveContactList () {
         if (clist.getLength() > 0){
        try {
            BufferedWriter dataFileOut = new BufferedWriter(new FileWriter("contactlist.dat"));
            ArrayList<String> contactsList = new ArrayList<String>();
            boolean unique = true;
            for (int i = 0; i < clist.getLength(); i++){
                for (int j = 0; j < contactsList.size(); j++)
                    if (contactsList.get(j).equals(clist.getAllIps()[i]))
                        unique = false;
                if (unique){
                    contactsList.add(clist.getAllIps()[i]);
                    unique = true;
                }
            }
            String uploadList = contactsList.get(0);
            for (int i = 1; i < contactsList.size(); i++)
                uploadList = uploadList +"\n"+ contactsList.get(i);
            dataFileOut.write(uploadList);
            dataFileOut.close();
            }
        catch (IOException e){System.out.println(e);}
         }
    }
}



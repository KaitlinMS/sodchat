/*
 * ContactController.java
 * Handles contact information storage, grouping, and removal
 */

package Contacts;

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

    public void addContact(String ip, String cn, String un) {
        Contact c = new Contact(ip, cn);
        clist.add(c);
    }

    public void contactRequest(String ip, String cn) {
        Contact c = new Contact(ip, cn);
        clist.add(c);
    }

    public void removeContact(String ip) {
        clist.remove(ip);
    }

    public void removeContact(int i) {
        clist.remove(i);
    }

    public void changeName(String ip, String cn) {
        Contact c = new Contact(ip, cn);
        clist.remove(ip);
        clist.add(c);
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
}


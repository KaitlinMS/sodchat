package Contacts;

public class ContactController{

	/*Variables*/
	private ContactList clist;
	private ContactNetWrapper cnet;
	
	public ContactController(){
		clist = new ContactList();
		cnet = new ContactNetWrapper(clist);
	}

        public int getNumContacts(){
            return clist.getLength();
        }

	public void addContact(String ip, String cn, String un){
            Contact c = new Contact(ip, cn);
            cnet.notify(c, un);
            clist.add(c);
	}

	public void removeContact(String ip){
		clist.remove(ip);
	}

	public void removeContact(int i){
		clist.remove(i);
	}

	public void changeName(){
		new ChangeContactNamePrompt(clist);
	}

	public String getName(String ip){
		return clist.getName(ip);
	}

	public Boolean checkExists(String ip){
		return clist.search(ip);
	}

	public String[] getAllNames(){
		return clist.getAllNames();
	}

	public String[] getAllIps(){
		return clist.getAllIps();
	}

        /*Removed to protect the contact list. May need to be added though
        public Contact[] getAllContacts(){
                return clist.getAll();
        }
        */

}


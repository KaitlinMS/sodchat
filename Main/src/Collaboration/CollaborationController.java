package Collaboration;
import java.net.*;
import java.io.*;
import java.util.ArrayList;


public class CollaborationController {

    //Variables
    public CollaborationNetWrapper cnw;

    private ArrayList<Collaboration> collaborations;

    public CollaborationController(){
        collaborations = new ArrayList();

    }

    public void hostNew(Boolean priv, Boolean oct, String chatName, String[] ips){
        newCollab(priv, oct, chatName, ips);
    }

    public void joinNew(Socket js, String chatName){
        try{
            System.out.println("Joining");
            Boolean b = cnw.canJoin(js);
            if(b) newCollab(js, chatName);
            else js.close();
        }
        catch(Exception e){}
    }

    public void End(String name){
        
    }

    public void newCollab(Socket s, String name){
        System.out.println("join");
        collaborations.add(new Collaboration(s, name));
    }

    public void newCollab(Boolean p, Boolean o, String chatName, String[] ips){
        collaborations.add(new Collaboration(p, o, chatName, ips));
    }

    public void joinRequest(Socket s, String ip, String chatName){
        Boolean exists = false;
        int i;
        Collaboration collab;
        for(i = 0; i<collaborations.size(); i++){
            if ((collab = collaborations.get(i)).toString().equals(chatName)){
                    exists = true;
                    break;
            }
        }
            System.out.println("Handling join request" + i);
        collab = collaborations.get(i);
        if(exists == false){
            cnw.respond(s, "DNE");
        }
        else if(collab.getPrivate() && collab.isInvited(ip)){
            cnw.respond(s, "PRIVATE");
        }
        else{
            collab.addMember(s);
        }
    }

}

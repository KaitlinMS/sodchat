package Collaboration;
import java.net.*;
import java.io.*;
import java.util.ArrayList;


public class CollaborationController {

    //Variables
    public CollaborationNetWrapper cnw;

    private ArrayList<Collaboration> collaborations;

    public CollaborationController(){

    }

    public void hostNew(Boolean priv, Boolean oct, String chatName, String[] ips){
        newCollab(priv, oct, chatName, ips);
    }

    public void joinNew(Socket js){
        try{
            Boolean b = cnw.Join(js, this);
            if(b) newCollab(js);
            else js.close();
        }
        catch(Exception e){}
    }

    public void End(String name){
        
    }

    public void newCollab(Socket js){
        
    }

    public void newCollab(Boolean p, Boolean o, String chatName, String[] ips){

    }

}

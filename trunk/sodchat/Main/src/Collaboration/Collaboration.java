package Collaboration;

import java.net.*;
import sod.MessageView;
import java.util.ArrayList;

public class Collaboration extends Thread{

    //Variables
    private MessageView mview;
    //MessageController mc;
    private ArrayList<Socket> socketList;
    
    private String Name;
    private Boolean priv = false;
    private Boolean oct = false;
    private String[] invited;

    public Collaboration(Socket s, String name){
        socketList = new ArrayList();
        //mc = new MessageController();
        mview = new MessageView();
        mview.setVisible(true);
        socketList.add(s);
        Name = name;
        
    }

    public Collaboration(Boolean p, Boolean o, String name, String[] inv){
        socketList = new ArrayList();
        //mc = new MessageController();
        mview = new MessageView();
        mview.setVisible(true);
        Name = name;
        priv = p;
        oct = o;
        invited = inv;

    }

    public void addMember(Socket s){
        socketList.add(s);
    }

    public String toString(){
        return Name;
    }

    public void close(){

    }

    public Boolean getPrivate(){
        return priv;
    }

    public Boolean getOct(){
        return oct;
    }

    public Boolean isInvited(String ip){
            System.out.println("Handling join request ");
        for(int i = 0; i<invited.length; i++){
            if (ip.equals(invited[i])){
                return true;
            }
        }
        return false;
    }

    public void run(){
        
    }


}

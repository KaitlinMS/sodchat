package Collaboration;

import java.net.*;
import sod.MessageView;

public class Collaboration extends Thread{

    //Variables
    MessageView mview;
    //MessageController mc;
    Socket[] socketList;

    public Collaboration(){
        //mc = new MessageController();
        mview = new MessageView();
        mview.setVisible(true);
        
    }

    public void run(){
        
    }

}

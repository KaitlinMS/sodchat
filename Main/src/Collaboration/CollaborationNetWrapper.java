package Collaboration;

import java.net.*;
import java.io.*;

public class CollaborationNetWrapper {


    public CollaborationNetWrapper() {
    }

    public Boolean canJoin(Socket s) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            s.setSoTimeout(5000);
            String response = in.readLine();
            s.setSoTimeout(0);
            if(response.equals("PRIVATE"))
                new sod.ErrorPrompt("The chat you were trying to join is private");
            else if(response.equals("ACCEPT")){
                in.close();
                out.close();
                return true;
            }
            else if(response.equals("DNE"))
                new sod.ErrorPrompt("The chat you were trying to join does not exist");
            in.close();
            out.close();
        } catch (Exception e) {
            new sod.ErrorPrompt("Unable to join collaboration. Check that you entered the correct ip address");
        }
        return false;
    }

    public void respond(Socket s, String msg){
        try {
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            out.println(msg);
            out.close();
        }
        catch(Exception e){}

    }

    public void acceptInvite(Socket s) {
    }

    public void declineInvite(Socket s) {
    }

    public void joinRequest(String ip, String chatName){
        
    }
}

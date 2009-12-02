/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package filetransfercontroller;

/**
 *
 * @author root
 */
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class netWrapper
{
    public static void send (File pathToFile) throws IOException
    {
        // set buffer size to 1 kb
        byte fileBuffer [] = new byte [1024];

        // pass specified file into stream
        FileInputStream file = new FileInputStream (pathToFile);

        // use port 2345 (can be any port number)
        ServerSocket servSocket = new ServerSocket (2345);

        // wait for connection from client side
        Socket cSocket = servSocket.accept();
        OutputStream out = cSocket.getOutputStream();

        //transfering the file
        int size;
        while ((size = file.read(fileBuffer)) != -1)
        {
            out.write(fileBuffer, 0, size);
            out.flush();
        }
        cSocket.close();
    }

    public static void receive (InetAddress ip, String newFileName) throws UnknownHostException, IOException
    {
        // set buffer size to 1 kb
        byte fileBuffer [] = new byte [1024];

        // connect to specified port by default it is 2345
        Socket cSocket = new Socket(ip, 2345);
        InputStream in = cSocket.getInputStream();

        // save as the specified filename
        FileOutputStream saveFile = new FileOutputStream(newFileName);

        // timer
        long startTime = System.currentTimeMillis();

        // write into file (saveFile)
        int size;
        while ((size = in.read(fileBuffer)) != -1)
        {
            saveFile.write(fileBuffer, 0, size);
            saveFile.flush();
        }
        cSocket.close();
        saveFile.close();

        // get file size, time and speed
        // file size
        File temp = new File(newFileName);
        long fileSize = temp.length();
        long endTime = System.currentTimeMillis();
        // calculate elapsed time
        double eTime = ((double)endTime - (double)startTime)/1000;
        // calculate speed of transfer
        double speed = ((double)fileSize/1024)/eTime;

        System.out.println("Duration: " + eTime + " seconds");
        System.out.println("Speed: " + speed + " KB/s");
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testsc;

/**
 *
 * @author root
 */
import java.io.*;
import java.net.*;

public class Client
{
    public static void main(String[] args)
       throws UnknownHostException, IOException
    {
        // buffer size = 1 KB
        byte data[] = new byte[1024];

        // connect to the specified server's port 2345
        Socket s = new Socket(args[0], 2345);
        InputStream in = s.getInputStream();

        // save as the specified filename
        FileOutputStream fileOut = new FileOutputStream(args[1]);

        long start = System.currentTimeMillis();

        // write into file
        int size;
        while ((size = in.read(data)) != -1)
        {
            fileOut.write(data, 0, size);
            fileOut.flush();
        }
        s.close();
        fileOut.close();

        // get the file size
        File file = new File(args[1]);
        long fileSize = file.length();

        long end = System.currentTimeMillis();

        // calculate the transfer time (second) and the speed (KB/s), then print it
        double duration = ((double) end - (double) start) / 1000.0;
        double speed = ((double) fileSize / 1024) / duration;
        System.out.println("Duration: " + duration + " seconds");
        System.out.println("Speed: " + speed + " KB/s");
    }
}
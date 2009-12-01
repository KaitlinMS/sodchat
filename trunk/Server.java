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

public class Server
{
    public static void main(String[] args) throws IOException
    {
        // buffer size = 1 KB
        byte data[] = new byte[1024];

        // open the specified file
        FileInputStream fileIn = new FileInputStream(args[0]);

        // use port 2345
        ServerSocket ss = new ServerSocket(2345);

        // wait for connection
        Socket s = ss.accept();
        OutputStream out = s.getOutputStream();

        // transfer the file
        int size;
        while ((size = fileIn.read(data)) != -1)
        {
            out.write(data, 0, size);
            out.flush();
        }
        s.close();
    }
}
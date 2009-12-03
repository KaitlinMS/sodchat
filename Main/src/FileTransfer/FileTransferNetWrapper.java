/*
 * FileTransferNetWrapper.java
 * Handles network connections related to file transfers.
 */

package FileTransfer;

import java.io.*;
import java.net.*;

public class FileTransferNetWrapper extends Thread {

    // Variable declarations
    private Boolean incoming;
    private Socket s;
    private String path;
    private String fileName;
    private int progress;

    // Methods
    public FileTransferNetWrapper(Boolean inc, String fpath, String fname, Socket soc) {
        incoming = inc;
        s = soc;
        path = fpath;
        fileName = fname;
    }

    public int getProgress() {
        return progress;
    }

    public void Accept() {
        try {
            // set buffer size to 1 kb
            byte fileBuffer[] = new byte[1024];

            InputStream in = s.getInputStream();
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            out.println("ACCEPT");

            // save as the specified filename
            FileOutputStream saveFile = new FileOutputStream(new File(path + "/" + fileName));

            // timer
            long startTime = System.currentTimeMillis();

            // write into file (saveFile)
            int size;
            while ((size = in.read(fileBuffer)) != -1) {
                saveFile.write(fileBuffer, 0, size);
                saveFile.flush();
            }
            s.close();
            saveFile.close();
            out.close();
        } catch (Exception e) {
            new sod.ErrorPrompt("An error occured while recieving a file");
        }
    }

    public static void Decline(Socket soc) {
        try {
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
            out.println("DECLINE");
            out.close();
        } catch (Exception e) {
        }
    }

    public void Send() {
        try {
            // set buffer size to 1 kb
            byte fileBuffer[] = new byte[1024];

            // pass specified file into stream
            FileInputStream file = new FileInputStream(new File(path));

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String response = in.readLine();

            if (response.equals("ACCEPT")) {

                OutputStream out = s.getOutputStream();

                //transfering the file
                int size;
                while ((size = file.read(fileBuffer)) != -1) {
                    out.write(fileBuffer, 0, size);
                    out.flush();
                }
            }
            s.close();
            in.close();
        } catch (Exception e) {
            new sod.ErrorPrompt("There was an error while sending the file");
        }

    }

    public void run() {
        if (incoming) {
            System.out.println("recieving");
            Accept();
        } else {
            System.out.println("sending");
            Send();
        }
    }
}

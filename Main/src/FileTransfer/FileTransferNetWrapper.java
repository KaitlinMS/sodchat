/*
 * FileTransferNetWrapper.java
 * Handles network connections related to file transfers.
 */

package FileTransfer;

import sod.FileTransfer;
import java.io.*;
import java.net.*;

public class FileTransferNetWrapper extends Thread {

    // Variable declarations
    private Boolean incoming;
    private Socket s;
    private String path;
    private String fileName;
    private FileTransfer fileTrans;

    // Methods
    public FileTransferNetWrapper(Boolean inc, String fpath, String fname, Socket soc, FileTransfer ft){
        incoming = inc;
        s = soc;
        path = fpath;
        fileName = fname;
        fileTrans = ft;
    }   

    public void Accept() {
        try {
            // set buffer size to 1 kb
            byte fileBuffer[] = new byte[1024];

            InputStream in = s.getInputStream();
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            out.println("ACCEPT");

            // save as the specified filename
            File recFile = new File(path + "/" + fileName);
            FileOutputStream saveFile = new FileOutputStream(recFile);

            // write into file (saveFile)
            int size;
            while ((size = in.read(fileBuffer)) != -1) {
                saveFile.write(fileBuffer, 0, size);
                saveFile.flush();
            }
            s.close();
            saveFile.close();
            out.close();
            fileTrans.complete();
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
            File sendFile = new File(path);
            FileInputStream file = new FileInputStream(sendFile);

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
            fileTrans.complete();
        } catch (Exception e) {
            new sod.ErrorPrompt("There was an error while sending the file");
        }

    }

    public void run() {
        if (incoming) {
            Accept();
        } else {
            Send();
        }
    }
}

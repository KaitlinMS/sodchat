package FileTransfer;
import java.io.*;
import java.net.*;

public class FileTransferController {

    Boolean incoming;
    String contactName;
    String contactIp;
    String fileName;
    File path;
    Socket fs;

    public FileTransferController(Boolean inc, String conName, String conIp){
        incoming = inc;
        contactName = conName;
        contactIp = conIp;
        
    }

    public FileTransferController(Boolean inc, String conName, String conIp, String fName, Socket s){
        incoming = inc;
        contactName = conName;
        contactIp = conIp;
        fileName = fName;
        fs = s;

    }

}

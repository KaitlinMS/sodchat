/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package filetransfercontroller;

/**
 *
 * @author root
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.net.*;

public class locationPrompt extends JFrame
{
    public locationPrompt ()
    {
        super ("File Transfer");
        setSize (350, 200);
        setDefaultCloseOperation (EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JButton sendButton = new JButton("Send");
        JButton receiveButton = new JButton("Receive");
        final TextField getIP = new TextField();
        getIP.setText ("\t\t\t\t\t");

        final JTextArea statusbar = new JTextArea(5,20);
        statusbar.setEditable(false);
        statusbar.setText("Instructions:\nTo send: click send and select a file\nTo receive: First enter the IP address and click receive\nand specify a file name and then save");
        

        // creating Open dialog
        sendButton.addActionListener (new ActionListener()
        {
            public void actionPerformed (ActionEvent ae)
            {
                JFileChooser chooser = new JFileChooser ();
                statusbar.setText("Please wait for the receiver to accept");
                int option = chooser.showOpenDialog(chooser);
                statusbar.setText("I am here");
                
                if (option == JFileChooser.APPROVE_OPTION)
                {
                    File sf = chooser.getSelectedFile();
                    try
                    {
                        netWrapper.send(sf);
                    }
                    catch (IOException e)
                    {
                        System.out.println ("An error occured "+ e.getMessage());
                    }
                    statusbar.setText ("You have transfered " + ((chooser.getSelectedFile() != null) ? chooser.getSelectedFile().getName(): "nothing"));
                }
                else
                    statusbar.setText ("You canceled");   
            }
        });


        // Create a save dialog
        receiveButton.addActionListener(new ActionListener()
        {
           public void actionPerformed (ActionEvent ae)
           {
               //statusbar.setText ("Enter sender IP in the textbox");
               if (getIP.getText().equals("\t\t\t\t\t"))
               {
                   statusbar.setText("You entered an incorrect value");
               }
               else
               {
                   JFileChooser chooser = new JFileChooser ();
                   int option = chooser.showSaveDialog (chooser);
                   if (option == JFileChooser.APPROVE_OPTION)
                   {
                       try
                       {
                           InetAddress ip = InetAddress.getByName(getIP.getText());
                           try
                           {
                               netWrapper.receive(ip, chooser.getSelectedFile().getName());
                           }
                           catch (IOException e)
                           {
                               System.out.println ("An error occured"+e.getMessage());
                           }
                       }
                       catch (UnknownHostException u)
                       {
                           System.out.println ("An error occured ");
                       }
                       statusbar.setText ("You received " + ((chooser.getSelectedFile() != null) ? chooser.getSelectedFile().getName(): "nothing"));
                   }
                   else
                       statusbar.setText ("You canceled");
               }
               /*
               */
           }
        });

        c.add(sendButton);
        c.add(receiveButton);
        c.add(statusbar);
        c.add(getIP);
    }
  }


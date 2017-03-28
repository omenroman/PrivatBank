/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omenroman.testwork.client;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author админ
 */
public class Client {

    public static void main(String[] args) {
        String host = "localhost";
        int port = 8080;
        
        try {
            Socket socket = new Socket(host, port);
            
            PrintWriter out = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())),
                    true);
           Scanner in = new Scanner(System.in);
                
            String line = null;
            line = in.nextLine();
            out.println((line));
            //System.out.println(new String(line,StandardCharsets.UTF_8));
            out.flush();
            DataInputStream data = new DataInputStream(socket.getInputStream());
            String rez = data.readUTF();
            System.out.println(rez);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

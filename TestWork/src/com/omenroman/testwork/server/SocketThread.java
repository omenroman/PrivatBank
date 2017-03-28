/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omenroman.testwork.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author админ
 */
public class SocketThread extends Thread {

    private Socket socket;
    private InputStream is;
    private DataOutputStream os;

    public SocketThread(Socket socket) throws IOException {
        this.socket = socket;
        this.is = socket.getInputStream();
        this.os = new DataOutputStream(socket.getOutputStream());
        
    }

    @Override
    public void run() {
        
        String text;
        try {
            text = readInputData();
            
            prepareAnswer(text);
        } catch (IOException ex) {
            Logger.getLogger(SocketThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String readInputData() throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(is));
        String rez = buf.readLine();
        return rez;
    }
    private void prepareAnswer(String text) throws IOException{
        String com = parseCommand(text);
        String[] param ={};
        if(!text.equals(com)){
            param = parseParameters(text);
            
        }

        Command command =new Command();
        switch(com.trim()){
            case "list":os.writeUTF(command.getList());break;
            case "sum":os.writeUTF(command.getSum());break;
            case "count":os.writeUTF(command.getCount());break;
            case "info account":os.writeUTF(command.getInfoAccount(Long.parseLong(param[0])));break;
            case "info depositor":os.writeUTF(command.getInfoDepositor(param[0]));break;
            case "show type":os.writeUTF(command.getByType(param[0]));break;
            case "show bank":os.writeUTF(command.getByBank(param[0]));
            case "add":os.writeUTF(command.addToBD(param));break;
            case "delete":os.writeUTF(command.delete(Long.parseLong(param[0])));break;
        }
        os.flush();

    }
    private String[] parseParameters(String text){
        text = text.substring(text.indexOf("<")+1,text.length()-1);
        return text.split(",");
    }
    private String parseCommand(String text) {
        if (text.contains("<")) {
            String s[] = text.split("<");
            return s[0];
        } else {
            return text;
        }

    }

   
}

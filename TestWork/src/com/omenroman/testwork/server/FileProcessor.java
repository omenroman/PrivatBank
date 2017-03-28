/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omenroman.testwork.server;

import com.omenroman.testwork.common.Deposit;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author админ
 */
public class FileProcessor {
    public void addToFile(ArrayList<Deposit> deposits) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("deposits.data"))) {

            out.writeObject(deposits);
            out.flush();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Deposit> readFromFile() {
        ArrayList<Deposit> deposits =new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("deposits.data"))) {
            deposits = (ArrayList<Deposit>) in.readObject();
            return deposits;
        }
        catch (EOFException e){
            return deposits;
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}

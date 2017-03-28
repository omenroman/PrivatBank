/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omenroman.testwork.server;

import com.omenroman.testwork.common.Country;
import com.omenroman.testwork.common.Deposit;
import com.omenroman.testwork.common.Status;
import com.omenroman.testwork.common.Type;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author админ
 */
public class Command {

    private static ArrayList<Deposit> list = new ArrayList<>();

    public Command() {

        if (list.isEmpty()) {
            readFile();
        }
    }

    private void readFile() {
        File file = new File("deposits.data");
        if (file.exists()) {
            FileProcessor fp = new FileProcessor();
            list = fp.readFromFile();
        }
    }

    private void writeToFile() {
        FileProcessor fp = new FileProcessor();
        fp.addToFile(list);
    }

    public String getList() {
        if(list.isEmpty()){
            return Status.DB_EMPTY.getStatus();
        }
        String rezult = "";
        for (Deposit dep : list) {
            rezult += dep.toString() + "\n";
        }
        return rezult;
    }

    public String getSum() {
        return Deposit.getSum() + "";
    }

    public String getCount() {
        return list.size() + "";
    }

    public String getInfoAccount(long id) {
        for (Deposit dep : list) {
            if (dep.getAccountId() == id) {
                return dep.toString();
            }
        }
        return Status.ACCOUNT_NOT_FOUND.getStatus();
    }

    public String getInfoDepositor(String name) {
        String rezult = "";
        for (Deposit dep : list) {
            if (dep.getDepositor().equals(name)) {
                rezult += dep.toString()+"\n";
            }
        }
        if(!rezult.isEmpty()) {
            return rezult;
        }else {
            return Status.DEPOSITOR_NOT_FOUND.getStatus();
        }
    }

    public String getByType(String type) {
        
        String rezult = "";
        for (Deposit dep : list) {
            if (dep.getType().getDescription().equals(type)) {
                rezult += dep.toString()+"\n";
            }
        }
        if(!rezult.isEmpty()) {
            return rezult;
        }else {
            return Status.TYPE_NOT_FOUND.getStatus();
        }
    }
    public String getByBank(String bank) {

        String rezult = "";
        for (Deposit dep : list) {
            if (dep.getName().equals(bank)) {
                rezult += dep.toString()+"\n";
            }
        }
        if(!rezult.isEmpty()) {
            return rezult;
        }else {
            return Status.BANK_NOT_FOUND.getStatus();
        }
    }

    //add <RRR,Украина,расчетный,Роман,34430343423,30000,12,16>
    public String addToBD(String[] arg){
        long accountId = Long.parseLong(arg[4]);
        double amount = Double.parseDouble(arg[5]);
        double profitability = Double.parseDouble(arg[6]);
        int time = Integer.parseInt(arg[7]);
        if (amount<=0||profitability<=0||time<=0){
            return Status.INCORRECT_DIGITS.getStatus();
        }
        for (Deposit dep:list) {
            if(dep.getAccountId()==accountId){
                return Status.ACCOUNT_EXIST.getStatus();
            }
        }

        Deposit dep = new Deposit(arg[0],
                Country.getCountry(arg[1]),
                Type.getType(arg[2]),
                arg[3],
                accountId,
                amount,
                profitability,
                time);
        list.add(dep);
        writeToFile();
        return Status.DEPOSIT_ADD.getStatus();
    }
    public String delete(long id){
        for(int i = 0;i<list.size();i++){
            if(list.get(i).getAccountId()==id){
                list.remove(i);
                return Status.DEPOSIT_DELETE.getStatus();
            }
        }
        writeToFile();
        return Status.DEPOSIT_NOT_FOUND.getStatus();
    }
}

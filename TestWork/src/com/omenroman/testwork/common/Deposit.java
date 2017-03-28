/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omenroman.testwork.common;

import java.io.Serializable;

/**
 *
 * @author админ
 */
public class Deposit implements Serializable{
    private String name;
    private Country country;
    private Type type;
    private String Depositor;
    private long accountId;
    private double amount;
    private double profitability;
    private int timeConstraints;
    private static double sum; 

    public Deposit(String name, Country country, Type type, String Depositor, long accountId, double amount, double profitability, int timeConstraints) {
        this.name = name;
        this.country = country;
        this.type = type;
        this.Depositor = Depositor;
        this.accountId = accountId;
        this.amount = amount;
        this.profitability = profitability;
        this.timeConstraints = timeConstraints;
        sum+=amount;
    }

    

   

    public static double getSum() {
        return sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDepositor() {
        return Depositor;
    }

    public void setDepositor(String Depositor) {
        this.Depositor = Depositor;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getProfitability() {
        return profitability;
    }

    public void setProfitability(double profitability) {
        this.profitability = profitability;
    }

    public int getTimeConstraints() {
        return timeConstraints;
    }

    public void setTimeConstraints(int timeConstraints) {
        this.timeConstraints = timeConstraints;
    }

    @Override
    public String toString() {
        return "Deposit{" + "name=" + name + ", country=" + country.getDescription() + ", type=" + type.getDescription() + ", Depositor=" + Depositor + ", accountId=" + accountId + ", amount=" + amount + ", profitability=" + profitability + ", timeConstraints=" + timeConstraints + '}';
    }
    
}

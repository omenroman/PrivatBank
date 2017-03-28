/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omenroman.testwork.common;

/**
 *
 * @author админ
 */
public enum Country {
    UKRAINE("Украина"),
    LATVIA("Латвия");
    
    private String description;

    private Country(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Country getCountry(String name){
        for (Country c:values()) {
            if(c.getDescription().equals(name)){
                return c;
            }
        }
        return null;
    }
}

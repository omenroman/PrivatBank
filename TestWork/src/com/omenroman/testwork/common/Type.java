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
public enum Type {
    
    POSTE_RESTANTE("до востребования"), 
    RUSH("срочный"), 
    CALCULATED("расчетный"), 
    CUMULATIVE("накопительный"), 
    SAVINGS("сберегательный"), 
    METALLIC("металлический");
    
    private String description;

    private Type(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public static Type getType(String name){
        for(Type type: values()){
            if(type.getDescription().equals(name)){
                return type;
            }
        }
        return null;
    }
    
}

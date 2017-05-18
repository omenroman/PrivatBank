package com.omenroman;

import com.omenroman.set.Set;

import java.util.Iterator;

/**
 * Created by roman on 16.05.17.
 */
public class Main {
    Set set;
    public Main() {
        set = new Set();
        addSomeValue();
        soutSet();
    }
    private void addSomeValue(){
        for (int i = 0; i < 10; i++) {
            set.add(i+"");
        }
    }
    private void soutSet(){
        Iterator it = set.iterator();
        while (it.hasNext() ){
            System.out.println(it.next());
        }
    }
    public static void main(String[] args) {
        new Main();
    }
}

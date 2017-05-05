package com.omenroman.orchestra.instrument;

/**
 * Created by админ on 05.05.2017.
 */
public class Stringed implements MusicalInstrument {
    @Override
    public String name() {
        return "Stringed";
    }

    @Override
    public void play(String composition) {
        System.out.println("Plays the composition of "+composition+" using stringed");
    }
}

package com.omenroman.orchestra.instrument;

/**
 * Created by админ on 05.05.2017.
 */
public class Spiritual implements MusicalInstrument {
    @Override
    public String name() {
        return "Spiritual";
    }

    @Override
    public void play(String composition) {
        System.out.println("Plays the composition of "+composition+" using spiritual");
    }
}

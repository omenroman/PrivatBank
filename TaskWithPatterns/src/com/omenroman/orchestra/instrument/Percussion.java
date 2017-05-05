package com.omenroman.orchestra.instrument;

import com.omenroman.orchestra.instrument.MusicalInstrument;

/**
 * Created by админ on 05.05.2017.
 */
public class Percussion implements MusicalInstrument {
    @Override
    public String name() {
        return "Percussion";
    }

    @Override
    public void play(String composition) {
        System.out.println("Plays the composition of "+composition+" using percussion");
    }
}

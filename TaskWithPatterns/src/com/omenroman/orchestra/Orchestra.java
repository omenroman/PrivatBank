package com.omenroman.orchestra;

import com.omenroman.orchestra.instrument.MusicalInstrument;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by админ on 05.05.2017.
 */
public class Orchestra {
    private List<MusicalInstrument> instruments = new ArrayList<>();

    public void addInstrument(MusicalInstrument instrument){
        instruments.add(instrument);
    }
    public void playCompositions(String name){
        for (MusicalInstrument inst:instruments) {
            inst.play(name);
        }
    }
    public String getNameInstrumens(){
        String name="Instruments: ";
        for (MusicalInstrument inst:instruments) {
            name+=inst.name()+", ";
        }
        return name;
    }

}

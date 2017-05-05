package com.omenroman.orchestra;

import com.omenroman.orchestra.instrument.MusicalInstrument;

/**
 * Created by админ on 05.05.2017.
 */
public class Stringed extends BaseBuilder{
    @Override
    public void buildOchestra() {
        orchestra.addInstrument((MusicalInstrument) new Stringed());
        orchestra.addInstrument((MusicalInstrument) new Stringed());
        orchestra.addInstrument((MusicalInstrument) new Stringed());
        orchestra.addInstrument((MusicalInstrument) new Stringed());
    }
}

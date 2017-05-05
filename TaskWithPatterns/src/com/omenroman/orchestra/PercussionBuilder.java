package com.omenroman.orchestra;

import com.omenroman.orchestra.instrument.Percussion;

/**
 * Created by админ on 05.05.2017.
 */
public class PercussionBuilder extends BaseBuilder {
    @Override
    public void buildOchestra() {
        orchestra.addInstrument(new Percussion());
        orchestra.addInstrument(new Percussion());
        orchestra.addInstrument(new Percussion());
    }
}

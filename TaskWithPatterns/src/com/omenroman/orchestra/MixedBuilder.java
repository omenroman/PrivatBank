package com.omenroman.orchestra;

import com.omenroman.orchestra.instrument.*;
import com.omenroman.orchestra.instrument.Stringed;

/**
 * Created by админ on 05.05.2017.
 */
public class MixedBuilder extends BaseBuilder {
    @Override
    public void buildOchestra() {
        orchestra.addInstrument(new Stringed());
        orchestra.addInstrument(new Spiritual());
        orchestra.addInstrument(new Percussion());
    }
}

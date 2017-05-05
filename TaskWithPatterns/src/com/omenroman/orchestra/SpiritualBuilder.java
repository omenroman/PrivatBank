package com.omenroman.orchestra;

import com.omenroman.orchestra.instrument.Spiritual;

/**
 * Created by админ on 05.05.2017.
 */
public class SpiritualBuilder extends BaseBuilder {
    @Override
    public void buildOchestra() {
        orchestra.addInstrument(new Spiritual());
        orchestra.addInstrument(new Spiritual());
        orchestra.addInstrument(new Spiritual());
        orchestra.addInstrument(new Spiritual());
    }
}

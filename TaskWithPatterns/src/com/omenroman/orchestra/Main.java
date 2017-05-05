package com.omenroman.orchestra;

import com.omenroman.orchestra.instrument.Percussion;

/**
 * Created by админ on 05.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        BaseBuilder mixed = new MixedBuilder();
        mixed.createNewOrchestra();
        mixed.buildOchestra();
        mixed.play("Symphony No. 1");
        System.out.println(mixed.getOrchestraInstuments());
        System.out.println();
        BaseBuilder builder = new PercussionBuilder();
        builder.createNewOrchestra();
        builder.buildOchestra();
        builder.play("Symphony No. 2");
        System.out.println(mixed.getOrchestraInstuments());
    }
}

package com.omenroman.orchestra;

/**
 * Created by админ on 05.05.2017.
 */
public abstract class BaseBuilder {
    protected Orchestra orchestra;

    public Orchestra getOrchestra() {
        return orchestra;
    }
    public String getOrchestraInstuments(){
       return orchestra.getNameInstrumens();
    }
    public void createNewOrchestra(){
        orchestra = new Orchestra();
    }
    public void play(String name){
        orchestra.playCompositions(name);
    }
    public abstract void buildOchestra();
}

package com.victorsashnev.tema08.stategy;

public class AgressiveStrategy implements Strategy {
    public void hit(Entity e){
        e.applyDamage(50);
    }
}

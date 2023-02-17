package com.victorsashnev.tema08.stategy;

public class Entity {
    private int x;
    private int y;

    private int energy;

    private Strategy strategy;

    public Entity(){
        this(0,0);
    }
   /* public Entity(Strategy strategy){
        this(0,0,strategy);
    }*/

    public Entity(int x ,int y){
        x=0;
        y=0;
        energy=100;
        this.strategy= strategy;
    }

    public void attack(Entity e){
        strategy.hit(e);
    }
    public void applyDamage(int damage){
        energy = energy -damage;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "x=" + x +
                ", y=" + y +
                ", energy=" + energy +
                ", strategy=" + strategy +
                '}';
    }
}

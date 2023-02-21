package com.victorsashnev.tema08.Calculator;

public class Calculator {
    private enum State{
        OFF,INIT,OP1,OP2,RES,
    }
    private double op1;
    private double op2;
    private State state;
    private StringBuilder buffer;
    public Calculator(){
        op1 = 0;
        op2 = 0;
        state = State.OFF;
        buffer = new StringBuilder();
    }
    public void addSymbol(char c){
        switch(state){
            case RES:
                buffer.append(c);
                break;
        }
    }

    public void addDigit(char c){
        switch(state){
            case INIT:
            case OP1:
            case OP2:
                buffer.append(c);
                break;
        }

    }



    public double add(){
        return op1 + op2;
    }


}

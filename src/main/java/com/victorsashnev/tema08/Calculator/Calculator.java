package com.victorsashnev.tema08.Calculator;

public class Calculator {
    private enum State{
        OFF,INIT,OP1,OP1_DECIMAL,BEGIN_OP2,OP2,OP2_DECIMAL,ERROR
    }
    private double op1;
    private double op2;
    private char operator;
    private State state;
    private StringBuilder buffer;
    public Calculator(){
        op1 = 0;
        op2 = 0;
        operator = ' ';
        state = State.OFF;
        buffer = new StringBuilder();
    }
    private String getDisplay() {
        if (buffer.length() > 0){
            return buffer.toString();
            //CORRECT LINE
    }else if(buffer.length()<0){
            return "0";
        }else{
            return "";
        }
    }
    public String addExpresion(String expr){
        for(int i = 0; i < expr.length();i++){
            addSymbol(expr.charAt(i));
        }
        addSymbol('=');
        return buffer.toString();
    }

    private void off(){
        state = State.OFF;
        buffer.setLength(0);
    }

    public String addSymbol(char c){
        if (c == 'c' && state != State.OFF){
           reset();
            return getDisplay();
        } else if (c == 'f') {
            off();
            return getDisplay();
        }
        switch(state){
            case OFF:
                if (c == 'o'){
                    state = State.INIT;
                }
                break;
            case INIT:
                if(Character.isDigit(c)){
                    buffer.append(c);
                    state = State.OP1;
                }else if(c == '.'){
                    buffer.append("0.").append(".");
                    state = State.OP1_DECIMAL;
                }
                break;
            case OP1:
                if(Character.isDigit(c)){
                    buffer.append(c);
                }else if(isOperator(c)){
                    parseOp1(c);
                }else if(c == '.'){
                    buffer.append("0").append(".");
                    state = State.OP1_DECIMAL;
                } else if (isReset(c)) {
                    reset();
                }
                break;
            case OP1_DECIMAL:
                if(Character.isDigit(c)){
                    buffer.append(c);
                } else if (isOperator(c)) {
                    parseOp1(c);
                } else if (isReset(c)) {
                    reset();
                } else{
                    error();
                }
                break;
            case BEGIN_OP2:
                buffer.setLength(0);
                if(Character.isDigit(c)){
                    buffer.append(c);
                    state = State.OP2;
                } else if (c == '.') {
                    buffer.append("0.").append(".");
                    state = State.OP2_DECIMAL;
                } else if (isReset(c)) {
                    reset();
                }else{
                    error();
                }
                break;
            case OP2:
                if(Character.isDigit(c)){
                    buffer.append(c);
                }else if(isOperator(c)){
                    parseOperation();
                    state = State.BEGIN_OP2;
                    operator = c;
                }else if(c == '.'){
                    buffer.append("0").append(".");
                    state = State.OP2_DECIMAL;
                }else if(c == '='){
                    parseOperation();
                    state = State.OP1;
                }else if(isReset(c)){
                    reset();
                }
                    break;
            case OP2_DECIMAL:
                if (Character.isDigit(c)) {
                    buffer.append(c);
                }else if (isOperator(c)){
                    parseOperation();
                    state = State.OP1_DECIMAL;
                    operator = c;
                }else if(isReset(c)){
                    reset();
                }else {
                    error();
                }
                break;
            case ERROR:
                if(isReset(c)){
                    reset();
                }
                break;
        }
        return buffer.toString();
    }

    private void reset(){
        buffer.setLength(0);
        state = State.INIT;
    }

    private void parseOperation(){
        op2 = Double.parseDouble(buffer.toString());
        switch (operator){
            case '+':
                op1 = op1 +op2;
                buffer.append(op1);
                break;
            case'-':
                op1 = op1 - op2;
                buffer.append(op1);
                break;
            case'*':
                op1 = op1 * op2;
                buffer.append(op1);
                break;
            case'/':
                if(op2 == 0){
                    state = State.ERROR;
                    return;
                }
                op1 = op1 / op2;
                buffer.append(op1);
                break;
            case'%':
                op1 = op1 % op2;
                buffer.append(op1);
                break;
        }

    }
    private void error(){
        buffer.setLength(0);
        buffer.append("error");
        state = State.ERROR;
    }

    private boolean isReset(char c){
        return c == 'c';
    }
    private void parseOp1(char op){
        op1 = Double.parseDouble(buffer.toString());
        operator = op;
        buffer.setLength(0);
        state = State.BEGIN_OP2;
    }

    private boolean isOperator(char c){
        final String OPERATORS ="+-/*%";
        return OPERATORS.contains(String.valueOf(c));
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

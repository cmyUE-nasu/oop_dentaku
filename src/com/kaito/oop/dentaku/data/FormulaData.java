package com.kaito.oop.dentaku.data;

public class FormulaData {
    public static final int ADDITION    = 1;    //加算
    public static final int SUBTRACTION = -1;   //減算
    public static final int MULTIPLY    = 2;    //乗算
    public static final int DIVISION    = -2;   //除算
    public static final int EQUAL       = 0;    //結果

    private int value;
    private int calculationSymbol;

    public int getValue(){
        return this.value;
    }
    public void setValue(int value){
        this.value = value;
    }

    public int getCalculationSymbol(){
        return this.calculationSymbol;
    }
    public void setCalculationSymbol(int calculationSymbol){
        if (calculationSymbol >= -2 && calculationSymbol <= 2) {
            this.calculationSymbol = calculationSymbol;
        } else {
            throw new IllegalArgumentException("不正な値の代入");
        }
    }

    public FormulaData(int value, int calculationSymbol){
        this.value = value;
        this.calculationSymbol = calculationSymbol;
    }

    @Override
    public String toString(){
        switch (calculationSymbol){
            case ADDITION:
                return this.value + " + ";
            case SUBTRACTION:
                return this.value + " - ";
            case MULTIPLY:
                return this.value + " × ";
            case DIVISION:
                return  this.value + " ÷ ";
            case EQUAL:
                return  this.value + " = ";
            default:
                throw new IllegalArgumentException("未定義の計算記号");
        }
    }
}

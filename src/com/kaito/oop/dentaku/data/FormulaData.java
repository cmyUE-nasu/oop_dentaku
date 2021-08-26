package com.kaito.oop.dentaku.data;

public class FormulaData {
    public static final int ADDITION    = 1;    //加算
    public static final int SUBTRACTION = -1;   //減算
    public static final int MULTIPLY    = 2;    //乗算
    public static final int DIVISION    = -2;   //除算
    public static final int EQUAL       = 0;    //結果

    private double value;
    private final int calculationSymbol;

    public double getValue(){
        return this.value;
    }
    public void setValue(double value){
        this.value = value;
    }

    public int getCalculationSymbol(){
        return this.calculationSymbol;
    }

    public FormulaData(double value, int calculationSymbol){
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

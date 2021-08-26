package com.kaito.oop.dentaku;

import com.kaito.oop.dentaku.data.FormulaData;

import java.util.List;

public class Calculator {
    public static double calculate(List<FormulaData> formula){
        int count = 0;

        // TODO デバッグ用なので消す
        System.out.println(formula.toString());

        //乗算と除算を計算する
        while (formula.get(count).getCalculationSymbol() != FormulaData.EQUAL){
            switch (formula.get(count).getCalculationSymbol()){
                //加算か減算の時はスキップ
                case FormulaData.ADDITION:
                case FormulaData.SUBTRACTION:
                    count++;
                    break;

                //乗算の時は計算して次のリストに答えを格納
                case FormulaData.MULTIPLY:
                    formula.get(count + 1).setValue(
                            formula.get(count).getValue() * formula.get(count + 1).getValue()
                    );
                    formula.remove(count);
                    break;

                //除算の時は計算して次のリストに答えを格納
                case FormulaData.DIVISION:
                    formula.get(count + 1).setValue(
                            formula.get(count).getValue() / formula.get(count + 1).getValue()
                    );
                    formula.remove(count);
                    break;
            }
        }

        // TODO デバッグ用なので消す
        System.out.println(formula);

        // もう一度式の最初から計算する為にカウンターをリセット
        count = 0;

        // 今度は加算と減算を計算します。
        while (formula.get(count).getCalculationSymbol() != FormulaData.EQUAL){
            switch (formula.get(count).getCalculationSymbol()){
                //加算の時は計算して次のリストに答えを格納
                case FormulaData.ADDITION:
                    formula.get(count + 1).setValue(
                            formula.get(count).getValue() + formula.get(count + 1).getValue()
                    );
                    formula.remove(count);
                    break;

                //減算の時は計算して次のリストに答えを格納
                case FormulaData.SUBTRACTION:
                    formula.get(count + 1).setValue(
                            formula.get(count).getValue() - formula.get(count + 1).getValue()
                    );
                    formula.remove(count);
                    break;
            }
        }

        // TODO デバッグ用なので消す
        System.out.println(formula);

        return formula.get(0).getValue();
    }
}

package com.kaito.oop.dentaku;

import com.kaito.oop.dentaku.data.FormulaData;
import com.kaito.oop.dentaku.ui.CalculatorButtonPanel;
import com.kaito.oop.dentaku.ui.CalculatorTextPanel;
import com.kaito.oop.dentaku.ui.CalculatorButtonListener;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class CalculatorFrame extends JFrame {
    private boolean answerFlag = false; //=ボタンが押されて答えを表示した後かどうかのFlag。クリアボタンとか押されて答えの表示が消えるとfalseになる
    private double lastAnswer = 0.0;    //最後に計算した式の答え

    private final CalculatorTextPanel outputText = new CalculatorTextPanel();       //式を表示するPanel
    private final CalculatorButtonPanel inputButtons = new CalculatorButtonPanel(); //入力用のボタンを表示するPanel
    private final List<FormulaData> formula = new LinkedList<>();        //式を格納するリスト

    public CalculatorFrame(){
        inputButtons.setOnClickListener(new CalculatorButtonListener() {
            @Override
            public void onValueUpdate() {
                //=を押されて答えを計算した後に数字を入力すると、表示をすべて初期化する
                if (answerFlag) onClickClear();
                //入力パネルで入力された数字を出力パネルに適用する
                outputText.setInputValue(inputButtons.getValue());
            }

            @Override
            public void onClickAddition() {
                // 答えを計算した後に＋を押すと、答えにそのまま計算する。
                FormulaData newFormulaData;
                if (answerFlag) {
                    onClickClear();
                    newFormulaData = new FormulaData(lastAnswer, FormulaData.ADDITION);
                } else {
                    newFormulaData = new FormulaData(inputButtons.getValue(), FormulaData.ADDITION);
                }
                formula.add(newFormulaData);
                outputText.addFormula(newFormulaData);
            }

            @Override
            public void onClickSubtraction() {
                // 答えを計算した後に-を押すと、答えにそのまま計算する。
                FormulaData newFormulaData;
                if (answerFlag) {
                    onClickClear();
                    newFormulaData = new FormulaData(lastAnswer, FormulaData.SUBTRACTION);
                } else {
                    newFormulaData = new FormulaData(inputButtons.getValue(), FormulaData.SUBTRACTION);
                }
                formula.add(newFormulaData);
                outputText.addFormula(newFormulaData);
            }

            @Override
            public void onClickMultiply() {
                // 答えを計算した後に*を押すと、答えにそのまま計算する。
                FormulaData newFormulaData;
                if (answerFlag) {
                    onClickClear();
                    newFormulaData = new FormulaData(lastAnswer, FormulaData.MULTIPLY);
                } else {
                    newFormulaData = new FormulaData(inputButtons.getValue(), FormulaData.MULTIPLY);
                }
                formula.add(newFormulaData);
                outputText.addFormula(newFormulaData);
            }

            @Override
            public void onClickDivision() {
                // 答えを計算した後に/を押すと、答えにそのまま計算する。
                FormulaData newFormulaData;
                if (answerFlag) {
                    onClickClear();
                    newFormulaData = new FormulaData(lastAnswer, FormulaData.DIVISION);
                } else {
                    newFormulaData = new FormulaData(inputButtons.getValue(), FormulaData.DIVISION);
                }
                formula.add(newFormulaData);
                outputText.addFormula(newFormulaData);
            }

            @Override
            public void onClickEqual() {
                //式のリストに=を追加する。
                FormulaData newFormulaData = new FormulaData(inputButtons.getValue(), FormulaData.EQUAL);
                formula.add(newFormulaData);
                outputText.addFormula(newFormulaData);
                //答えを計算
                lastAnswer = Calculator.calculate(formula);
                //計算した答えを表示
                outputText.setAnswer(lastAnswer);
                answerFlag = true;
            }

            @Override
            public void onClickClear(){
                //表示を初期化
                formula.clear();
                outputText.clear();
                answerFlag = false;
            }
        });

        this.add(outputText, BorderLayout.CENTER);
        this.add(inputButtons, BorderLayout.SOUTH);
        outputText.clear();
    }
}

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
    private boolean answerFlag = false;

    private final CalculatorTextPanel outputText = new CalculatorTextPanel();
    private final CalculatorButtonPanel inputButtons = new CalculatorButtonPanel();
    private final List<FormulaData> formula = new LinkedList<FormulaData>();

    public CalculatorFrame(){
        inputButtons.setOnClickListener(new CalculatorButtonListener() {
            @Override
            public void onValueUpdate() {
                if (answerFlag) onClickClear();
                outputText.setInputValue(inputButtons.getValue());
                System.out.println(inputButtons.getValue());
                System.out.println(formula.toString());
            }

            @Override
            public void onClickAddition() {
                FormulaData newFormulaData = new FormulaData(inputButtons.getValue(), FormulaData.ADDITION);
                formula.add(newFormulaData);
                outputText.addFormula(newFormulaData);
                System.out.println("+");
                System.out.println(formula.toString());
            }

            @Override
            public void onClickSubtraction() {
                FormulaData newFormulaData = new FormulaData(inputButtons.getValue(), FormulaData.SUBTRACTION);
                formula.add(newFormulaData);
                outputText.addFormula(newFormulaData);
                System.out.println("-");
                System.out.println(formula.toString());
            }

            @Override
            public void onClickMultiply() {
                FormulaData newFormulaData = new FormulaData(inputButtons.getValue(), FormulaData.MULTIPLY);
                formula.add(newFormulaData);
                outputText.addFormula(newFormulaData);
                System.out.println("*");
                System.out.println(formula.toString());
            }

            @Override
            public void onClickDivision() {
                FormulaData newFormulaData = new FormulaData(inputButtons.getValue(), FormulaData.DIVISION);
                formula.add(newFormulaData);
                outputText.addFormula(newFormulaData);
                System.out.println("/");
                System.out.println(formula.toString());
            }

            @Override
            public void onClickEqual() {
                FormulaData newFormulaData = new FormulaData(inputButtons.getValue(), FormulaData.EQUAL);
                formula.add(newFormulaData);
                outputText.addFormula(newFormulaData);
                outputText.setAnswer(Calculator.calculate(formula));
                answerFlag = true;
                System.out.println("=");
                System.out.println(formula.toString());
            }

            @Override
            public void onClickClear(){
                formula.clear();
                outputText.clear();
                answerFlag = false;
                System.out.println("clear");
                System.out.println(formula.toString());
            }
        });

        this.add(outputText, BorderLayout.CENTER);
        this.add(inputButtons, BorderLayout.SOUTH);
        outputText.clear();
    }
}

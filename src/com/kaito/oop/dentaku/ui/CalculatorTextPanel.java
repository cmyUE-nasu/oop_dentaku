package com.kaito.oop.dentaku.ui;

import com.kaito.oop.dentaku.data.FormulaData;

import javax.swing.*;
import java.awt.*;

/*
計算機の出力部を担当するクラス
JPanelを継承している
現在入力中の値と、入力された式を表示する
表示するだけで計算などは関知しない
渡された表示を表示するだけのクラス
 */
public class CalculatorTextPanel extends JPanel{
    private final JLabel inputValueLabel;
    private final JLabel formulaLabel;

    //表示中の計算式を変更するメソッド
    public void setInputValue(int input){
        inputValueLabel.setText("式を入力: " + input);
    }

    public void setInputValue(){
        inputValueLabel.setText("式を入力: ");
    }

    public void setMessage(String text){
        inputValueLabel.setText(text);
    }

    //計算式に式を追加するメソッド
    public void addFormula(FormulaData newFormula){
        formulaLabel.setText(formulaLabel.getText() + newFormula.toString());
        setInputValue();
    }

    //表示を初期状態に戻すメソッド
    public void clear(){
        inputValueLabel.setText("式を入力： ");
        formulaLabel.setText("式: ");
    }

    public void setAnswer(double answer){
        formulaLabel.setText(formulaLabel.getText() + answer);
        inputValueLabel.setText("答え: " + answer);
    }

    //コンストラクタ
    public CalculatorTextPanel() {
        //JLabelのインスタンス化
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        formulaLabel = new JLabel();
        inputValueLabel = new JLabel();
        //初期値の設定
        clear();
        //レイアウトの設定
        formulaLabel.setFont(new Font("Meiryo UI Bold", Font.PLAIN, 18));
        inputValueLabel.setFont(new Font("Meiryo UI Bold", Font.PLAIN, 24));
        layout.putConstraint(SpringLayout.NORTH, formulaLabel, 10, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, formulaLabel, 10, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, formulaLabel, -10, SpringLayout.EAST, this);

        layout.putConstraint(SpringLayout.NORTH, inputValueLabel, 10, SpringLayout.SOUTH, formulaLabel);
        layout.putConstraint(SpringLayout.WEST, inputValueLabel, 10, SpringLayout.WEST, formulaLabel);
        layout.putConstraint(SpringLayout.EAST, inputValueLabel, -10, SpringLayout.EAST, this);
        //JLabelをPanelに追加
        this.add(formulaLabel);
        this.add(inputValueLabel);
    }
}

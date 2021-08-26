package com.kaito.oop.dentaku.ui;

import javax.swing.*;
import java.awt.*;

/*
計算機の入力用のボタンを表示を行う関数
rootに入力用のボタンを格納したJPanelを持ち、
それを呼び出し側に使ってもらう。
数値の入力、一時的な保持に関する責任を持っている。
数値が入力されたら、内部の値を更新し、Listenerを通して通知する。
あくまで入力と一時的な数値の保持の責任しか持っていないので、
計算処理と全体の値の保持は呼び出し側が責任を持つ。
つまり、四則演算ボタンを押した後は押す前の値は忘れるので呼び出し側が保存しておくこと、
計算処理も呼び出し側が行うべきである。
 */
public class CalculatorButtonPanel extends JPanel{
    private CalculatorButtonListener listener;  //ボタンが操作された時のイベントリスナ
    private int inputValue;                  //入力データを保持する変数

    //このコンストラクタで、各種変数の初期化、各ボタンのインスタンス化及びリスナーの設定をしている。
    public CalculatorButtonPanel(){
        resetInputValue();      //入力の初期値の設定
        this.setLayout(new GridLayout(4, 4));   //4*4のGridLayoutをrootにセット

        setOnClickListener(new CalculatorButtonListener() {
            @Override
            public void onValueUpdate() {}
            @Override
            public void onClickAddition() {}
            @Override
            public void onClickSubtraction() {}
            @Override
            public void onClickMultiply() {}
            @Override
            public void onClickDivision() {}
            @Override
            public void onClickEqual() {}
            @Override
            public void onClickClear(){}
        }); //ぬるぽ対策で空のListenerをセットしている

        Font buttonFont = new Font("Meiryo UI Bold", Font.PLAIN, 40);   //ボタン用のフォント
        //各数字ボタン
        JButton button0 = new JButton("0");
        button0.setFont(buttonFont);
        button0.addActionListener(e -> {
            addValue(0);
            listener.onValueUpdate();
        });

        JButton button1 = new JButton("1");
        button1.setFont(buttonFont);
        button1.addActionListener(e -> {
            addValue(1);
            listener.onValueUpdate();
        });

        JButton button2 = new JButton("2");
        button2.setFont(buttonFont);
        button2.addActionListener(e -> {
            addValue(2);
            listener.onValueUpdate();
        });

        JButton button3 = new JButton("3");
        button3.setFont(buttonFont);
        button3.addActionListener(e -> {
            addValue(3);
            listener.onValueUpdate();
        });

        JButton button4 = new JButton("4");
        button4.setFont(buttonFont);
        button4.addActionListener(e -> {
            addValue(4);
            listener.onValueUpdate();
        });

        JButton button5 = new JButton("5");
        button5.setFont(buttonFont);
        button5.addActionListener(e -> {
            addValue(5);
            listener.onValueUpdate();
        });

        JButton button6 = new JButton("6");
        button6.setFont(buttonFont);
        button6.addActionListener(e -> {
            addValue(6);
            listener.onValueUpdate();
        });

        JButton button7 = new JButton("7");
        button7.setFont(buttonFont);
        button7.addActionListener(e -> {
            addValue(7);
            listener.onValueUpdate();
        });

        JButton button8 = new JButton("8");
        button8.setFont(buttonFont);
        button8.addActionListener(e -> {
            addValue(8);
            listener.onValueUpdate();
        });

        JButton button9 = new JButton("9");
        button9.setFont(buttonFont);
        button9.addActionListener(e -> {
            addValue(9);
            listener.onValueUpdate();
        });

        //加算ボタン
        JButton buttonAddition = new JButton("+");
        buttonAddition.setFont(buttonFont);
        buttonAddition.addActionListener(e -> {
            listener.onClickAddition();
            resetInputValue();
        });

        //減算ボタン
        JButton buttonSubtraction = new JButton("-");
        buttonSubtraction.setFont(buttonFont);
        buttonSubtraction.addActionListener(e -> {
            listener.onClickSubtraction();
            resetInputValue();
        });

        //乗算ボタン
        JButton buttonMultiply = new JButton("×");
        buttonMultiply.setFont(buttonFont);
        buttonMultiply.addActionListener(e -> {
            listener.onClickMultiply();
            resetInputValue();
        });

        //除算ボタン
        JButton buttonDivision = new JButton("÷");
        buttonDivision.setFont(buttonFont);
        buttonDivision.addActionListener(e -> {
            listener.onClickDivision();
            resetInputValue();
        });

        //計算ボタン
        JButton buttonCalculation = new JButton("=");
        buttonCalculation.setFont(buttonFont);
        buttonCalculation.addActionListener(e -> {
            listener.onClickEqual();
            resetInputValue();
        });

        //クリアボタン
        JButton buttonClear = new JButton("C");
        buttonClear.setFont(buttonFont);
        buttonClear.addActionListener(e -> {
            resetInputValue();
            listener.onClickClear();
        });

        this.add(button7);
        this.add(button8);
        this.add(button9);
        this.add(buttonDivision);
        this.add(button4);
        this.add(button5);
        this.add(button6);
        this.add(buttonMultiply);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(buttonSubtraction);
        this.add(button0);
        this.add(buttonClear);
        this.add(buttonCalculation);
        this.add(buttonAddition);
    }

    public int getValue() {
        return this.inputValue;
    }

    //呼び出し側にListenerをセットしてもらうためのメソッド
    public void setOnClickListener(CalculatorButtonListener listener) {
        this.listener = listener;
    }
    //内部変数を0にするメソッド
    private void resetInputValue(){
        this.inputValue = 0;
    }

    //ボタンが押された時に内部変数の値を更新するメソッド
    private void addValue(int input){
        if (this.inputValue == 0) {
            this.inputValue = input;
        } else {
            this.inputValue = this.inputValue * 10 + input;
        }
    }
}

package com.kaito.oop.dentaku.ui;

public interface CalculatorButtonListener {
    void onValueUpdate();       //数字ボタンが押されて入力データが更新された時の挙動
    void onClickAddition();     //加算ボタンが押された時の挙動
    void onClickSubtraction();  //減算ボタンが押された時の挙動
    void onClickMultiply();     //乗算ボタンが押された時の挙動
    void onClickDivision();     //減算ボタンが押された時の挙動
    void onClickEqual();        //イコールボタンが押された時の挙動
    void onClickClear();
}

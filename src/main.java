import com.kaito.oop.dentaku.CalculatorFrame;

import javax.swing.*;

public class main {

    public static void main(String[] args) {
        CalculatorFrame frame = new CalculatorFrame();

        frame.setBounds(100, 100, 600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

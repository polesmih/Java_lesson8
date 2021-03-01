package lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BottomFrame {
    private final JPanel panel;

    static double x = 0, y = 0, result = 0;
    static int operator = 0;


    public BottomFrame(JTextField inputField) {
        panel = new JPanel();
        panel.setLayout(new GridLayout(6, 3));

        DigitButtonListener buttonListener = new DigitButtonListener(inputField);
        for (int i = 0; i <= 9; i++) {
            JButton btn = new JButton(String.valueOf(i));
            btn.addActionListener(buttonListener);
            panel.add(btn);
        }

        // my solution start
        JButton plus = new JButton("+");
        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == plus) {
                    x = Double.parseDouble(inputField.getText());
                    operator = 1;
                }
                inputField.setText("");
            }
        });
        panel.add(plus);

        JButton div = new JButton("/");
        div.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == div) {
                    x = Double.parseDouble(inputField.getText());
                    operator = 2;
                }
                inputField.setText("");
            }
        });
        panel.add(div);

        JButton mult = new JButton("*");
        mult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == mult) {
                    x = Double.parseDouble(inputField.getText());
                    operator = 3;
                }
                inputField.setText("");
            }
        });
        panel.add(mult);

        JButton minus = new JButton("-");
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == minus) {
                    x = Double.parseDouble(inputField.getText());
                    operator = 4;
                }
                inputField.setText("");
            }
        });
        panel.add(minus);

        JButton dot = new JButton(".");
        dot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == dot)
                    inputField.setText(inputField.getText().concat("."));
            }
        });
        panel.add(dot);

        JButton sqrt = new JButton("SQRT");
        sqrt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == sqrt) {
                    x = Double.parseDouble(inputField.getText());
                    operator = 5;
                }
            }
        });
        panel.add(sqrt);

        JButton res = new JButton("=");
        res.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == res) {
                    y = Double.parseDouble(inputField.getText());

                    switch (operator) {
                        case 1:
                            result = x + y;
                            break;
                        case 2:
                            result = x / y;
                            break;
                        case 3:
                            result = x * y;
                            break;
                        case 4:
                            result = x - y;
                            break;
                        case 5:
                            result = Math.sqrt(x);
                            break;
                        default:
                            result = 0;
                    }
                    inputField.setText("" + result);
                }
            }
        });
        panel.add(res);
        // my solution finish

        JButton clear = new JButton("C");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputField.setText("");
            }
        });
        panel.add(clear);
    }

    public JPanel getPanel() {
        return panel;
    }
}


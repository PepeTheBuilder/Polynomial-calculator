package View;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.*;

public class GUI extends JFrame{

    private JButton sumButton;
    private JButton subButton;
    private JButton multiplyButton;
    private JButton divButton;
    private JButton integrateButton;
    private JButton derivateButton;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JPanel JPanel;
    private JPanel panel;
    private JTextField resultTextField;
    private JTextField polynome1TextField;
    private JTextField polynome2TextField;
    private JTextField restDivTextField;

    public GUI() {
        this.setSize(500,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(JPanel);
        this.setVisible(true);
    }
    public void addSumListener(ActionListener listener ) {
        // System.out.println("addSumListener");
        sumButton.addActionListener(listener);
    }
    public void addSubListener(ActionListener listener ) {
       // System.out.println("addSubListener");
        subButton.addActionListener(listener);
    }
    public void addDivListener(ActionListener listener ) {
        // System.out.println("addDivListener");
        divButton.addActionListener(listener);
    }
    public void addMutiListener(ActionListener listener ) {
        // System.out.println("addMutiListener");
        multiplyButton.addActionListener(listener);
    }
    public void addintegrateListener(ActionListener listener ) {
       // System.out.println("addintegrateListener");
        integrateButton.addActionListener(listener);
    }
    public void addDerivateListener(ActionListener listener ) {
       // System.out.println("addDerivateListener");
        derivateButton.addActionListener(listener);
    }

    public String getResultTextField() {
        return resultTextField.getText();
    }

    public String getPolynome1TextField() {
        return polynome1TextField.getText();
    }

    public String getPolynome2TextField() {
        return polynome2TextField.getText();
    }

    public String getRestDivTextField() {
        return restDivTextField.getText();
    }

    public void setResultTextField(String text) {
        this.resultTextField.setText(text);
    }

    public void setRestDivTextField(String text) {
        this.restDivTextField.setText(text);
    }


}

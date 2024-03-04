package Controller;

import Model.DivisionResult;
import View.GUI;
import org.example.Polinome;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Controller {
    private boolean division=false;
    private GUI gui ;
    private String input1;
    private String input2;
    private String result;
    private String cat;
    private Polinome polinome1;
    private Polinome polinome2;
    private DivisionResult divisionResult;

    public Controller(){
        gui= new GUI();
        gui.addSumListener(new addSumListener());
        gui.addSubListener(new addSubListener());
        gui.addMutiListener(new addMultiListener());
        gui.addDivListener(new addDivListener());
        gui.addintegrateListener(new addintegrateListener());
        gui.addDerivateListener(new addDerivateListener());
        gui.setVisible(true);
        resetPoli();
    }

    // input be like: x^5+3x^3 -2.6  x^2+x-3
    public Polinome readPolinome(String text) {
        Polinome polinome = new Polinome();
        HashMap<Integer, Float> result = new HashMap<Integer, Float>();

        text = text.replaceAll("\\s", "");

        if (text.isEmpty() || text.isBlank()) {
            return polinome;
        }

        Pattern pattern = Pattern.compile("(?:([+-]?)(\\d*(?:\\.\\d+)?)?)(x(?:\\^(\\d+))?)?");
        // the classic--"(?:([+-]?)(\\d+(?:\\.\\d+)?)(x\\^(\\d+))?|(x\\^(\\d+)))"

        ///(?:([+-]?)(\d*(?:\.\d+)?)?)(x(?:\^(\d+))?)?

        // (?:([+-]?)(\d+(?:\.\d+)?)(x\^(\d+))?|(x\^(\d+))|((\d+)?x\^?)) -- ala care ii pus doar ca group7 si8 in plus pt cazu 4x sau x sau x^2 NU II GATA
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String debuggTEXT= matcher.group(1)+matcher.group(2)+matcher.group(3);
            String signStr = matcher.group(1);
            String coefficientStr;
            String expStr;
            int exp;
            float sign;
            float coefficient;
            if(debuggTEXT.equals("null") || debuggTEXT.isBlank()) {
                break;
            }
            if (matcher.group(2) != null &&!matcher.group(2).isBlank()) {
                coefficientStr = matcher.group(2);
            } else {
                coefficientStr = "1";
            }

            if (matcher.group(4) != null&&!matcher.group(4).isBlank()) {
                expStr = matcher.group(4);
            } else {
                expStr = "1";
            }

            if (signStr != null && signStr.equals("-")) {
                sign = -1;
            } else {
                sign = 1;
            }

            if (coefficientStr != null && !coefficientStr.isBlank()) {
                coefficient = Float.parseFloat(coefficientStr);
            } else {
                coefficient = 1;
            }
            if (expStr != null && !expStr.isBlank()) {
                exp = Integer.parseInt(expStr);
            } else {
                exp = 0;
            }
            if(!debuggTEXT.contains("x")||debuggTEXT.isBlank())exp = 0;

            result.put(exp, sign * coefficient);
        }

        polinome.setPolinome(result);
        return polinome;
    }

    public void setPolinoame(){
            resetPoli();
            polinome1= readPolinome(gui.getPolynome1TextField());
            polinome2= readPolinome(gui.getPolynome2TextField());
    }

    public void resetPoli(){
        polinome1=new Polinome();
        polinome2=new Polinome();
    }

    public class addSumListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO: STUFF
            setPolinoame();
            Polinome result = new Polinome(polinome1.addPolynomials(polinome2));
            gui.setResultTextField(result.valueToString());
            gui.setRestDivTextField("");
        }
    }
    public class addSubListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO: STUFF
            setPolinoame();
            Polinome result = new Polinome(polinome1.subPolynomials(polinome2));
            gui.setResultTextField(result.valueToString());
            gui.setRestDivTextField("");

        }
    }
    public class addDivListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO: STUFF
            setPolinoame();
            DivisionResult result;
            result = polinome1.division(polinome2);
            if(!result.getDivZero()) {
                Polinome rest = new Polinome(result.getRest());
                Polinome cat = new Polinome(result.getCat());
                gui.setResultTextField(cat.valueToString());
                gui.setRestDivTextField(rest.valueToString());
            }
            else{
                gui.setResultTextField("");
                gui.setRestDivTextField("");
                JOptionPane.showMessageDialog(null, "Division with 0!");
            }

        }
    }
    public class addMultiListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO: STUFF
            setPolinoame();
            Polinome result = new Polinome(polinome1.multiplyPolynomials(polinome2));
            gui.setResultTextField(result.valueToString());
            gui.setRestDivTextField("");
        }
    }
    public class addintegrateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO: STUFF
            setPolinoame();
            polinome1.integrate();
            Polinome result = new Polinome(polinome1.integrate());
            gui.setResultTextField(result.valueToString());
            gui.setRestDivTextField("");
        }
    }
    public class addDerivateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO: STUFF
            setPolinoame();
            Polinome result = new Polinome(polinome1.derivate());
            gui.setResultTextField(result.valueToString());
            gui.setRestDivTextField("");
        }
    }
}

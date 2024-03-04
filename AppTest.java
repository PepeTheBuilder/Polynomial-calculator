package org.example;

import static org.junit.Assert.assertTrue;

import Controller.Controller;
import Model.DivisionResult;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static junit.framework.TestCase.assertEquals;
//import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Rigorous Test :-)
     */
    Controller controller=new Controller();
    Polinome poli1;
    Polinome poli2;
    Polinome result;
    HashMap<Integer, Float> rezolvare;
    Polinome rest;

    DivisionResult divisionResult;

    public boolean addTest(String polinome1,String polinome2, String resultString){
        poli1=controller.readPolinome(polinome1);
        poli2=controller.readPolinome(polinome2);
        result=controller.readPolinome(resultString);
        rezolvare=poli1.addPolynomials(poli2);
        return rezolvare.equals(result.getPolinome());
    }

    public boolean subTest(String polinome1,String polinome2, String resultString){
    poli1=controller.readPolinome(polinome1);
    poli2=controller.readPolinome(polinome2);
    result=controller.readPolinome(resultString);
    rezolvare=poli1.subPolynomials(poli2);
        return rezolvare.equals(result.getPolinome());
    }

    public boolean multiTest(String polinome1,String polinome2, String resultString){
        poli1=controller.readPolinome(polinome1);
        poli2=controller.readPolinome(polinome2);
        result=controller.readPolinome(resultString);
        rezolvare=poli1.multiplyPolynomials(poli2);
        return rezolvare.equals(result.getPolinome());
    }

    public boolean DivTest(String polinome1,String polinome2, String resultString,String restString){
        poli1=controller.readPolinome(polinome1);
        poli2=controller.readPolinome(polinome2);
        result=controller.readPolinome(resultString);
        rest=controller.readPolinome(restString);
        divisionResult=poli1.division(poli2);
        Polinome dummy1= new Polinome(divisionResult.getCat());
        Polinome dummy2 = new Polinome(divisionResult.getRest());
        return dummy1.valueToString().equals(result.valueToString())&& dummy2.valueToString().equals(rest.valueToString());
    }

    public boolean IntegrTest(String polinome1, String resultString){
        poli1=controller.readPolinome(polinome1);
        result=controller.readPolinome(resultString);
        rezolvare=poli1.integrate();
        return rezolvare.equals(result.getPolinome());
    }

    public boolean DeriTest(String polinome1, String resultString){
        poli1=controller.readPolinome(polinome1);
        result=controller.readPolinome(resultString);
        rezolvare=poli1.derivate();
        return rezolvare.equals(result.getPolinome());
    }

    @Test
    public void Tester(){
        if(addTest("x^2","x","x^2+x")
                && addTest("x^3+2x+3","x+2","x^3 + 3 x + 5")
                && addTest("x^4-2x^3+2x^2-x-1","-x^3+4x+5","x^4 - 3 x^3 + 2 x^2 + 3 x + 4")){

            System.out.println("Adder -- ok");
        }
        else System.out.println("Adder -- okn't");

        if(subTest("x^2","x","x^2-x")
                && subTest("x^4-2x^3+2x^2-x-1","-x^3+4x+5","-6 - 5 x + 2 x^2 - x^3 + x^4")
                && subTest("x^3+2x+3","x+2","x^3 + x + 1")){

            System.out.println("Sub -- ok");
        }
        else System.out.println("Sub -- okn't");

        if(multiTest("x^2","x","x^3")
                && multiTest("x^3+2x+3","x+2","6 + 7 x + 2 x^2 + 2 x^3 + x^4")
                && multiTest("x^4-2x^3+2x^2-x-1","-x^3+4x+5","-5 - 9 x + 6 x^2 - x^3 - 2 x^4 + 2 x^5 + 2 x^6 - x^7") ){

            System.out.println("Multi -- ok");
        }
        else System.out.println("Multi -- okn't");

        if(DivTest("x^2-4","x-2","x+2","")
            && DivTest("x^2-3","x-2","x+2","1")
        ){

            System.out.println("Div -- ok");
        }
        else System.out.println("Div -- okn't");

        if(IntegrTest("x","0.50x^2") && IntegrTest("2x+4","x^2+4x") && IntegrTest("0","")){

            System.out.println("Integration -- ok");
        }
        else System.out.println("Integration -- okn't");

        if(DeriTest("x","1") && DeriTest("2x+4","2") && DeriTest("x^2","2x")){

            System.out.println("Derivation -- ok");
        }
        else System.out.println("Derivation -- okn't");


    }

}

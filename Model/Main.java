package Model;

import Controller.Controller;

public class Main {
    public static void main(String[] args) {
           Controller controller = new Controller();
/*
        HashMap<Integer, Float> poly1 = new HashMap<Integer, Float>();
        poly1.put(2, 2.0f);
        poly1.put(1, 3.0f);
        poly1.put(0, 1.0f);

        HashMap<Integer, Float> poly2 = new HashMap<Integer, Float>();
        poly2.put(3, 4.0f);
        poly2.put(2, 1.0f);
        poly2.put(1, -1.0f);
        poly2.put(0, 2.0f);
        Polinome polinome = new Polinome(poly1);
        Polinome polinome2 = new Polinome(poly2);


        Polinome result = new Polinome(polinome.addPolynomials(polinome.getPolinome(), polinome2.getPolinome()));
        System.out.println("Result of addition: " + result.valueToString());

        result.setPolinome( polinome.subPolynomials(poly1, poly2));
        System.out.println("Result of subtraction: " + result.valueToString());
*/

/*        HashMap<Integer, Float> poly1 = new HashMap<>();
        poly1.put(2, 3.0f);
        poly1.put(1, 4.0f);
        poly1.put(0, 5.0f);
        HashMap<Integer, Float> poly2 = new HashMap<>();

        Polinome polinome = new Polinome();


        HashMap<Integer, Float> result = polinome.derivate(poly1);
        boolean ceva = polinome.isZeroPolynomial(poly2);
        System.out.println(result);
        System.out.println(ceva);*/

/*
            HashMap<Integer, Float> dividend = new HashMap<>();
            HashMap<Integer, Float> divisor = new HashMap<>();
            dividend.put(4, 3.0f);
            dividend.put(3, 3.0f);
            dividend.put(2, -3.0f);
            dividend.put(1, 1.0f);
            dividend.put(0, 2.0f);

            divisor.put(2, 3.0f);
            divisor.put(1, 1.0f);
            divisor.put(0, 1.0f);
            Polinome polinome = new Polinome(dividend);
            Polinome poli2 =new Polinome(divisor);
            HashMap<Integer, Float> quotient = new HashMap<>();
            HashMap<Integer, Float> remainder = new HashMap<>();
            boolean divZero= true;
*/
/*            System.out.println("("+polinome.valueToString()+")-("+poli2.valueToString()+")");


            remainder=polinome.subPolynomials(poli2);
            String test = polinome.valueToString(remainder);

            System.out.println("res:"+test);*//*

            DivisionResult div = polinome.division( poli2);
            quotient = div.getCat();
            remainder = div.getRest();
            divZero = div.getDivZero();

            String test = polinome.valueToString(remainder);
            String test2 = polinome.valueToString(quotient);
            System.out.println(test);
            System.out.println(test2);
            System.out.println(divZero);
*/


/*
          String text = "3.5x^5-x^3+x+3.0";
            Polinome test = controller.readPolinome(text);
            System.out.println(test.valueToString());
            System.out.println(test.getPolinome());
*/

    }


}

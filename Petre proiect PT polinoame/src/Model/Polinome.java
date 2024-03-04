package Model;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;


public class Polinome {

    private HashMap<Integer, Float> polynomial;

    public Polinome(){
        polynomial= new HashMap<Integer, Float>();
    }
    public Polinome(HashMap<Integer, Float> poli){
        polynomial= poli;
    }

    public DivisionResult division (@NotNull HashMap<Integer, Float> poly1, @NotNull HashMap<Integer, Float> poly2){
        DivisionResult res = new DivisionResult();
        HashMap<Integer, Float> quotient= new HashMap<Integer, Float>();
        HashMap<Integer, Float> remainder= poly1;

        if(isZeroPolynomial(poly2)){
            res.setDivZero(true);
            return res;
        }
        else res.setDivZero(false);

        int degreeRest=getDegree(remainder);
        int degreePoly2=getDegree(poly2);
        while((!isZeroPolynomial(remainder)) && degreeRest>=degreePoly2){
            int degreeDiff = degreeRest - degreePoly2;
            float coefficient = remainder.get(degreeRest) / poly2.get(degreePoly2);
            quotient.put(degreeDiff,coefficient);
            HashMap<Integer, Float> aux= new HashMap<Integer, Float>();
            aux.put(degreeDiff,coefficient);
            aux =  multiplyPolynomials(poly2,aux);
            remainder= subPolynomials(remainder, aux);
            degreeRest= getDegree(remainder);
            aux.put(degreeDiff,0.0f);

        }
        res.setRest(remainder);
        res.setCat(quotient);
        return res;
    }
    public DivisionResult division(HashMap<Integer, Float> poly2){
        return division(this.polynomial,poly2);
    }
    public DivisionResult division(Polinome poly2){
        return division(this.polynomial,poly2.getPolinome());
    }

    public int getDegree(HashMap<Integer, Float> poly1){
        int maxPower=0;
        for (Map.Entry<Integer, Float> entry : poly1.entrySet()) {
            Integer power = entry.getKey();
            Float coefficent = entry.getValue();
            if (maxPower < power && coefficent != 0.000f) {
                maxPower = power;
            }
        }
        return maxPower;
    }
    public int getDegree(Polinome poli1){
        return getDegree(poli1.getPolinome());
    }

    public @NotNull HashMap<Integer, Float> derivate(@NotNull HashMap<Integer, Float> poly1){
        HashMap<Integer, Float> result =  new HashMap<Integer, Float>();
        if(isZeroPolynomial(poly1))
        {
            return poly1;
        }
        poly1.forEach((degree,coefficient)-> {
            if(coefficient!=0&& degree!=0){   // if degree==0 the it is not .put in result
                    result.put(degree-1,coefficient*(degree));
            }
        });

        return result;
    }
    public @NotNull HashMap<Integer, Float> derivate(){
        return derivate(this.getPolinome());
    }

    public @NotNull HashMap<Integer, Float> integrate(@NotNull HashMap<Integer, Float> poly1){
        HashMap<Integer, Float> result =  new HashMap<Integer, Float>();
        if(isZeroPolynomial(poly1)){
            return result;
        }
        poly1.forEach((degree,coefficient)-> {
            if(coefficient!=0){
                result.put(degree+1,coefficient/(degree+1));
            }
        });
        return result;
    }
    public @NotNull HashMap<Integer, Float> integrate(){
        return integrate(this.getPolinome());
    }

    public @NotNull HashMap<Integer, Float> multiplyPolynomials( HashMap<Integer, Float> poly1,  HashMap<Integer, Float> poly2){
        HashMap<Integer, Float> result = new HashMap<Integer, Float>();

        for (Map.Entry<Integer, Float> term1 : poly1.entrySet()){
            for (Map.Entry<Integer, Float> term2 : poly2.entrySet()) {
                int degree = term2.getKey()+term1.getKey();
                float coefficient = term1.getValue()*term2.getValue();
                    if (result.containsKey(degree)) {
                    coefficient += result.get(degree);
                    }
                result.put(degree, coefficient);
            }
        }
        return result;
    }
    public @NotNull HashMap<Integer, Float> multiplyPolynomials(HashMap<Integer, Float> poly2){
        return multiplyPolynomials(this.polynomial,poly2);
    }
    public @NotNull HashMap<Integer, Float> multiplyPolynomials(Polinome poly2){
        return multiplyPolynomials(this.polynomial,poly2.getPolinome());
    }

    public @NotNull HashMap<Integer, Float> addPolynomials( HashMap<Integer, Float> poly1,  HashMap<Integer, Float> poly2) {
        HashMap<Integer, Float> result = poly1;
        // Iterate over the second polynomial and add its terms to the result
        for (Map.Entry<Integer, Float> term2 : poly2.entrySet()) {
            int degree = term2.getKey();
            float coefficient = (float) 0.0;
                coefficient+= term2.getValue();
            if (result.containsKey(degree)) {
                coefficient += result.get(degree);
            }
                result.put(degree, coefficient);
        }
        return result;
    }
    public @NotNull HashMap<Integer, Float> addPolynomials(HashMap<Integer, Float> poly2){
        return addPolynomials(this.polynomial,poly2);
    }
    public @NotNull HashMap<Integer, Float> addPolynomials(Polinome poly2){
        return addPolynomials(this.polynomial,poly2.getPolinome());
    }

    public HashMap<Integer, Float> negate (HashMap<Integer, Float> poly1){
        HashMap<Integer, Float> result= new  HashMap<Integer, Float>();
        for (Map.Entry<Integer, Float> term1 : poly1.entrySet()) {
            int degree = term1.getKey();
            float coefficient = -term1.getValue();
            result.put(degree,coefficient);
        }

        return result;
    }

    public @NotNull HashMap<Integer, Float> subPolynomials(HashMap<Integer, Float> poly1, HashMap<Integer, Float> poly2) {
        HashMap<Integer, Float> result ;
        HashMap<Integer, Float> negate ;
        negate = negate(poly2);
        //System.out.println("Negate: "+negate);
        result=addPolynomials(poly1, negate);
       // System.out.println("Res add subP(): "+result);

/*        for (Map.Entry<Integer, Float> term1 : poly1.entrySet()) {
            int degree = term1.getKey();
            float coefficient = term1.getValue();

            if (poly2.containsKey(degree)) {
                coefficient -= poly2.get(degree);
            }
            result.put(degree, coefficient);
        }

        for (Map.Entry<Integer, Float> term2 : poly2.entrySet()) {
            int degree = term2.getKey();
            float coefficient = -term2.getValue();

            if (!result.containsKey(degree)) {
                result.put(degree, coefficient);
            } else {
                float existingCoefficient = result.get(degree);
                result.put(degree, existingCoefficient + coefficient);
            }
        }*/

        return result;
    }
    public @NotNull HashMap<Integer, Float> subPolynomials(HashMap<Integer, Float> poly2){
        return subPolynomials(this.polynomial,poly2);
    }
    public @NotNull HashMap<Integer, Float> subPolynomials(Polinome poly2){
        return subPolynomials(this.polynomial,poly2.getPolinome());
    }

    public boolean isZeroPolynomial(HashMap<Integer, Float> polynomial) {
        if (polynomial == null) {
            return true;
        }

        for (float coefficient : polynomial.values()) {
            if (coefficient != 0) {
                return false;
            }
        }

        return true;
    }
    public boolean isZeroPolynomial(){
        return isZeroPolynomial(this.polynomial);
    }

    public String valueToString(HashMap<Integer, Float> value){
        if(isZeroPolynomial(value)==true)
        {
            return "";
        }
        String str= value.toString();
        String bun="";
        boolean plus= false;
        str = str.substring(1, str.length() - 1); // remove curly braces
        String[] substrings = str.split(", "); // split using comma and space

/*        if (plus)
            bun = String.format("%.2f", coeff) + "x^" + power + " +" + bun;
        else
            bun = String.format("%.2f", coeff) + "x^" + power + " " + bun;*/

        for (String substring : substrings) {
            String[] parts = substring.split("="); // split at =   // comment2: DE CE CREZI CA AM '='??? HA? is eu prost?
            int power = Integer.parseInt(parts[0]);
            float coeff = Float.parseFloat(parts[1]);
            String aux= "";
            if(coeff!=0.0f) {
                if (power != 0) {
                    if(coeff!=1.0f) {
                        aux = String.format("%.2f", coeff);
                    }
                    else{
                        aux="";
                    }
                    if(power==1) {
                        aux= aux+"x";
                    }
                    else {
                        aux= aux+"x^"+ power;
                    }
                    if (plus)
                        bun = aux+" +" + bun;
                    else
                        bun = aux+ " " + bun;
                    if (coeff > 0.0f) plus = true;
                    else plus = false;
                } else if (coeff < 0.0f) bun = String.format("%.2f", coeff) + bun;
                else bun = "+"+String.format("%.2f", coeff)+bun;
            }
        }

        return bun;
    }
    public String valueToString(){
        return valueToString(this.polynomial);
    }

    public void reset(){
        polynomial.clear();
        this.polynomial= new HashMap<Integer, Float>();
    }

    public void setPolinome(HashMap polinome) {
        this.polynomial = polinome;
    }

    public HashMap getPolinome() {
        return polynomial;
    }

}

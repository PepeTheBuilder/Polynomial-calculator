import java.util.HashMap;

public class DivisionResult {
    private boolean divZero=false;
    private HashMap<Integer, Float> rest;
    private HashMap<Integer, Float> cat;

    DivisionResult(){
        divZero=false;
        rest= new HashMap<Integer, Float>();
        cat= new HashMap<Integer, Float>();
    }

    public HashMap<Integer, Float> getRest() {
        return rest;
    }

    public void setRest(HashMap<Integer, Float> rest) {
        this.rest = rest;
    }

    public HashMap<Integer, Float> getCat() {
        return cat;
    }

    public void setCat(HashMap<Integer, Float> cat) {
        this.cat = cat;
    }

    public boolean getDivZero() {
        return divZero;
    }

    public void setDivZero(boolean divZero) {
        this.divZero = divZero;
    }

    public void reset(){
        divZero=false;
        rest= new HashMap<Integer, Float>();
        cat= new HashMap<Integer, Float>();
    }
}
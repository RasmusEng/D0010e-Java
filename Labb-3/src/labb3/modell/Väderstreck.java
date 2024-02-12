package labb3.modell;

public enum Väderstreck {
    NORR(0), ÖSTER(1), SÖDER(2), VÄSTER(3);
    private int index;
    Väderstreck(int i){
        index = i;
    }
    public int index(){
        return index;
    }
}

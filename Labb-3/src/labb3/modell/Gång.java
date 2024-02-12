package labb3.modell;

public class Gång {
    private Rum från;
    private Rum till;
    private Väderstreck riktningFrån;
    private Väderstreck riktningTill;

    // Konstruktorn
    public Gång(Rum från, Väderstreck riktningUtUrFrån, Rum till,
                Väderstreck riktningInITill) {
        this.från = från;
        this.riktningFrån = riktningUtUrFrån;
        this.till = till;
        this.riktningTill = riktningInITill;
    }

    // Getters
    public Rum getRumFrån(){
        return this.från;
    }
    public Rum getRumTill(){
        return this.till;
    }
    public Väderstreck getRiktningFrån(){
        return this.riktningFrån;
    }
    public Väderstreck getRiktningTill(){
        return this.riktningTill;
    }
}

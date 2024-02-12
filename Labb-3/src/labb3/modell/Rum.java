package labb3.modell;

import labb3.verktyg.Punkt;

import java.awt.Color;
import java.lang.reflect.Array;
import java.util.ArrayList;

@SuppressWarnings("NonAsciiCharacters")
public class Rum {

	// TODO: Lägg till tillståndsvariabler.
	private Punkt punkt;
	private Color golvfärg;
	private int bredd;
	private int höjd;
	private Gång[] gångs = new Gång[Väderstreck.values().length]; // Kollar hur många enum element finns

	public Rum(Color golvfärg, int bredd, int höjd, int övX, int övY) {
		punkt = new Punkt(övX, övY);
		this.golvfärg = golvfärg;
		this.bredd = bredd;
		this.höjd = höjd;
	}

	// Getters
	public Punkt getPunkt(){
		return this.punkt;
	}
	public Color getColor(){
		return this.golvfärg;
	}
	public int getBredd(){
		return this.bredd;
	}
	public int getHöjd(){
		return this.höjd;
	}
	// Kollar om det finns ett element i gång som stämmer överens med de givna väderstrecket
	public boolean finnsUtgångÅt(Väderstreck väderstreck){
		return gångs[väderstreck.index()] != null;
	}
	// Returnerar elementet om det finns ett gång ut specificrade väderstrecket.
	public Gång gångenÅt(Väderstreck väderstreck){
		if(gångs[väderstreck.index()] != null){
			return gångs[väderstreck.index()];
		}
		throw new IllegalArgumentException();
	}
	// kopplar ihop två rum med en gång.
	public static void kopplaIhop(Rum från, Väderstreck riktningUtUrFrån,
			Rum till, Väderstreck riktningInITill) {
		Gång gång = new Gång(från, riktningUtUrFrån, till, riktningInITill);
		från.gångs[riktningUtUrFrån.index()] = gång;
		till.gångs[riktningInITill.index()] = gång;
	}
}

package labb3.kontroll;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import labb3.modell.Nivå;
import labb3.modell.Väderstreck;

public class Tangentbordslyssnare implements KeyListener {
	private Nivå enNivå;

	public Tangentbordslyssnare(Nivå enNivå) {
		this.enNivå = enNivå;
	}

	@Override
		// Hämtar Knappkoden och flyttar åt specifikt håll.
	public void keyPressed(KeyEvent e) {
		int knapp = e.getKeyCode();
		switch (knapp){
			case 87: // W
				enNivå.hoppaÅt(Väderstreck.NORR);
				break;
			case 65: // A
				enNivå.hoppaÅt(Väderstreck.VÄSTER);
				break;
			case 83: // S
				enNivå.hoppaÅt(Väderstreck.SÖDER);
				break;
			case 68: // D
				enNivå.hoppaÅt(Väderstreck.ÖSTER);
				break;
			default:
				break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// Används inte men måste implementeras eftersom keyReleased finns is
		// gränssnittet KeyListener.
	}
}

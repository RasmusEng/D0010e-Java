package labb3;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import labb3.kontroll.Tangentbordslyssnare;
import labb3.modell.Nivå;
import labb3.vy.Målarduk;

import javax.swing.*;

// TODO: Klassen ska ärva klassen JFrame i standardbibliotekets paket 
// javax.swing och implementera gränssnittet Observer i paketet java.util. 
public class GUI extends JFrame implements Observer{

	private Målarduk målarduk;

	// Skapar ramen "runt" JPanelen
	public GUI(Nivå enNivå) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		enNivå.addObserver(this);
		målarduk = new Målarduk(enNivå);

		målarduk.setPreferredSize(new Dimension(600, 400));
		// TODO: Använd setPreferredSize på målarduk och sätt dess dimensioner
		// så alla rum faktiskt syns. Ett tips är att loopa igenom nivåns alla
		// rum och räkna ut vilken bredd och höjd målarduken måste ha(!)
		// Annars går det också att dra till med en storlek och sen bara
		// använda rum som säkert kan visas på målarduken.

		målarduk.addKeyListener(new Tangentbordslyssnare(enNivå));

		setContentPane(målarduk);
		setVisible(true);
		pack();
	}

	// Metoden update ska vara den i gränssnittet Observer. Lägg därför
	// till @Override på raden innan metodhuvudet. (Klassen måste sen importera
	// java.util.Observer.)
	@Override
	public void update(Observable o, Object arg) {
		// Detta anrop triggar ett anrop till paintComponent i Målarduk.
		this.målarduk.repaint();
	}
}

package labb3.vy;

import labb3.GlobalaKonstanter;
import labb3.modell.Nivå;
import labb3.modell.Rum;
import labb3.modell.Väderstreck;
import labb3.verktyg.Grafik;
import labb3.verktyg.Punkt;
import labb3.modell.Gång;

import javax.swing.*;
import java.awt.*;

import static labb3.GlobalaKonstanter.*;

import static labb3.verktyg.Grafik.drawThickLine;
import static labb3.verktyg.Grafik.fillCircle;

@SuppressWarnings("NonAsciiCharacters")
public class Målarduk extends JPanel{
    private final Nivå enNivå;

    public Målarduk(Nivå enNivå) {
        this.enNivå = enNivå;

        //Sätter bakgrundsfärgen på this till MARKFÄRG.
        this.setBackground(MARKFÄRG);
        this.setFocusable(true);
    }

    // Är den funktion som använder sig av de andra hjälpfunktioner för att rita alla rum, gångar mellan rum
    // och användercirkeln
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Rum R: enNivå.roomNum()) {
            ritaRum(g, R);
        }

        ritaMarkörFörVarAnvändarenÄr(g);
    }

    // Rita rummen och gångar
    private void ritaRum(Graphics g, Rum ettRum) {
        g.setColor(ettRum.getColor());
        g.fillRect(ettRum.getPunkt().x(), ettRum.getPunkt().y(), ettRum.getBredd(), ettRum.getHöjd());
        g.setColor(VÄGGFÄRG);
        g.fillRect(ettRum.getPunkt().x(), ettRum.getPunkt().y(), ettRum.getBredd(), VÄGGTJOCKLEK);
        g.fillRect(ettRum.getPunkt().x(), ettRum.getPunkt().y()+ettRum.getHöjd()-VÄGGTJOCKLEK, ettRum.getBredd(), VÄGGTJOCKLEK);
        g.fillRect(ettRum.getPunkt().x(), ettRum.getPunkt().y(), VÄGGTJOCKLEK, ettRum.getHöjd());
        g.fillRect(ettRum.getPunkt().x()+ettRum.getBredd()-VÄGGTJOCKLEK, ettRum.getPunkt().y(), VÄGGTJOCKLEK, ettRum.getHöjd());
        ritaGångarFrånRum(g, ettRum);
    }

    // Ritar samtliga gångar mellan baspunkten och pivotpunkten
    private void ritaGångarFrånRum(Graphics g, Rum ettRum) {
        for (Väderstreck utgångar: Väderstreck.values()) {
            if(ettRum.finnsUtgångÅt(utgångar)){
                drawThickLine(g, baspunkt(ettRum, utgångar), pivotpunkt(ettRum, utgångar), VÄGGTJOCKLEK, GÅNGFÄRG);
                fillCircle(g, pivotpunkt(ettRum, utgångar), HALV_VÄGGTJOCKLEK, GÅNGFÄRG );
                ritaGång(g, ettRum.gångenÅt(utgångar));
            }
        }
    }

    // Räknar ut baspunkten i förhållande till väderstrecket
    private Punkt baspunkt(Rum ettRum, Väderstreck enRiktning) {
        int direction = enRiktning.index();
        switch (direction){
            case 0:
                return new Punkt(ettRum.getPunkt().x() + ettRum.getBredd()/2, ettRum.getPunkt().y() + VÄGGTJOCKLEK);
            case 1:
                return new Punkt(ettRum.getPunkt().x() + ettRum.getBredd() - VÄGGTJOCKLEK, ettRum.getPunkt().y() + ettRum.getHöjd()/2);
            case 2:
                return new Punkt(ettRum.getPunkt().x() + ettRum.getBredd()/2, ettRum.getPunkt().y() + ettRum.getHöjd() - VÄGGTJOCKLEK);
            case 3:
                return new Punkt(ettRum.getPunkt().x() + VÄGGTJOCKLEK, ettRum.getPunkt().y() + ettRum.getHöjd()/2);
        }
        return null;
    }

    // Räknar ut pivotpunkten i förhållande till väderstrecket
    private Punkt pivotpunkt(Rum ettRum, Väderstreck enRiktning) {
        int direction = enRiktning.index();
        switch (direction){
            case 0:
                return new Punkt(ettRum.getPunkt().x() + ettRum.getBredd()/2, ettRum.getPunkt().y() - HALV_VÄGGTJOCKLEK);
            case 1:
                return new Punkt(ettRum.getPunkt().x() + ettRum.getBredd() + HALV_VÄGGTJOCKLEK, ettRum.getPunkt().y() + ettRum.getHöjd()/2);
            case 2:
                return new Punkt(ettRum.getPunkt().x() + ettRum.getBredd()/2, ettRum.getPunkt().y() + ettRum.getHöjd() + HALV_VÄGGTJOCKLEK);
            case 3:
                return new Punkt(ettRum.getPunkt().x() - HALV_VÄGGTJOCKLEK, ettRum.getPunkt().y() + ettRum.getHöjd()/2);
        }
        return null;
    }

    // Ritar gången mellan pivotpunkten
    private void ritaGång(Graphics g, Gång enGång) {
        drawThickLine(g, pivotpunkt(enGång.getRumFrån(), enGång.getRiktningFrån()), pivotpunkt(enGång.getRumTill(), enGång.getRiktningTill()), VÄGGTJOCKLEK, GÅNGFÄRG);
    }

    // Ritar användaren i centrum av varje rum
    private void ritaMarkörFörVarAnvändarenÄr(Graphics g) {
        fillCircle(g, new Punkt(enNivå.curRoom().getPunkt().x() + enNivå.curRoom().getBredd()/2, this.enNivå.curRoom().getPunkt().y() + this.enNivå.curRoom().getHöjd()/2), ANVÄNDARRADIE, ANVÄNDARFÄRG);
    }
}

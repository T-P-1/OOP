package Aufgabe02;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Klasse, die ein Wuerfelexperiment simuliert.
 * mnmbmnbj
 * kjlkjlkjlkjlkjkljkfojj
 * @author Sabine Lorius und Thomas Pause
 */

public class Wuerfelexperiment {

    private int anzahlVersuche;
    private Wuerfel wuerfel1;
    private Wuerfel wuerfel2;
    private Wuerfel wuerfel3;

    /**
     * Erstellt ein neues Wuerfelexperiment.
     *
     * @param anzahlVersuche int
     */
    public Wuerfelexperiment(int anzahlVersuche) {
        this.anzahlVersuche = anzahlVersuche;

        wuerfel1 = new Wuerfel(0, 9);
        wuerfel2 = new Wuerfel(0, 9);
        wuerfel3 = new Wuerfel(0, 9);
    }

    /**
     * Startet das Experiment und zaehlt die beiden Ereignisse 2 Gleiche und 3 Gleiche.
     *
     * @return Ergebnisse (Haeufigkeiten und Fehler) als Array
     */
    public double[] start() {
        final double WAHRSCHEINLICHKEIT2 = 0.27;
        final double WAHRSCHEINLICHKEIT3 = 0.01;

        int absoluteHaeufigkeit2 = 0;
        int absoluteHaeufigkeit3 = 0;
        BigDecimal relativeHaeufigkeit2;
        BigDecimal relativeHaeufigkeit3;
        BigDecimal relativerFehler2;
        BigDecimal relativerFehler3;

        for (int i = 0; i < anzahlVersuche; i++) {
            int wurf1 = wuerfel1.wuerfeln();
            int wurf2 = wuerfel2.wuerfeln();
            int wurf3 = wuerfel3.wuerfeln();

            if (wurf1 == wurf2 && wurf2 == wurf3) {
                absoluteHaeufigkeit3++;
                continue;
            }
            if (wurf1 == wurf2 || wurf1 == wurf3 || wurf2 == wurf3) {
                absoluteHaeufigkeit2++;
            }
        }
        //Berechnung relative Haeufigkeit für das Ereignis 2 Gleiche
        relativeHaeufigkeit2 = BigDecimal.valueOf(absoluteHaeufigkeit2)
                .divide(BigDecimal.valueOf(anzahlVersuche), MathContext.UNLIMITED);
        //Berechnung relative Haeufigkeit für das Ereignis 3 Gleiche
        relativeHaeufigkeit3 = BigDecimal.valueOf(absoluteHaeufigkeit3)
                .divide(BigDecimal.valueOf(anzahlVersuche), MathContext.UNLIMITED);
        //Berechnung relativer Fehler für das Ereignis 2 Gleiche
        relativerFehler2 = relativeHaeufigkeit2
                .subtract(BigDecimal.valueOf(WAHRSCHEINLICHKEIT2))
                .divide(BigDecimal.valueOf(WAHRSCHEINLICHKEIT2), MathContext.DECIMAL128)
                .abs();
        //Berechnung relativer Fehler für das Ereignis 3 Gleiche
        relativerFehler3 = relativeHaeufigkeit3
                .subtract(BigDecimal.valueOf(WAHRSCHEINLICHKEIT3))
                .divide(BigDecimal.valueOf(WAHRSCHEINLICHKEIT3), MathContext.DECIMAL128)
                .abs();

        return new double[]{
                relativeHaeufigkeit2.doubleValue(), relativeHaeufigkeit3.doubleValue(),
                relativerFehler2.doubleValue(), relativerFehler3.doubleValue(),
                WAHRSCHEINLICHKEIT2, WAHRSCHEINLICHKEIT3
        };
    }
}
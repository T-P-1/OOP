package Aufgabe02;

import java.util.Scanner;

/**
 * Die Main Methode. Einsprungpunkt des Programms.
 *
 * @author Sabine Lorius und Thomas Pause
 */

public class Main {

    /**
     * Main Methode.
     *
     * @param args .
     */
    public static void main(String[] args) {

        int anzahlWuerfe;
        Wuerfelexperiment wuerfelxperiment;
        double[] ergebnis;
        boolean repeat = true;
        while (repeat) {
            Scanner scanner = new Scanner(System.in);
            anzahlWuerfe = UserInput.sc(scanner);

            wuerfelxperiment = new Wuerfelexperiment(anzahlWuerfe);
            ergebnis = wuerfelxperiment.start();

            System.out.print("\nExperiment beendet.\n" +
                    "Relative Haeufigkeit von 2 gleichen Wuerfen: " +
                    (ergebnis[0] * 100) + " %" +
                    " \nRelative Haeufigkeit von 3 gleichen Wuerfen: " +
                    (ergebnis[1] * 100) + " %" +
                    " \nRelativer Fehler (2 gleiche Wuerfe): " +
                    (ergebnis[2] * 100) + " %" +
                    " \nRelativer Fehler (3 gleiche Wuerfe): " +
                    (ergebnis[3] * 100) + " %" +
                    " \nMathematische Wahrscheinlichkeit (2 gleiche Wuerfe): " +
                    (ergebnis[4] * 100) + " %" +
                    " \nMathematische Wahrscheinlichkeit (3 gleiche Wuerfe): " +
                    (ergebnis[5] * 100) + " %" +
                    " \nFuer einen neuen Versuch bitte das Programm erneut starten!");

            Scanner scan2=new Scanner(System.in);
            System.out.println("\n\nProgramm erneut starten? [j/n]");
            String jaNein = scan2.next();
            repeat = jaNein.equalsIgnoreCase("j");
        }
    }
}
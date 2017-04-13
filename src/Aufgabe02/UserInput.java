package Aufgabe02;

import java.util.Scanner;

/**
 * Klasse, die Benutzereingaben einliest.
 *
 * @author Sabine Lorius und Thomas Pause
 */

public class UserInput {

    /**
     * Fragt alle zur Berechnug benoetigten Eingaben vom Benutzer ab
     * und gibt sie zur Weiterverwendung (in der Main) zurueck.
     *
     * @param scanner Scanner
     * @return Rueckgabewerte
     */
    public static int sc(Scanner scanner) {
        int anzahlWuerfe;

        System.out.println("Initialisiere ein neues Wuerfelexperiment.....\n");
        System.out.println("Waehlen Sie bitte die Anzahl der Wuerfe: \n10,\n1000,\n100000,\n10000000 oder \n1000000000");
        try {
            anzahlWuerfe = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            anzahlWuerfe = 0;

        }
        while (anzahlWuerfe != 10 &&
                anzahlWuerfe != 1000 &&
                anzahlWuerfe != 100000 &&
                anzahlWuerfe != 10000000 &&
                anzahlWuerfe != 1000000000) {
            System.out.println("Falsche Eingabe.");
            System.out.println("Waehlen Sie bitte die Anzahl der Wuerfe: \n10,\n1000,\n100000,\n10000000 oder \n1000000000");

            try {
                anzahlWuerfe = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                anzahlWuerfe = 0;
            }
        }
        System.out.println("Es wird gewuerfelt.....");
        return anzahlWuerfe;
    }

    /**
     * Abfrage, ob das Programm fortgesetzt oder abgebrochen werden soll.
     *
     * @param scPlay Scanner
     * @return boolean
     */
    public static boolean fortfahren(Scanner scPlay) {

        System.out.println("\n\nMÃ¶chten Sie eine neue Berechnung durchfuehren? J oder N:");
        String play;

        try{    play = scPlay.next().toUpperCase();
            if (play.equals("J")){
                return true;
            }
            else {
                System.out.println("Das Programm wird beendet.");
                return false;
            }
        }catch(Exception e){
            System.out.println("Es ist ein unerwarteter Fehler eingetreten.");
        }
        return false;
    }
}
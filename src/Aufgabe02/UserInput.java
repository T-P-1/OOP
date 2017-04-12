package Aufgabe02;

import java.util.Scanner;

/**
 * Klasse, die Benutzereingaben einliest.
 *
 * @author Sabine Lorius und Thomas Pause
 */

public class UserInput {

    /**
     * Fragt alle benoetigten Eingaben vom Benutzer ab
     * und gibt sie zur Weiterverwendung (in der Main) zurueck.
     *
     * @param scanner Scanner
     * @return Rueckgabewerte
     */
    public static int sc(Scanner scanner) {
        int anzahlWuerfe;

        System.out.println("Initialisiere ein neues Wuerfelexperiment.....");
        System.out.println("Waehlen Sie bitte die Anzahl der Wuerfe: \n10,\n1000,\n100000,\n10000000 oder \n1000000000");
        try {
            anzahlWuerfe = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            anzahlWuerfe = 0;
        }
        if (anzahlWuerfe != 10 &&
                anzahlWuerfe != 1000 &&
                anzahlWuerfe != 100000 &&
                anzahlWuerfe != 10000000 &&
                anzahlWuerfe != 1000000000) {
            System.out.println("Falsche Eingabe.");
            System.out.println("Waehlen Sie bitte erneut die Anzahl der Wuerfe: \n10,\n1000,\n100000,\n10000000 oder \n1000000000");
            }

        return anzahlWuerfe;
    }
}
package aufgabe22;

import java.util.List;
import java.util.Scanner;

/**
 * Klasse fuer die Kryptoanalyse.
 *
 * @author Created by Thomas Pause und Sabine Lorius
 */
public class Kryptoanalyse {

    /**
     * Absteigend sortiertes Array der am häufigsten in der deutschen Sprache auftretenden Buchstaben.
     */
    static char[] haeufigkeiten = {'e','n','i','s','r','a','t','h','d','h','u','l','c','g','m','o','b','w','f','k','z','p','v','j','y','x','q'};
    /**
     * Index des o.a. Arrays.
     */
    static int index = 0;

    /**
     * Methode zum Zaehlen der Buchstaben.
     * @param zeichenkette
     * @param buchstabe
     * @return counter
     */
    public static int buchstabenZaehlen(String zeichenkette, char buchstabe) {

        int counter = 0;
        char[] zeichen = zeichenkette.toCharArray();


        for (int i = 0; i < zeichen.length; i++) {
                if (zeichen[i] == buchstabe) counter++;


        }
        return counter;

    }

    /**
     * Methode zur Ermittlung des haeufigsten Buchstabens im chiffrierten Text.
     * @param text
     * @return
     */
    public static int haeufigstesCryptCharErmitteln(List<String> text) {
        char haufigstesChar = 0;
        int times = 0;
        for (String zeile : text) {
            zeile = zeile.toLowerCase();

            for (char c = 'a'; c <= 'z'; c++) {
                int ctimes = buchstabenZaehlen(zeile, c);
                if (ctimes > times) {
                    haufigstesChar = c;
                    times = ctimes;
                }
            }
        }
        System.out.println("\n_______________________________________________\nKryptoanalyse:\nHaufigster Buchstabe ermittelt: " + "\'" + haufigstesChar + "\'");
        return Integer.valueOf(haufigstesChar)-96;

    }

    /**
     * Methode zum Berechnen des Schluessels auf Grundlage des haefigsten Buchstabens im chiffrierten Text.
     * @param text
     * @return cryptKey
     */
    public static int schluesselBerechnen( List<String> text ){

        int cryptKey = 1;
        int cryptC = haeufigstesCryptCharErmitteln(text);

        int[] schluessel = new int[]{1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25};
        int supposedC = Integer.valueOf(haeufigkeiten[index])-96;

        for (int i : schluessel) {
            if (((supposedC) * i) % 26 == cryptC) {
                return i;
            }
        }


        System.out.println("Berechneter Chiffrier-Schluessel nach " + haeufigkeiten[index] +"\"" + ": " + cryptKey + "\n_______________________________________________");
        return cryptKey;
    }

    /**
     * Methode zum Iterieren über die nach der Haufigkeit ihres Auftretens absteigend sortierten Buchstaben.
     * @param text text
     * @return
     */
    public static int skipChar(List<String> text){
        int cryptKey = 1;
        index++;
        if(index<haeufigkeiten.length-1) {

            List<String> skipped = Rotate.rotateLeft(schluesselBerechnen(text), text);

            Scanner scPlay = new Scanner(System.in);
            if (Input.fortfahren(scPlay)) {
                Kryptoanalyse.skipChar(text);
            }

            int newCryptKey = cryptKey;
            return newCryptKey;
        }else{
                System.out.println("Es existiert keine weitere Moeglichkeit den Text zu dechiffrien.");
        }
        return -1;
    }
}
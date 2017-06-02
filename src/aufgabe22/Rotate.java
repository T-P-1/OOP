package aufgabe22;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Klasse fuer Ver- und Entschluesselung und Ermittlung einnes zufaelligen Schluessels.
 *
 * @author Created by Thomas Pause und Sabine Lorius
 */
class Rotate {

    /**
     * Liste mit verschluesseltem Text.
     */
    static List encoded;
    /**
     * Liste mit entschluesseltem Text.
     */
    static List decoded;
    /**
     * zufaellig generierter Schluessel.
     */
    static int keyX;

    /**
     * Methode zum verschluesseln eines Textes.
     * @param shiftDistance
     * @param klartext
     * @return output
     */
    static List<String> rotateRight(int shiftDistance, List<String> klartext) {
        List<String> output = new ArrayList<>();
        System.out.println("\n\n>>>Rechtsrotiert>>>:\n");
        for (String zeile : klartext) {
            char[] zeileToChar = zeile.toCharArray();

            for (int i = 0; i < zeileToChar.length; i++) {

                if ('a' <= Character.toString(zeileToChar[i]).charAt(0) &&
                        Character.toString(zeileToChar[i]).charAt(0) <= 'y') {
                    zeileToChar[i] = (char)((((zeileToChar[i] - 96) * shiftDistance) % 26) + 96);
                } else if ('A' <= Character.toString(zeileToChar[i]).charAt(0) &&
                        Character.toString(zeileToChar[i]).charAt(0) <= 'Y') {
                    zeileToChar[i] = (char)((((zeileToChar[i] - 64) * shiftDistance) % 26) + 64);
                }
            }

            output.add(new String(zeileToChar));
            System.out.println(zeileToChar);
        }
        encoded = output;
        return output;
    }

    /**
     * Methode, die den inversen Schluessel ermittelt.
     * @param shiftDistance
     * @return invers
     */
    static int findInvers(int shiftDistance){
        int invers = 0;
        for(int b = 1; b < 27; b++) {

            if ( ((b * 26) + 1)%shiftDistance == 0) {
                invers = ((b * 26) + 1) / shiftDistance;
                break;
            }

        }
        return invers;
    }

    /**
     * Methode zum Dekodieren eines Textes.
     * @param shiftDistance
     * @param geheimtext
     * @return output
     */
    static List<String> rotateLeft(int shiftDistance, List<String> geheimtext) {
        shiftDistance = findInvers(shiftDistance);

        List<String> output = new ArrayList<>();
        System.out.println("\n\nDer invertierte Schluessel lautet: " + shiftDistance + "\n<<<Linksrotiert<<<:\n");
        for (String zeile : geheimtext) {
            char[] zeileToChar = zeile.toCharArray();

            for (int i = 0; i < zeileToChar.length; i++) {

                if ('a' <= Character.toString(zeileToChar[i]).charAt(0) &&
                        Character.toString(zeileToChar[i]).charAt(0) <= 'y') {
                    zeileToChar[i] = (char)((((zeileToChar[i] - 96) * shiftDistance) % 26) + 96);
                } else if ('A' <= Character.toString(zeileToChar[i]).charAt(0) &&
                        Character.toString(zeileToChar[i]).charAt(0) <= 'Y') {
                    zeileToChar[i] = (char)((((zeileToChar[i] - 64) * shiftDistance) % 26) + 64);
                }
            }
            output.add(new String(zeileToChar));
            System.out.println(zeileToChar);
        }
        decoded = output;
        return output;

    }

    /**
     * Methode, die einen zufaelligen Schluessel generiert.
     * @return keyX
     */
    static int randomize(){
        Random randomKey = new Random();
        System.out.print("\n\n\n***********************************************\nEs wird ein zufaelliger Schluessel ermittelt...");

        keyX = randomKey.nextInt(14)*2+1;
        if(keyX == 13 || keyX == 0){
            randomize();

        }
        System.out.print("\nDer neue Schluessel lautet: " + keyX +"\n***********************************************");
        return keyX;
    }
}

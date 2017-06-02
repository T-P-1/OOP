package aufgabe22;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Klasse, die alle Imports organisiert.
 *
 * @author Created by Thomas Pause und Sabine Lorius
 */
public class Input{
    /**
     * Liest einen Text ein.
     * @param s
     * @return zeilen
     */
    public static List<String> textEinlesen(String s)throws IOException{
        List<String> zeilen = new ArrayList<>();
        File path = new File("Gedicht.txt");
        System.out.println("Lesen aus Datei: " + path);

        //Prueft, ob der Pfad bereits existiert, danach ob es ein (nur) Verzeichnis ist
        //path.exists());
        //path.isDirectory() + "\n\n");


        /////////////////////
        //*Lesen aus Datei*//
        /////////////////////
        System.out.println("Originaltext:\n");

        try (BufferedReader reader = new BufferedReader(new FileReader(path)))
        {
            String zeile = reader.readLine();

            while (zeile != null) {
                zeilen.add(zeile);
                zeile = reader.readLine();
            }
            reader.close();
            for (String z : zeilen) {
                System.out.println(z);
            }
        }catch(IOException io) {
            io.printStackTrace(System.err);
        }finally{
            return zeilen;


        }
    }

    /**
     * Liest den eingegeben Schluessel ein.
     * @param scanner
     * @return schluessel
     */
    static String init(Scanner scanner) {
        String schluessel;

        System.out.println("\n_______________________________________________\n\nGeben Sie den Schluessel ein: ");
        try {
            schluessel = Integer.toString(Integer.parseInt(scanner.nextLine()));
        } catch (NumberFormatException e) {
            schluessel = "0";
        }
        while (!Arrays.asList(1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25)
                .contains(Integer.parseInt(schluessel))) {
            System.out.println("Dieser Schluessel ist nicht zulaessig.");
            System.out.println("Moegliche Schluessel: 1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25");
            System.out.println("Geben Sie den Schluessel ein.");
            try {
                schluessel = Integer.toString(Integer.parseInt(scanner.nextLine()));
            } catch (NumberFormatException e) {
                schluessel = "0";
            }
        }

        return schluessel;
    }

    /**
     * Abfrage, ob das Programm fortgesetzt oder abgebrochen werden soll.
     *
     * @param scPlay
     * @return boolean
     */
    public static boolean fortfahren(Scanner scPlay) {

        System.out.println("\n\nMoechten Sie eine neue Berechnung durchfuehren? \"J\" oder Abbruch mit anderer Eingabe:");
        String play;

        try{    play = scPlay.next().toUpperCase();
            if (play.equals("J")){
                return true;
            }
            else {
                System.out.println("Die Kryptoanalyse wird beendet.");
                return false;
            }
        }catch(Exception e){
            System.out.println("Es ist ein unerwarteter Fehler eingetreten.");
        }
        return false;
    }
}

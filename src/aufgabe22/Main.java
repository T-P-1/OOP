package aufgabe22;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Klasse Main.
 *
 * @author Created by Thomas Pause und Sabine Lorius
 */
public class Main {

    //##########################################################
    // VOR DEM AUSFUEHREN HIER DEN RICHTIGEN PFAD EINSTELLEN !!!
    //##########################################################
    /**
     * Konstante mit Dateipfad.
     */
    private static final String DATEI = "C:\\Users\\Ultrabook\\IdeaProjects\\OOP";

    /**
     * Main-Methode. Einspungspunkt des Programms.
     * @param args
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Rotate r = new Rotate();
        List read = Input.textEinlesen(DATEI);
        String eingabe = Input.init(scanner);

        List<String> encrypted = Rotate.rotateRight(Integer.parseInt(eingabe), read);
        List<String> decrypted = Rotate.rotateLeft(Integer.parseInt(eingabe), encrypted);

        List<String> randomCipher = Rotate.rotateRight(Rotate.randomize(), read);
        List<String> randomDecrypt = Rotate.rotateLeft(Rotate.keyX, randomCipher);

        Output.textAuslesen("GedichtOutput.txt", randomCipher);

        List<String> test = new ArrayList<>();
        test.add("Heitere Einblicke");
        test.add("in die");
        test.add("modulare Arithmetik.");
        List<String> testChiffriert = Rotate.rotateRight(Rotate.randomize(), test);
        List<String> testDechiffriert = Rotate.rotateLeft(Kryptoanalyse.schluesselBerechnen(testChiffriert), testChiffriert);

        List<String> klartext = new ArrayList<>();
        klartext.add("Bennenen von");
        klartext.add("klingonischen");
        klartext.add("Namen");

        List<String> geheimtext = Rotate.rotateRight(Rotate.randomize(), klartext);
        Scanner weiter = new Scanner(System.in);
        if(Input.fortfahren(weiter)){
            Kryptoanalyse.skipChar(geheimtext);
        }

    }
}
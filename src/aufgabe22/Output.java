package aufgabe22;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasse, die die Outputs organisiert.
 *
 * @author Created by Thomas Pause und Sabine Lorius
 */
public class Output {

    /**
     * Methode die einen Text in eine Datei schreibt.
     * @param name
     * @param contents
     */
    public static void textAuslesen(String name, List<String> contents) throws IOException {
        //Legt Referenz auf Pfad/Datei an
        File path = new File(name);
        System.out.println("\n==============================================\nSchreiben in Datei: " + path);
        List<String> zeilen = new ArrayList<>(contents);


        //Prueft, ob der Pfad bereits existiert, danach ob es ein (nur) Verzeichnis ist
        //path.exists());
        //path.isDirectory() + "\n\n");

        ////////////////////////
        //*Schreiben in Datei*//
        ////////////////////////
        OutputStream outStream = new FileOutputStream(path);
        for (String z : zeilen) {
            String contentsToWrite = z + "\n";

            //Erstellt einen neuen Outputstream(für path=hello.txt), der mit outStream referenziert ist

            //.schreibe in Datei(die Bytes, aus dem unter contentsToWrite abgelegten Text); schließe den OutPutSTream
            outStream.write(contentsToWrite.getBytes());

        }
        outStream.close();
    }

}

package ponyhof;

import java.util.ArrayList;
import java.util.List;
/**
 * Klasse Datenbank
 * enthaelt die gegebenen Informationen zu Reiterinnen/Reitern sowie den Pferden des Reiterhofs
 *
 * @author Created by Thomas Pause und Sabine Lorius
 */
class Datenbank {

    private static Pferd anex = new Pferd("Anex", 1);
    private static Pferd nicki = new Pferd("Nicki", 2);
    private static Pferd hurrikan = new Pferd("Hurrican", 2);
    private static Pferd pucki = new Pferd("Pucki", 1);
    private static Pferd tornado = new Pferd("Tornado", 3);
    private static Pferd wittchen = new Pferd("Wittchen", 1);
    private static Pferd sturmwind = new Pferd("Sturmwind", 2);
    private static Pferd zausel = new Pferd("Zausel", 1);
    private static Pferd zickzack = new Pferd("Zickzack", 3);

    private static Reiter anja = new Reiter("Anja", 1, nicki, pucki, wittchen, anex);
    private static Reiter bertram = new Reiter("Bertram", 2);
    private static Reiter christa = new Reiter("Christa", 3, hurrikan);
    private static Reiter doris = new Reiter("Doris", 1, anex, wittchen, pucki);
    private static Reiter emil = new Reiter("Emil", 1, anex, nicki, hurrikan, pucki,
            tornado, wittchen, sturmwind, zausel, zickzack);
    private static Reiter fritz = new Reiter("Fritz", 3, sturmwind, hurrikan);
    private static Reiter gabi = new Reiter("Gabi", 2, hurrikan, anex, tornado, sturmwind);

    /**
     * Statische Methode, die die Listen reiter und pferde fuellt
     *
     * @param reiter Liste der Reiter
     * @param pferde Liste der Pferde
     */
    static void getDaten(List<Reiter> reiter, List<Pferd> pferde) {
        reiter.add(anja);
        reiter.add(bertram);
        reiter.add(christa);
        reiter.add(doris);
        reiter.add(emil);
        reiter.add(fritz);
        reiter.add(gabi);

        pferde.add(anex);
        pferde.add(nicki);
        pferde.add(hurrikan);
        pferde.add(pucki);
        pferde.add(tornado);
        pferde.add(wittchen);
        pferde.add(sturmwind);
        pferde.add(zausel);
        pferde.add(zickzack);
    }

    /**
     * Getter fuer die Output-Liste der Reiter
     *
     * @return output - Liste der Reiter
     */
    static List<Reiter> getReiter() {
        List<Reiter> output = new ArrayList<>();
        output.add(anja);
        output.add(bertram);
        output.add(christa);
        output.add(doris);
        output.add(emil);
        output.add(fritz);
        output.add(gabi);

        return output;
    }
}

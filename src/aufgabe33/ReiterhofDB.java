package aufgabe33;

/**
 * Klasse ReiterhofDB, final
 * enthaelt die gegebenen Informationen zu Reiterinnen/Reitern sowie den Pferden des Reiterhofs
 *
 * @author Created by Thomas Pause und Sabine Lorius
 */
public final class ReiterhofDB {

    /**
     * Die statische Funktion gibt Informationen zu den gegebenen Reitern wie folgt zurueck:
     *
     * Element 1: Name
     * Element 2: Skill-Level ( 1 = Anfaenger // 2 = gut // 3 = sehr gut
     * Element 3: Praeferenz/Wunsch 1
     * Element 4: Praeferenz/Wunsch 2
     * Element 5: Praeferenz/Wunsch 3
     * Element 6: Praeferenz/Wunsch 4
     *
     * @return Daten zu Reitern
     */
    public static String[][] getReiter() {
            return new String[][]{
                    {"Anja", "1", "Nicki", "Pucki", "Wittchen", "Anex"},
                    {"Bertram", "2", "", "", "", ""},
                    {"Doris", "1", "Anex", "Wittchen", "Pucki", "" },
                    {"Christa", "3", "Hurrikan", "", "", ""},
                    {"Emil", "1", "", "", "", ""},
                    {"Fritz", "3", "Sturmwind", "Hurrikan", "", ""},
                    {"Gabi", "2", "Hurrikan", "Anex", "Tornado", "Sturmwind"},
            };
    }

    /**
     * Die statische Funktion gibt Informationen zu den gegebenen Pferden wie folgt zurueck:
     *
     * Element 1: Name
     * Element 2: Skill-Level ( 1 = Anfaenger // 2 = gut // 3 = sehr gut
     *
     * @return Daten zu Pferden
     */
    public static String[][] getPferde() {
            return new String[][]{
                    {"Anex", "1"},
                    {"Nicki", "2"},
                    {"Hurrikan", "2"},
                    {"Pucki", "1"},
                    {"Tornado", "3"},
                    {"Wittchen", "1"},
                    {"Sturmwind", "2"},
                    {"Zausel", "1"},
                    {"Zickzack", "3"},
            };
    }
}
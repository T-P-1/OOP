package ponyhof;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Klasse Reiter
 * enthaelt Methoden fuer die Reiter
 *
 * @author Created by Thomas Pause und Sabine Lorius
 */
class Reiter {

    private String name;
    private int skillLevel;
    private List<Pferd> bevorzugt;
    private Pferd pferd;

    /**
     * Konstruktor Reiter
     *
     * @param name Name des Reiters
     * @param skillLevel Skill-Level des Reiters
     * @param bevorzugt bevorzugte Pferde des Reiters (mit varArgs)
     */
    Reiter(String name, int skillLevel, Pferd... bevorzugt) {
        this.name = name;
        this.skillLevel = skillLevel;
        this.bevorzugt = new ArrayList<>(Arrays.asList(bevorzugt));
    }

    /**
     * Setter fuer Pferde
     *
     * @param pferd Pferd
     */
    void setPferd(Pferd pferd) {
        this.pferd = pferd;
    }

    /**
     * Getter fuer das Skill-Level
     *
     * @return Skill-Level
     */
    int getSkillLevel() {
        return skillLevel;
    }

    /**
     * Getter fuer das Pferd
     *
     * @return Pferd
     */
    Pferd getPferd() {
        return pferd;
    }

    /**
     * Methode zum Ueberpruefen ob das Pferd ein bevorzugtes eines Reiters ist
     *
     * @param pferd Pferd
     * @return boolean
     */
    boolean pferdBevorzugt(Pferd pferd) {
        for (Pferd p : bevorzugt) {
            if (p.equals(pferd)) {
                return true;
            }
        }

        return false;
    }

    /**
     * ToString Methode fuer die Ausgabe der zugeordneten Paarungen
     *
     * @return String
     */
    public String toString() {
        return name + " reitet " + pferd.getName() + ".";
    }
}

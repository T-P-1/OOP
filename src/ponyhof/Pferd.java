package ponyhof;

/**
 * Klasse Pferd
 * enthaelt Methoden fuer die Pferde
 *
 * @author Created by Thomas Pause und Sabine Lorius
 */
class Pferd {

    private String name;
    private int skillLevel;

    /**
     * Konstruktor Pferd
     *
     * @param name Name des Pferdes
     * @param skillLevel Skill-Level des Pferdes
     */
    Pferd(String name, int skillLevel) {
        this.name = name;
        this.skillLevel = skillLevel;
    }

    /**
     * Getter fuer Skill-Level des Pferdes
     *
     * @return Skill-Level
     */
    int getSkillLevel() {
        return skillLevel;
    }

    /**
     * Getter fuer Name des Pferdes
     *
     * @return Name des Pferdes
     */
    String getName() {
        return name;
    }
}

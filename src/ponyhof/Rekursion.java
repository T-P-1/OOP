package ponyhof;

import java.util.List;
/**
 * Klasse Rekursion
 * enthaelt rekursive Methoden fuer die Zuordnung von Reitern und Pferden
 *
 * @author Created by Thomas Pause und Sabine Lorius
 */
class Rekursion {

    /**
     * statische rekursive Methode, die fuer je einen Reiter prueft ob die Wuensche beachtet werden koennen.
     * Anschließend wird entsprechend des Skill-Levels zugeordnet (forced-Methode)
     *
     * @param reiter Liste der Reiter
     * @param pferde Liste der Pferde
     * @param counter Zaehler fuer Fortschritt des Zuordnens
     */
    static void matchPferd(List<Reiter> reiter, List<Pferd> pferde, int counter) {
        if (reiter.isEmpty()) {
            return;
        }
        if (counter == pferde.size()) {
            matchPferdForced(reiter.get(0), pferde, 0);
            counter = 0;
            reiter.remove(0);
        }

        if (!reiter.get(0).pferdBevorzugt(pferde.get(counter))) {
            matchPferd(reiter, pferde, ++counter);

            if (reiter.isEmpty()){
                return;
            }
        } else if (reiter.get(0).pferdBevorzugt(pferde.get(counter)) &&
                (reiter.get(0).getSkillLevel() != pferde.get(counter).getSkillLevel())) {
            matchPferd(reiter, pferde, ++counter);

            if (reiter.isEmpty()) {
                return;
            }
        }

        reiter.get(0).setPferd(pferde.get(counter));
        pferde.remove(counter);
        reiter.remove(0);
        matchPferd(reiter, pferde, 0);
    }

    /**
     * statische rekursive Methode, die entsprechend des Skill-Levels die Zuordnung vornimmt.
     * Forced-Methode, weil die Skill-Zuordnung die uebergeordnete ist
     *
     * @param reiter Liste der Reiter
     * @param pferde Liste der Pferde
     * @param counter Zaehler fuer Fortschritt des Zuordnens
     */
    private static void matchPferdForced(Reiter reiter, List<Pferd> pferde, int counter) {
        if (reiter.getPferd() != null) {
            return;
        }

        if (!(reiter.getSkillLevel() == pferde.get(counter).getSkillLevel())) {
            matchPferdForced(reiter, pferde, ++counter);
        } else {
            reiter.setPferd(pferde.get(counter));
            pferde.remove(counter);
        }
    }
}

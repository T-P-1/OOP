package ponyhof;

import java.util.ArrayList;
import java.util.List;
/**
 * Klasse Main
 * Einsprungpunkt des Programms
 *
 * @author Created by Thomas Pause und Sabine Lorius
 */
public class Main {

    public static void main(String[] args) {

        List<Reiter> reiter = new ArrayList<>();
        List<Pferd> pferde = new ArrayList<>();

        Datenbank.getDaten(reiter, pferde);

        Rekursion.matchPferd(reiter, pferde, 0);
        List<Reiter> ergebnis = Datenbank.getReiter();

        for (Reiter r : ergebnis) {
            System.out.println(r.toString());
        }
    }
}

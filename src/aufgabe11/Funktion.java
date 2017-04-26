package aufgabe11;

/**
 *
 * Funktion f(x), abstract.
 *
 * @author Monika Meiler , Sabine Lorius und Thomas Pause
 */
public abstract class Funktion

{

    /**
     * Berechnen eines Funktionswertes, abstract.
     *
     * @param arg
     *            Argument
     * @return f(arg)
     */
    public abstract double wert(double arg);

    /**
     * Tabellieren von Funktionswerten.
     *
     * @param x0
     *            Startwert
     * @param n
     *            Anzahl der Werte
     * @param h
     *            Schrittweite
     * @return Wertetabelle
     */
    public double[] tabellieren(double x0, int n, double h) {
        // Trivialfall, Tabelle aus nur einem Wert
        if (n < 1)
            n = 1;
        if (n == 1)
            h = 0;
        // Tabelle
        double[] tabelle = new double[n];
        double arg = x0;
        for (int i = 0; i < n; i++) {
            tabelle[i] = wert(arg);
            arg += h;
        }
        return tabelle;
    }

    /**
     * Eingabe von Parametern einer Funktion ueber Konsole, falls welche
     * existieren.
     *
     * @return true, bei erfolgreicher Eingabe
     */
    public boolean konsolenEingabe() {
        return true;
    }

    /**
     * Darstellen einer Funktion.
     *
     * @return Funktion in linear er Schreibweise
     */
    public String toString() {
        return "";
    }
}
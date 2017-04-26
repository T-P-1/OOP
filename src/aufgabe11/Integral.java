package aufgabe11;

/**
 *
 * Integrieren mittels Interpolation.
 *
 * @author Monika Meiler , Sabine Lorius und Thomas Pause
 */
public class Integral
{
    /**
     * Integrieren mittels linearer Interpolation
     * (Trapezregel).
     * @param y Funktionswerte aller Stuetzstellen
     * @param h Abstand zwischen den Stuetzstellen
     * @return Naeherungswert des Integrals
     */
    public double trapez( double[] y, double h)
    {
        int n = y.length -1;

        double ergebnis = ( y[ 0] + y[ n]) / 2;
        for( int i = 1; i < n; i++) ergebnis += y[ i];

        return h * ergebnis;
    }

    /**
     * Integrieren mittels linearer Interpolation
     * (Trapezregel).
     * @param fkt Funktion
     * @param a untere Integrationsgrenze //Anfangswert
     * @param b obere Integrationsgrenze // Endwert
     * @param s Anzahl der Stuetzstellen
     * @return Naeherungswert des Integrals
     */ // h = Abstand von 2 aneinander grenzenden Stuetzstellen
    public double trapez
    ( Funktion fkt, double a, double b, int s)
    {
        double h = ( b - a) / ( s - 1);              // Abstand
        double[] y = fkt.tabellieren( a, s, h);

        return trapez( y, h);
    }

    /**
     * Integrieren mittels quadratischer Interpolation
     * (Simpsonregel).
     * @param y Funktionswerte aller Stuetzstellen
     * @param h Abstand zwischen den Stuetzstellen
     * @return Naeherungswert des Integrals,
     *         falls Simpsonvoraussetzung korrekt
     */
    public double simpson( double[] y, double h)
    {
        int n = y.length -1;
        double ergebnis = y[ 0] + y[ n];

        for( int i = 1; i < n; i += 2)
            ergebnis += 4 * y[ i];

        for( int i = 2; i < n - 1; i += 2)
            ergebnis += 2 * y[ i];

        return h / 3 * ergebnis;
    }

    /**
     * Integrieren mittels quadratischer Interpolation
     * (Simpsonregel).
     * @param fkt Funktion
     * @param a untere Integrationsgrenze
     * @param b obere Integrationsgrenze
     * @param s Anzahl der Stuetzstellen
     * @return Naeherungswert des Integrals
     *   falls Simpsonvoraussetzung korrekt.
     */
    public double simpson
    ( Funktion fkt, double a, double b, int s)
    {
        double h = ( b - a) / ( s - 1);
        double[] y = fkt.tabellieren( a, s, h);

        return simpson( y, h);
    }
}
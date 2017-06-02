package aufgabe11;

/**

 * Rationale Funktion (Polynom / Polynom),
 * D = R <Nennerpolynomnullstellen>, W = R.
 *
 * @author Monika Meiler, Sabine Lorius und Thomas Pause
 */
public class RationalFunktion extends Funktion
{
    /**
     * Zaehler
     */
    private Polynom zaehler = null;
    /**
     * Nenner.
     */
    private Polynom nenner= null;

    /**
     * Setzt Zaehler-und Nennerpolynom.
     * @param z Zaehlerpolynom
     * @param n Nennerpolynom
     * @return true, bei erfolgreichem Eintrag
     * false, falls keine Polynome existieren
     */
    public boolean setRationalFunktion
    ( Polynom z, Polynom n)
    {
        if( z == null || n == null)
        {
            zaehler = null;
            nenner = null;
            return false;
        }
        zaehler = z;
        nenner = n;
        return true;
    }
    /**
     * Eingabe einer rationalen Funktion ueber Konsole.
     * @return true, bei erfolgreichem Eintrag
     */
    public boolean konsolenEingabe()
    {
// Eingabe der Zaehler-und Nennerpolynome
        System.out.println( "Zaehler");
        Polynom z = new Polynom();
        if( !z.konsolenEingabe()) z = null;
        System.out.println( "Nenner");
        Polynom n = new Polynom();
        if( !n.konsolenEingabe()) n = null;
// Setzen des Zaehler-und Nennerpolynoms.
        return setRationalFunktion(z, n);
    }
    /**
     * Berechnen eines Funktionswertes Polynom / Polynom
     * unter Beruecksichtigung von Nennernullstellen.
     * @param arg Argument
     * @return f( arg), falls
     *         n == 0 und z < 0:  Double.NEGATIVE_INFINITY
     *         n == 0 und z == 0: Double.NaN
     *         n == 0 und z > 0:  Double.POSITIVE_INFINITY
     */
    public double wert( double arg)
    {
        double z = zaehler.wert( arg);
        double n = nenner.wert( arg);
        return z / n;
    }

    /**
     * Darstellung einer rationalen Funktion.
     * @return Funktion in linearer Schreibweise
     */
    public String toString(){
        return "( " + this.zaehler + " ) / ( " + this.nenner + " )";
    }
}

package aufgabe11;

import java.util.Scanner;

/**
 *
 * Ganze rationale Funktion (Polynom r-ten Grades),
 * f(x) = ar*x^r + ... a2*x^2 + a1*x + a0, D = W = R.
 *
 * @author Monika Meiler , Sabine Lorius und Thomas Pause
 *
 */
public class Polynom extends Funktion
{
    /**
     * Polynomkoeffizienten.
     */
    private double[] koeffizienten = null;

    /**
     * Setzt Polynomkoeffizienten fest.
     * @param koeff Koeffizienten des Polynoms
     * @return true, bei erfolgreichem Eintrag
     *         false, falls keine Koeffizienten existieren
     */
    public boolean setPolynom( double[] koeff)
    {
        if( koeff == null || koeff.length == 0)
        {
            koeffizienten = null;
            return false;
        }
        koeffizienten = koeff;
        return true;
    }
    /**
     * Polynomeingabe ueber Konsole.
     * @return true, bei erfolgreichem Eintrag
     */
    public boolean konsolenEingabe()
    {
// Eingabe der Polynomkoeffizienten
        double[] koeff = null;
        boolean  richtigeingeben1=false;
        boolean[]  richtigeingeben2=null;
        int grad =0;
        Scanner sc1=null;
        Scanner sc2=null;

        System.out.println( "Polynomeingabe\n--------------");

        while(!richtigeingeben1){
            try{
                System.out.println("Bitte den Grad des Polynoms eingeben (Typ int):");
                sc1=new Scanner(System.in);
                grad=sc1.nextInt();

                if(grad>=0) { richtigeingeben1=true;}
            }catch (java.util.InputMismatchException e){
                System.out.println("Falsche Eingabe!");
                e.getStackTrace();
            }
        }

        if( grad >= 0){
            koeff = new double[ grad + 1];
            richtigeingeben2=new boolean[grad+1];
            for(int i=0;i<grad+1;i++){
                richtigeingeben2[i]=false;
            }

            for( int i = 0; i < grad + 1; i++){
                while(!richtigeingeben2[i]){
                    try{
                        System.out.println("Bitte den Koeffizienten für x hoch "+i+" eingeben (Typ double):");
                        sc2=new Scanner(System.in);
                        koeff[ i] =sc2.nextDouble();
                        richtigeingeben2[i]=true;
                    }
                    catch (java.util.InputMismatchException e){
                        System.out.println("Falsche Eingabe!");
                        e.getStackTrace();
                    }
                }
            }
        }
        return setPolynom( koeff);
    }
// Setzen der Polynomkoeffizienten

    /**
     * Berechnen eines Funktionswertes nach HORNER.
     * @param arg Argument
     * @return f( arg)
     */
    public double wert( double arg)
    {
        double erg = 0;
        for( int i = koeffizienten.length -1; i >= 0; i--
                )
            erg = erg * arg + koeffizienten[ i];
        return erg;
    }

}


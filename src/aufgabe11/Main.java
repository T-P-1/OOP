package aufgabe11;
import java.util.Scanner;


/**
 * Aufgabe 1.1 Numerische Integration
 * Die Main Methode. Einsprungpunkt des Programms.
 *
 * @author Sabine Lorius und Thomas Pause
 */
public class Main {

    public static void main(String[] args){

        while(true){
            Integral integ=new Integral();
            RationalFunktion rfk=new RationalFunktion();
            rfk.konsolenEingabe();

            System.out.println( " Trapezregel mit 3 Stützpunkten: " + integ.trapez(rfk, 0, 1, 3));
            System.out.println( " Trapezregel mit 6 Stützpunkten: " + integ.trapez(rfk, 0, 1, 6));
            System.out.println( " Trapezregel mit 9 Stützpunkten: " + integ.trapez(rfk, 0, 1, 9));

            System.out.println( " Simpsonregel mit 3 Stützpunkten: " + integ.simpson(rfk, 0, 1, 3));
            System.out.println( " Simpsonregel mit 6 Stützpunkten: " + integ.simpson(rfk, 0, 1, 6));
            System.out.println( " Simpsonregel mit 9 Stützpunkten: " + integ.simpson(rfk, 0, 1, 9));

            Polynom pn=new Polynom();
            pn.konsolenEingabe();

            System.out.println( " Trapezregel mit 3 Stützpunkten: " + integ.trapez(pn, -1, 3, 3));
            System.out.println( " Trapezregel mit 5 Stützpunkten: " + integ.trapez(pn, -1, 3, 5));
            System.out.println( " Simpsonregel mit 3 Stützpunkten: "+  integ.simpson(pn, -1, 3, 3));
            System.out.println( " Simpsonregel mit 5 Stützpunkten: "+ integ.simpson(pn, -1, 3, 5));



            String weiter;
            System.out.println("Möchten sie noch eine weitere Funktion berechnen? 'ja' oder 'nein'");
            Scanner sc=new Scanner(System.in);
            weiter=sc.nextLine();
            while(!weiter.equals("ja") && !weiter.equals("nein")){
                System.out.println("Falsche Eingabe, bitte 'ja' oder 'nein' eingeben:");
                Scanner sc1=new  Scanner(System.in);
                weiter=sc1.nextLine();


            }
            if(weiter.equals("nein")){break;}
        }


    }
}
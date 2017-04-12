package Aufgabe02;

/**
 * Klasse, die einen Wuerfel darstellt.
 */

public class Wuerfel {

    private int min;
    private int max;
    private int augen;

    /**
     * Erstellt einen neuen Wuerfel.
     *
     * @param var1 min. bzw. max. Wert.
     * @param var2 max. bzw. min. Wert.
     */
    public Wuerfel(int var1, int var2) {
        if(var2 < var1) {
            this.min = var2;
            this.max = var1;
        } else {
            this.min = var1;
            this.max = var2;
        }

        this.wuerfeln();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Wuerfel " + this.min + " .. " + this.max + " Augen: " + this.augen;
    }

    /**
     * Methode, die das Wuerfeln simuliert.
     *
     * @return Augenzahl
     */
    public int wuerfeln() {
        this.augen = (int)(Math.random() * (double)(this.max - this.min + 1)) + this.min;
        return this.augen;
    }
}
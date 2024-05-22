package Esercizio_1;

public class Rettangolo {
    //attributi privati per incapsulamento
    private double altezza;
    private double larghezza;

    //costruttore con validazione dei parametri
    public Rettangolo(double altezza, double larghezza) {
        this.altezza = altezza;
        this.larghezza = larghezza;
    }

    //statico per stampare area e perimetro di due rettangoli
    public static void stampaDueRettangoli(Rettangolo r1, Rettangolo r2) {
        System.out.println("Rettangolo 1:");
        r1.stampaRettangolo();
        System.out.println("Rettangolo 2:");
        r2.stampaRettangolo();

        double sommaAree = r1.calcolaArea() + r2.calcolaArea();
        double sommaPerimetri = r1.calcolaPerimetro() + r2.calcolaPerimetro();

        System.out.println("Somma delle aree: " + sommaAree);
        System.out.println("Somma dei perimetri: " + sommaPerimetri);
    }

    // main per mostrare i risultati e funzionalità
    public static void main(String[] args) {
        // creo istanze per i rettangoli
        Rettangolo rettangolo1 = new Rettangolo(6, 25);
        Rettangolo rettangolo2 = new Rettangolo(4, 32);

        //stampo i dettagli dei rettangoli
        rettangolo1.stampaRettangolo();
        rettangolo2.stampaRettangolo();
        //stampo dei detagli di entrambi i rettangoli e delle loro somme
        Rettangolo.stampaDueRettangoli(rettangolo1, rettangolo2);
    }

    // calcola il perimetro
    public double calcolaPerimetro() {
        return 2 * (altezza + larghezza);
    }

    // calcola l'area
    public double calcolaArea() {
        return altezza * larghezza;
    }

    //stampa area e perimetro di un rettangolo
    public void stampaRettangolo() {
        System.out.println("Area: " + calcolaArea());
        System.out.println("Perimetro: " + calcolaPerimetro());
    }
}

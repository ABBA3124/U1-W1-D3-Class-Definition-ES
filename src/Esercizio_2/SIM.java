package Esercizio_2;

//class chiamata
class Chiamata {
    private String numeroChiamato;
    private int durata; //durata chiamata

    //costruttore chiamata
    public Chiamata(String numeroChiamato, int durata) {
        this.numeroChiamato = numeroChiamato;
        this.durata = durata;
    }

    //getter per ottenere il numero chiamato
    public String getNumeroChiamato() {
        return numeroChiamato;
    }

    //getter per ottenere la durata della chiamata
    public int getDurata() {
        return durata;
    }
}

//class che rappresenta una SIM
public class SIM {
    private String numeroTelefono;
    private double credito;
    private Chiamata[] listaChiamate;
    private int numeroChiamate;

    //costruttore per inizializzare la SIM con numero di telefono, credito a 0 e lista chiamate vuota
    public SIM(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
        this.credito = 0.0;
        this.listaChiamate = new Chiamata[5]; // Dimensione fissa di 5
        this.numeroChiamate = 0;
    }

    //MAIN
    public static void main(String[] args) {
        //crea istanza di sim
        SIM miaSIM = new SIM("3488695712");

        //chiamate di prova
        miaSIM.aggiungiChiamata("0987654321", 5);
        miaSIM.aggiungiChiamata("1231231234", 10);
        miaSIM.aggiungiChiamata("1578913251", 2);
        miaSIM.aggiungiChiamata("4654613611", 7);
        miaSIM.aggiungiChiamata("3488687415", 3);
        miaSIM.aggiungiChiamata("8333156416", 8); // questa in teoria andrà sotto

        //stampa risultati
        miaSIM.stampaDatiSIM();
    }

    //aggiunge una chiamata alla lista delle chiamate
    public void aggiungiChiamata(String numeroChiamato, int durata) {
        if (numeroChiamate == listaChiamate.length) {
            //questo permette di fare spazio alla nuova chiamata
            for (int i = 1; i < listaChiamate.length; i++) {
                listaChiamate[i - 1] = listaChiamate[i];
            }
            numeroChiamate--;
        }
        listaChiamate[numeroChiamate++] = new Chiamata(numeroChiamato, durata);
    }

    //stampa i dati sim
    public void stampaDatiSIM() {
        System.out.println("Numero di telefono: " + numeroTelefono);
        System.out.println("Credito disponibile: " + credito + " euro");
        System.out.println("Ultime 5 chiamate effettuate:");
        for (int i = 0; i < numeroChiamate; i++) {
            Chiamata chiamata = listaChiamate[i];
            System.out.println("Numero chiamato: " + chiamata.getNumeroChiamato() + ", Durata: " + chiamata.getDurata() + " minuti");
        }
    }
}

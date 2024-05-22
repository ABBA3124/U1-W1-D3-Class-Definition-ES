package Esercizio_3;

import java.text.SimpleDateFormat;
import java.util.Date;

//class articolo
class Articolo {
    private String codiceArticolo;
    private String descrizione;
    private double prezzo;
    private int numeroPezzi;

    //costruttore articolo
    public Articolo(String codiceArticolo, String descrizione, double prezzo, int numeroPezzi) {
        this.codiceArticolo = codiceArticolo;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.numeroPezzi = numeroPezzi;
    }

    //getter per ottenere il codice dell'articolo
    public String getCodice() {
        return codiceArticolo;
    }

    //getter per ottenere il prezzo dell'articolo
    public double getPrezzo() {
        return prezzo;
    }

    //getter per ottenere la descrizione dell'articolo
    public String getDescrizione() {
        return descrizione;
    }

    //getter per ottenere il numero di pezzi disponibili
    public int getNumeroPezzi() {
        return numeroPezzi;
    }

    //rappresentazione stringa articolo
    public String toString() {
        return "Codice Articolo: " + codiceArticolo + ", Descrizione: " + descrizione + ", Prezzo: " + prezzo + " euro, Numero pezzi disponibili: " + numeroPezzi;
    }
}

//class cliente
class Cliente {
    private String codiceCliente;
    private String nome;
    private String cognome;
    private String email;
    private Date dataIscrizione;

    //costruttore cliente
    public Cliente(String codiceCliente, String nome, String cognome, String email, Date dataIscrizione) {
        this.codiceCliente = codiceCliente;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataIscrizione = dataIscrizione;
    }

    //getter per ottenere il codice del cliente
    public String getCodiceCliente() {
        return codiceCliente;
    }

    //getter per ottenere il nome completo del cliente
    public String getNomeCompleto() {
        return nome + " " + cognome;
    }

    //getter per ottenere l'email del cliente
    public String getEmail() {
        return email;
    }

    //getter per ottenere la data di iscrizione
    public Date getDataIscrizione() {
        return dataIscrizione;
    }

    //rappresentazione stringa cliente
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Codice Cliente: " + codiceCliente + ", Nome: " + nome + " " + cognome + ", Email: " + email + ", Data Iscrizione: " + sdf.format(dataIscrizione);
    }
}

//class carrello
class Carrello {
    private Cliente clienteAssociato;
    private Articolo[] elencoArticoli;
    private double totaleCosto;
    private int numeroArticoli;

    //costruttore carrello
    public Carrello(Cliente clienteAssociato) {
        this.clienteAssociato = clienteAssociato;
        this.elencoArticoli = new Articolo[10]; // Dimensione fissa di 10
        this.totaleCosto = 0.0;
        this.numeroArticoli = 0;
    }

    //MAIN
    public static void main(String[] args) {
        Cliente cliente = new Cliente("C001", "Mario", "Rossi", "mario.rossi@example.com", new Date());

        Articolo articolo1 = new Articolo("A001", "Smartphone", 299.99, 10);
        Articolo articolo2 = new Articolo("A002", "Laptop", 799.99, 5);
        Articolo articolo3 = new Articolo("A003", "Tablet", 199.99, 7);

        Carrello carrello = new Carrello(cliente);

        //aggiungiamo articoli al carrello
        carrello.aggiungiArticolo(articolo1);
        carrello.aggiungiArticolo(articolo2);
        carrello.aggiungiArticolo(articolo3);

        //stampa dei dettagli carrello
        carrello.stampaDettagliCarrello();
    }

    //aggiungere un articolo al carrello
    public void aggiungiArticolo(Articolo articolo) {
        if (numeroArticoli < elencoArticoli.length) {
            if (articolo.getNumeroPezzi() > 0) {
                elencoArticoli[numeroArticoli++] = articolo;
                totaleCosto += articolo.getPrezzo();
            } else {
                System.out.println("Articolo non disponibile: " + articolo.getDescrizione());
            }
        } else {
            System.out.println("Carrello pieno. Impossibile aggiungere altri articoli.");
        }
    }

    //stampa dettagli del carrello
    public void stampaDettagliCarrello() {
        System.out.println("Cliente associato:");
        System.out.println(clienteAssociato);
        System.out.println("Articoli nel carrello:");
        for (int i = 0; i < numeroArticoli; i++) {
            System.out.println(elencoArticoli[i]);
        }
        System.out.println("Totale costo articoli: " + totaleCosto + " euro");
    }
}

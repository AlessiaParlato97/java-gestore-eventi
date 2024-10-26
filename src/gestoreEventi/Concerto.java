package gestoreEventi;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Concerto extends Evento { //utilizzo del Polimorfismo
	
	//Dichiarazione attributi:
	private LocalTime time;
	private double prezzo;
	
	//Costruttore
	public Concerto(String title, LocalDate date, int totPlaces, LocalTime time, double prezzo) throws Exception {
		 //Inizializzazione attributi:
		super(title, date, totPlaces);
		this.time = time;
		this.prezzo = prezzo;
	}
		
	
	
	//Utilizzo dell'Incapsulamento
	//Get-Set time:
	public LocalTime getTime() {
		return time;
	}
	
	public void setTime(LocalTime time) {
		this.time = time;
		}
	
	//Get-Set prezzo:
	public double getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	//Metodi per formattare data e ora:
	public String getDateTimeFormatter() {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
		return getDate().format(dateFormatter) + " " + getTime().format(timeFormatter);
	}
	
	//Metodo per formattare il prezzo: (DA RIVEDERE)
	public String getPrezzoFormatter() { //serve a formattare un prezzo in modo che venga visualizzato con due cifre decimali e il simbolo dell’euro (€) alla fine.
		return String.format("%.2f€", prezzo); //String.format è un metodo che permette di formattare una stringa con un modello specifico indicato: prezzo verrà rappresentato come un numero in virgola (float) con due cifre decimali.
	}
	
	@Override //Metodo toString() che converte una Stringa in un oggetto
	public String toString() {
		return getDateTimeFormatter() + " - " + getTitle() + " - " + getPrezzoFormatter();
	}
	}
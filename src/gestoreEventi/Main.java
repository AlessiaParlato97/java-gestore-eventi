package gestoreEventi;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	try (Scanner scanner = new Scanner(System.in)) { //inserire tutto in un try consente la chiusura corretta dello scanner in console (mi dava problemi con la chiusura inserendo la possibilità di scelta)
	
	
	// Richiesta ccelta dell'utente tra Evento o Concerto:
	System.out.println("Evento (digita 1) o Concerto (digita 2)? ");
	int scelta = scanner.nextInt();
	scanner.nextLine();  //Richiamo dello scanner causa consuma la newline rimasta dopo nextInt.
	
	
	
	
	//Se l'utente sceglie 1:
	if (scelta == 1) {
		//CREAZIONE - INTERAZIONE CON L'UTENTE - (OGGETTO CLASSE EVENTO)
		try { //
			
	    //Richieste all'utente (title):
		System.out.println("Inserire un nuovo evento: ");
		String title = scanner.nextLine();
		
		//Richiesta all'utente (date):
		System.out.println("Inserire data dell'evento: gg/mm/yyyy ");
		String dateInput = scanner.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(dateInput, formatter);
		/*Questo metodo cerca di convertire una stringa(in input dall'utente)in un oggetto.
		 * Il formato atteso è YYYY-MM-DD, se diverso "parse()" evoca un'eccezione:
		 * (DateTimeParseException) per indicare la NON validazione della stringa.*/
		
		//Controllo se la data è antecedente alla data odierna
		if (date.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("La data inserita è antecedente a quella odierna.");
		}
		
		//Richiesta all'utente (totplaces):
		System.out.println("Inserire numero posti disponibili totali: ");
		int totPlaces = scanner.nextInt();
		
		
		//Creazione dell'evento:
		Evento evento = new Evento(title, date, totPlaces);
		// Stampa la rappresentazione dell'evento (toString)
	    System.out.println(evento);
		
		
		//Aggiungere quantità di prenotazioni interagendo con l'utente:
		System.out.println("Inserire, se ci sono, quante prenotazioni effettuare: ");
		int totReserved = scanner.nextInt();
		
		//Metodo che esegue l'incrementazione dei posti riservati o rivela errori(rif. classe evento):
		for(int i = 0; i < totReserved; i++) {
			evento.prenota();
		}
		
		//Stampa posti totali prenotati:
		System.out.println("Posti prenotati: " + evento.getTotReserved());
		//Stampa posti ancora disponibili:
		System.out.println("Posti ancora disponibili: " + (evento.getTotPlaces() - evento.getTotReserved()));
		
		
		//Disdire quantità di prenotazioni interagendo con l'utente:
		System.out.println("Inserire, se ci sono, quanti posti disdire: ");
		int disdette = scanner.nextInt();
		
		//Metodo che esegue la incrementazione dei posti totali (decrementazione dei posti riservati) o rivela errori(rif. classe evento):
		for (int i = 0; i < disdette; i++) {
			evento.disdici();
		}
		
		//Stampa posti totali prenotati
		System.out.println("Posti prenotati: " + evento.getTotReserved());
		//Stampa posti ancora disponibili
		System.out.println("Posti ancora disponibili: " + (evento.getTotPlaces() - evento.getTotReserved()));
	
		} catch (Exception e) {
		System.err.println("Errore: " + e.getMessage());
	}
		
		
		
		
		
		
		
		
	//Se l'utente sceglie 2:
    } else if (scelta == 2) {

	//CREAZIONE - INTERAZIONE CON L'UTENTE - (OGGETTO CLASSE CONCERTO)
	try {
	//Richieste all'utente (title):
		System.out.println("Inserire un nuovo concerto: ");
		String title = scanner.nextLine();
		
		//Richiesta all'utente (date):
		System.out.println("Inserire data del concerto: gg/mm/yyyy ");
		String dateInput = scanner.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(dateInput, formatter);
		/* Questo metodo cerca di convertire una stringa(in input dall'utente)in un oggetto.
		  Il formato atteso è YYYY-MM-DD, se diverso "parse()" evoca un'eccezione:
		 (DateTimeParseException) per indicare la NON validazione della stringa.*/
	
		//Cattura dell'errore data antecedente alla data odierna
		//Controllo se la data inserita è antecedente
		if (date.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("La data inserita è antecedente alla odierna.");
		}
		
		
		//Richiesta all'utente (totplaces):
		System.out.println("Inserire numero posti disponibili totali al concerto: ");
		int totPlaces = scanner.nextInt();
		scanner.nextLine(); //Richiamo dello scanner causa consuma la newline rimasta dopo nextInt.

		//Richiesta all'utente (time):
		System.out.println("Inserire l'orario del concerto: HH:mm");
		String timeInput = scanner.nextLine();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time = LocalTime.parse(timeInput, timeFormatter);
		

		//Richiesta all'utente (prezzo);
		System.out.println("Inserire prezzo per biglietto concerto: ");
		double prezzo = scanner.nextDouble();
		scanner.nextLine();  // Richiamo dello scanner causa consuma la newline rimasta dopo nextDouble
		
		//Creazione del concerto:
		Concerto concerto = new Concerto(title, date, totPlaces, time, prezzo);
		// Stampa la rappresentazione dell'evento concerto
	    System.out.println(concerto);
	    
	} catch (IllegalArgumentException e) {
        System.err.println("Errore: " + e.getMessage());    
	} catch (Exception e) {
        System.err.println("Si è verificato un errore: " + e.getMessage());
        
	}
    } else { //Se la scelta non è tra 1 e 2
        System.out.println("Scelta non valida.");
    }
	}
}
}

package gestoreEventi;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {

try (Scanner scanner = new Scanner(System.in)) { //inserire tutto in un try consente la chiusura corretta dello scanner in console (mi dava problemi con la chiusura inserendo la possibilità di scelta)
	
	
	// Richiesta scelta dell'utente tra Evento, Concerto e ProgrammaEventi:
	System.out.println("Scegli: \n 1. per creare un Evento, \n 2. per creare un Concerto, \n 3. per creare un Programma di eventi.");
	int scelta = scanner.nextInt(); 
	scanner.nextLine();  //Richiamo dello scanner causa: consuma la newline rimasta dopo nextInt.
	
	
	
	
//>>Se l'utente sceglie 1:
	if (scelta == 1) {
		
		//CREAZIONE - INTERAZIONE CON L'UTENTE - (OGGETTO CLASSE EVENTO)
		try { //gestione delle eccezioni: codice che potrebbe generare eccezioni
			
	    //Richieste all'utente (title):
		System.out.println("Inserire un nuovo evento: ");
		String title = scanner.nextLine();
		
		//Richiesta all'utente (date):
		System.out.println("Inserire data dell'evento: gg/mm/yyyy ");
		String dateInput = scanner.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(dateInput, formatter);
		/*Questo metodo cerca di convertire una stringa (in input dall'utente) in un oggetto.
		 * Il formato atteso è YYYY-MM-DD, se diverso "parse()" evoca un'eccezione:
		 * (DateTimeParseException) per indicare la NON validazione della stringa.*/
		
		        //Controllo se la data è antecedente alla data odierna
		        //public void checkBeforeDate(date) throws IllegalArgumentException {
		          if (date.isBefore(LocalDate.now())) {
			          throw new IllegalArgumentException("La data inserita è antecedente a quella odierna.");
		          }
		       //}
		
		//Richiesta all'utente (totplaces):
		System.out.println("Inserire numero posti disponibili totali: ");
		int totPlaces = scanner.nextInt();
		
		
//----- Creazione dell'oggetto EVENTO:
		Evento evento = new Evento(title, date, totPlaces);
		// Stampa la rappresentazione dell'EVENTO
	    System.out.println(evento);
	    
		
		
		//Richiesta all'utente quantità di eventuali prenotazioni:
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
		
		
		//Richiesta all'utente se disdire quantità di prenotazioni:
		System.out.println("Inserire, se ci sono, quanti posti disdire: ");
		int disdette = scanner.nextInt();
		scanner.nextLine(); // Consuma la newline rimasta dopo nextInt
		
		       //Metodo che esegue la incrementazione dei posti totali (decrementazione dei posti riservati) o rivela errori(rif. classe evento):
		         for (int i = 0; i < disdette; i++) {
			          evento.disdici();
	             }
		
		//Stampa posti totali prenotati
		System.out.println("Posti prenotati: " + evento.getTotReserved());
		//Stampa posti ancora disponibili
		System.out.println("Posti ancora disponibili: " + (evento.getTotPlaces() - evento.getTotReserved()));
	
		} catch (Exception e) { //gestione dell'eccezione
		System.err.println("Errore: " + e.getMessage());
	    }
		
		
		
		
		
		
		
		
//>>Se l'utente sceglie 2:
  } else if (scelta == 2) { 

	    //CREAZIONE - INTERAZIONE CON L'UTENTE - (OGGETTO CLASSE CONCERTO)
	    try { //gestione delle eccezioni: codice che potrebbe generare eccezioni
	    
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
	
		
		      //Controllo se la data inserita è antecedente (cattura errore)
	            if (date.isBefore(LocalDate.now())) {
			        throw new IllegalArgumentException("La data inserita è antecedente alla data di oggi.");
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
		
//---- Creazione dell'oggetto CONCERTO:
		Concerto concerto = new Concerto(title, date, totPlaces, time, prezzo);
		// Stampa la rappresentazione di CONCERTO
	    System.out.println(concerto);
	    
	    
	    
	    
	} catch (IllegalArgumentException e) { //cattura errore isBefore(LocalDate.now)
        System.err.println("Errore: " + e.getMessage());   
        
	} catch (Exception e) { //cattura errore
        System.err.println("Si è verificato un errore: " + e.getMessage());   
	} 
	
	
	
	
	
	
	
//>>Se l'utente sceglie 3
  } else if (scelta == 3) {
    	
        //CREAZIONE - INTERAZIONE CON L'UTENTE - (OGGETTO CLASSE PROGRAMMA EVENTI)
        try { //gestione delle eccezioni: codice che potrebbe generare eccezioni
        	String sceltaProgramma = "";
        	String dateInput; //dichiarazione della variabile
        	
        	System.out.println("Inserisci il titolo del programma eventi: ");
            String titoloProgramma = scanner.nextLine();
            ProgrammaEventi programma = new ProgrammaEventi(titoloProgramma);
            boolean scegli = true;
            
//---- Creazione dell'oggetto PROGRAMMA
       //ProgrammaEventi programma = new ProgrammaEventi(titoloProgramma);
       //Stampa la rappresentazione del PROGRAMMA
	   //System.out.println(programma);
	   
	  
	   //in un ciclo while creiamo delle opzioni di scelta
	   do {
		   //Opzioni per l'utente:
		   System.out.println("Scegliere un'opzione:");
		   System.out.println("1. Aggiungere nuovo evento.");
		   System.out.println("2. Mostra Lista di eventi in una data specifica. ");
		   System.out.println("3. Mostrare numero eventi totali aggiunti.");
		   System.out.println("4. Svuotare il programma eventi.");
		   System.out.println("5. Visualizza il programma creato.");
		   System.out.println("6. Uscire.");
		   
		   //String sceltaProgramma = scanner.nextLine();
		   System.out.println("Scelta programma: ");
           sceltaProgramma = scanner.nextLine();
		
		  
		  
	   
	 //Creazione ed elaborazione scelte classe Programma
	   switch (sceltaProgramma.trim()) {
	   
	   
	   case "1": //Aggiungere evento
		 
		   //Richiesta dell'utente (title):
	        System.out.println("Inserisci il titolo del nuovo evento: ");
	        String title = scanner.nextLine();
	        
	      //Richiesta all'utente (date):
	        System.out.println("Inserire data dell'evento programmato: gg/mm/yyyy ");
	        dateInput = scanner.nextLine();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        LocalDate date = LocalDate.parse(dateInput, formatter);
	      	/* Questo metodo cerca di convertire una stringa(in input dall'utente)in un oggetto.
	      	Il formato atteso è YYYY-MM-DD, se diverso "parse()" evoca un'eccezione:
	        (DateTimeParseException) per indicare la NON validazione della stringa.*/
	       
	      //Richiesta all'utente (totPlaces):
			System.out.println("Inserire numero posti disponibili totali: ");
			int totPlaces = scanner.nextInt();
			scanner.nextLine(); // Consuma la newline rimasta dopo nextInt
	        
	        Evento nuovoEvento = new Evento(title, date, totPlaces);
	        
	        programma.addEvents(nuovoEvento); //richiamo del metodo aggiungi evento nella classe EVENTO
	        
	        System.out.println("Nuovo evento aggiunto.");
	        break;
	   
	   case "2" : //Mostrare una lista di eventi programmati nella stessa data
		   System.out.println("Inserisci la data degli eventi che vuoi vedere.");
		   dateInput = scanner.nextLine();
		   DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate date1 = LocalDate.parse(dateInput, formatter1);
			/* Questo metodo cerca di convertire una stringa(in input dall'utente)in un oggetto.
			  Il formato atteso è YYYY-MM-DD, se diverso "parse()" evoca un'eccezione:
			 (DateTimeParseException) per indicare la NON validazione della stringa.*/
		   
			//System.out.println(programma.getEventsByDate(programma, date1));
			System.out.println(programma.getEventsByDateTest(date1)); //questo test aiuta a confermare che getEventsByDate svolga correttamente il suo compito di selezionare e restituire solo gli eventi per una data specifica, permettendo di individuare eventuali errori o malfunzionamenti.
		   break;
	        
	   case "3": //Mostrare il numero totale di eventi.
		   System.out.println("Il numero totale di eventi nel programma è: " + programma.getNumberEvents());
		   break;
	
	   case "4": //Svuotare la lista programma eventi.
		   programma.clearEvents();
		   System.out.println("La lista di eventi è stata svuotata completamente.");
		   break;
		   
	   case "5": //Restituisce una stringa che mostra il titolo del programma e tutti gli eventi ordinati per data nella forma: data - titolo
		   System.out.println("Programma (ordinato): \n" + programma.programmaInOrdine());
		   break;
		   
	   case "6": //Uscita dal programma.
		   scegli = false;
		   System.out.println("Uscita dal programma.");
		   break;
		   
	   /*default:
		   System.out.println("Scelta inserita non valida. Riprova.");
		   break;*/
	  
	   }
	   } while (scegli);
		   
    	
       } catch (Exception e) { //Cattura errore
           System.err.println("Errore: " + e.getMessage());

       }
        
        
    
//>>Se la scelta non è tra 1 / 2 / 3 / 4 / 5 / 6 
  } else {
        System.out.println("Scelta non valida.");
  }
 }
}
}

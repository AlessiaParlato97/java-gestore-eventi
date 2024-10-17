package gestoreEventi;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

	//Attributi evento:
	private String title;
	private LocalDate date;
	private int totPlaces;
	private int totReserved;
	
	//Costruttore
	public Evento(String title, LocalDate date, int totPlaces) throws Exception {
		//Inizializzazione attributi, valorizzati nel costruttore
				this.title = title;
				this.date = date;
				this.totPlaces = totPlaces;
				this.totReserved = 0; //inizializzazione a 0 dei posti prenotati
			
		//Controllo che la data non sia già passata
		if (date.isBefore(LocalDate.now())) {
			throw new Exception("La data dell'evento non può essere precedente alla data di oggi.");
		}
		//e che il numero di posti totali sia positivo.
		if (totPlaces <= 0) {
			throw new Exception("Il numero di posti totali deve essere positivo.");
		}
		
		
	}
	
	//Getter & Setter (legibilità in lettura e scrittura degli attributi private)
	
	//Get-Set title
	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
	//Get-Set date
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) throws Exception{
        if (date.isBefore(LocalDate.now())) {
        	throw new Exception("La data dell'evento non può essere già passata.");
        }
        this.date = date;
    }
    
	//Get-Set totPlaces
    public int getTotPlaces() {
        return totPlaces;
    }

	//Get-Set totReserved
    public int getTotReserved() {
        return totReserved;
    }
 
    
    
    
    
    //Metodo prenota()
    public void prenota() {
    	
    	if (date.isBefore(LocalDate.now())) { //se l'evento è già passato..
    		System.err.println("L'evento è già passato.");
    	} else if (totReserved >= totPlaces) { //se non ci sono più posti prenotabili..
    		System.err.println("Non ci sono più posti disponibili per accedere all'evento.");
    	} else { //altrimenti prenota incrementando i posti prenotati.
    		totReserved++;
    	}
    	
    }
    
    //Metodo disdici()
    public void disdici() {
    	
    	if (date.isBefore(LocalDate.now())){ //se l'evento è già passato..
    		System.err.println("L'evento è già passato.");
    	} else if (totReserved <= 0){ //se non ci sono prenotazioni per l'evento..
    		System.err.println("Non ci sono prenotazioni da disdire.");
    	} else { //altrimenti disdici prenotazione.
    		totReserved--;
    	}
    }
    
    
    
    //Metodo Override per formattazione: restituzione Stringa(date - title)
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter) + " - " + title;
    }

}

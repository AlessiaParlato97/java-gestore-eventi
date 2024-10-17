//Bonus
package gestoreEventi;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
//import java.time.LocalDate;
//import java.util.stream.Collectors;

public class ProgrammaEventi extends Evento{
    //Attributi
	private String titoloProgramma;
	private List<Evento> events;
	
	//Costruttore
	public ProgrammaEventi(String title, LocalDate date, int totPlaces, String titoloProgramma) throws Exception {
		super(title, date, totPlaces);
		this.titoloProgramma = title;
		this.events = new ArrayList<>();
	}
	
	//Metodo per aggiungere evento
	public void addEvents(Evento evento) {
		events.add(evento);
	}
	
	//Metodo che restituisce una lista con tutti gli eventi presenti in una certa data (tramite creazione di collezione)

	
	//Metodo che restituisce quanti eventi sono presenti nel programma
	public int getNumberEvents() {
		return events.size();
	}
	
	//Metodo che svuota la lista di eventi
	public void clearEvents() {
		events.clear();
	}
    
	//Metodo che restituisce una stringa che mostra il titolo del programma e tutti gli eventi ordinati per data nella forma: 
	
	
}

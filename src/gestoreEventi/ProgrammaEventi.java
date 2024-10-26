//Bonus
package gestoreEventi;
import java.util.*;
import java.time.*;
//import java.util.ArrayList;
//import java.time.LocalDate;

public class ProgrammaEventi {
    //Dichiarazione attributi:
	private String titoloProgramma;
	private List<Evento> events;

	//Inizzializzazione attributi:
	public ProgrammaEventi(String titoloProgramma) throws Exception {
		this.titoloProgramma = titoloProgramma;
		this.events = new ArrayList<>();
	}
	
	//Metodo per aggiungere un evento a un programma
	public void addEvents(Evento evento) throws Exception {
		LocalDate dataCorrente = LocalDate.now();
		if (dataCorrente.isBefore(dataCorrente)) {
			System.err.println("Errore: La data non può essere passata.");
		} else {
		 events.add(evento);
		}
	}
	
	//Metodo che restituisce una lista con tutti gli eventi presenti in una certa data
	public List<Evento> getEventsByDateTest(LocalDate date) {
		//events.forEach(evento -> {}); //LambdaExpression(sistassi ->)
		List<Evento> listaEvento = new ArrayList<>(); //inizializzazione nuova lista evento vuota
		
		for (Evento event: events) {
			if (event.getDate().toString().equalsIgnoreCase(date.toString())){ //prelevo data dell'evento, confronto con l'input data utente
			   listaEvento.add(event); //aggiunta evento singolo nella nuova lista (inizialmente vuota)
			}
		}
		return listaEvento;
	}
	
	//Getter della lista eventi
	public List<Evento> getEvents() {
		return events;
	}
	
	//Metodo che restituisce quanti eventi sono presenti nel programma
	public int getNumberEvents() {
		return events.size();
	}
	
	//Metodo che svuota la lista di eventi
	public void clearEvents() {
		events.clear();
	}
    
	//Metodo che restituisce una stringa che mostra il titolo del programma e tutti gli eventi ordinati per data nella forma: data - titolo
	public String programmaInOrdine() {
		String stringaConcatenata = titoloProgramma;
		
		for (Evento event: events) {
			stringaConcatenata +=  "\n " + event.getDate() + " " + event.getTitle();
			
		}
		
		
		
		return stringaConcatenata;
	}
	
}

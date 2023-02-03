package org.lessons.java.gestore.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammaEvento {

	private String titolo;
	private List<Evento> eventi;

	// constructor
	public ProgrammaEvento(String titolo) {
		this.titolo = titolo;
		this.eventi = new ArrayList<>();
	}

	// functions
	public void addEvento(Evento evento) {
		this.eventi.add(evento);
	}

	public void eventiInData(LocalDate data) {
		for (Evento i : this.eventi) {
			if (i.getData().isEqual(data)) {
				System.out.println(i);
			}
		}
	}

	public int numeroEventi() {
		return this.eventi.size();
	}

	public void svuotaLista() {
		this.eventi.clear();
	}

}

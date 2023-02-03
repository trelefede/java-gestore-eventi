package org.lessons.java.gestore.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

	private String titolo;
	private LocalDate data;
	private int postiTotali;
	private int postiPrenotati = 0;

	public Evento(String titolo, LocalDate data, int postiTotali) throws Exception {
		validateTitolo(titolo);
		validateData(data);
		validatePostiTotali(postiTotali);
	}

	// getters and setters
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) throws Exception {
		validateTitolo(titolo);
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) throws Exception {
		validateData(data);
	}

	public int getPostiTotali() {
		return postiTotali;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}

	// metodi prenota/disdici
	public void prenota(int n) throws Exception {
		if (data.isBefore(LocalDate.now())) {
			throw new Exception("I viaggi nel tempo ancora non esistono! L'evento non è più disponibile!");
		} else if (postiPrenotati == postiTotali) {
			throw new Exception("Posti terminati per questo evento");
		}
		this.postiPrenotati = this.postiPrenotati + n;
	}

	public void disdici(int n) throws Exception {
		if (postiPrenotati == 0) {
			throw new Exception("Nessuna prenotazione trovata");
		} else if (data.isBefore(LocalDate.now())) {
			throw new Exception("I viaggi nel tempo ancora non esistono! L'evento non è più disponibile!");
		}
		this.postiPrenotati = this.postiPrenotati - n;
	}

	// metodo posti disponibili
	public int postiDisponibili() {
		int disponibili = this.postiTotali - this.postiPrenotati;
		return disponibili;
	}

	// validations
	public void validateTitolo(String titolo) throws Exception {
		if (titolo.isEmpty()) {
			throw new Exception("Titolo obbligatorio!");
		}
		this.titolo = titolo;
	}

	public void validateData(LocalDate data) throws Exception {
		if (data.isBefore(LocalDate.now())) {
			throw new Exception("I viaggi nel tempo ancora non esistono! Inserisci una data futura");
		}
		this.data = data;
	}

	public void validatePostiTotali(int postiTotali) throws Exception {
		if (postiTotali <= 0) {
			throw new Exception("Numero posti totali non può essere inferiore a 1");
		}
		this.postiTotali = postiTotali;
	}

	// formattazione data
	private String formatData(LocalDate data) {
		DateTimeFormatter form = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		String dataForm = data.format(form);
		return dataForm;
	}

	@Override
	public String toString() {
		return "Data: " + formatData(data) + "\n" + "Evento: " + titolo;
	}

}

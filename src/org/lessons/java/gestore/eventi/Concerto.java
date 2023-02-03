package org.lessons.java.gestore.eventi;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {

	LocalTime ora;
	BigDecimal prezzo;

	public Concerto(String titolo, LocalDate data, int postiTotali, LocalTime ora, BigDecimal prezzo) throws Exception {
		super(titolo, data, postiTotali);
		validatePrezzo(prezzo);
		validateOra(ora);
	}

	// getters and setters
	public LocalTime getOra() {
		return ora;
	}

	public void setOra(LocalTime ora) {
		this.ora = ora;
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}

	// validations
	public void validateOra(LocalTime ora) throws Exception {
		if (ora == null) {
			throw new Exception("Ora obbligatoria!");
		}
		this.ora = ora;
	}

	public void validatePrezzo(BigDecimal prezzo) throws Exception {
		if (prezzo.signum() <= 0) {
			throw new Exception("Prezzo obbligatorio!");
		}
		this.prezzo = prezzo;
	}

	// formattazione
	private String formatOra(LocalTime ora) {
		DateTimeFormatter form = DateTimeFormatter.ofPattern("hh:mm");
		String oraForm = ora.format(form);
		return oraForm;
	}

	private String formatPrezzo(BigDecimal prezzo) {
		String prezzoForm = new DecimalFormat("#0.##").format(prezzo);
		return prezzoForm;
	}

	@Override
	public String toString() {
		return "Data e ora: " + formatData(getData()) + " " + formatOra(ora) + "\n" + "Titolo: " + getTitolo() + "\n"
				+ "Prezzo: " + formatPrezzo(prezzo) + "€";
	}

}

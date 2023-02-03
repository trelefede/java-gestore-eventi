package org.lessons.java.gestore.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// istanzio evento
		Evento event = null;

		System.out.println("Inserisci nuovo evento. Inizia con il titolo: ");
		String titolo = sc.nextLine();
		System.out.println("Quando si svolgera? Inserisci il giorno (da 1 a 31): ");
		String giorno = sc.nextLine();
		System.out.println("Inserisci il mese (da 1 a 12): ");
		String mese = sc.nextLine();
		System.out.println("Inserisci l'anno");
		String anno = sc.nextLine();
		System.out.println("Inserisci il numero di posti totali per l'evento: ");
		int posti = sc.nextInt();
		sc.nextLine();

		int d = Integer.parseInt(giorno);
		int m = Integer.parseInt(mese);
		int y = Integer.parseInt(anno);
		LocalDate data = LocalDate.of(y, m, d);

		try {
			event = new Evento(titolo, data, posti);
			System.out.println(event);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// prenotaione posti
		System.out.println("Vuoi prenotare dei posti? s/n");
		String s = sc.nextLine();
		if (s.equalsIgnoreCase("n")) {
			System.out.println("Saluti");
		} else if (s.equalsIgnoreCase("s")) {
			System.out.println("Quanti posti vuoi prenotare?");
			int nPosti = sc.nextInt();
			sc.nextLine();
			try {
				event.prenota(nPosti);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Posti prenotati: " + event.getPostiPrenotati() + "\n" + "Posti disponibili: "
					+ event.postiDisponibili());
		}

		// disdire posti
		System.out.println("Vuoi disdire dei posti? s/n");
		String t = sc.nextLine();
		if (t.equalsIgnoreCase("n")) {
			System.out.println("Saluti");
		} else if (t.equalsIgnoreCase("s")) {
			System.out.println("Quanti posti vuoi disdire?");
			int nPosti = sc.nextInt();
			sc.nextLine();
			try {
				event.disdici(nPosti);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Posti prenotati: " + event.getPostiPrenotati() + "\n" + "Posti disponibili: "
					+ event.postiDisponibili());
		}

		sc.close();

	}

}

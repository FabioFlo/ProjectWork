package com.g3.projectwork.utility;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.g3.projectwork.entities.Gioco;


public class GestoreTemplate {

	private String percorsoCartellaViste;

	public GestoreTemplate(String percorsoCartellaViste) {
		this.percorsoCartellaViste = percorsoCartellaViste;
	}

	//Lettura file html in webapp/viste per inviarli come stringhe al browser che li adatta
	public String leggiFileHTML(String nomeFile) {
		String ris = "";
		try {
			Scanner file = new Scanner(new File(percorsoCartellaViste + nomeFile));
			while(file.hasNextLine()) {
				ris += file.nextLine() + "\n";
			}
			file.close();
		} catch(Exception e) {
			System.out.println("404 - File non trovato al percorso: " + percorsoCartellaViste + nomeFile);
			e.printStackTrace();
		}
		return ris;
	}

	public String graficaGioco(Gioco g) {
		String ris = leggiFileHTML("templateGioco.html");
		ris = ris.replace("[id]", g.getIDGioco()+"")
				.replace("[titolo]", g.getTitolo())
				.replace("[IDSviluppatore]", g.getIDSviluppatore()+"")
			    .replace("[IDEditor]", g.getIDEditor()+"")
				.replace("[IDGenere]", g.getIDGenere()+"")
				.replace("[IDPiattaforma]", g.getIDPiattaforma()+"")
				.replace("[data_uscita]", g.getDataUscita()+"")
				.replace("[pegi]", g.getPegi()+"")
				.replace("[serie]", g.getSerie());
		return ris;
	}
	
	public String graficaElenco(Iterable<Gioco> giochi) {
		System.out.println(giochi.iterator().hasNext());
		String ris = leggiFileHTML("giochi.html");
		String elenco = "";
		for(Gioco g : giochi) {
			elenco += graficaGioco(g);
			System.out.println(g.toString());
		}
		ris = ris.replace("[elenco]", elenco);
		if(elenco.equalsIgnoreCase(""))
			ris = "VUOTO";
		return ris;
	}
	
	
	
}

package com.g3.projectwork.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.g3.projectwork.entities.Editor;
import com.g3.projectwork.repos.EditorRepository;

/*Classe alternativa all'Editor controller
 * Anzichè dichiarare un @RestController, dichiariamo un istanza di @Controller 
 * Il comportamento diventa simile a quello dell'home controller ma possiamo separare
 * i processi tramite i @GetMapping riferiti al CRUD e i processi per la visualizzazione
 * delle pagine, dove sono contenute le funzioni stesse.
 * 
 * E' lo stesso processo che attuavamo all'inizio ma si introduce il concetto del Model
 * 
 * Il Model può essere visto come un tool per fornire attributi per renderizzare la vista
 * Per fornire dati utilizzabili alla vista, aggiungiamo i dati all'oggetto Model
 * LE MAPPE, se vogliamo passare a quel metodo di lettura dei dati possono essere inserite direttamente nel Model
 * 
 * ESEMPIO 
 * Metodo nel controller:
 * @GetMapping("/showViewPage")
 * public String passParametersWithModel(Model model) {
 * 			Dichiaro una mappa (o me la faccio passare, così come mi posso far passare un oggetto)
 *   Map<String, String> map = new HashMap<>();
 *   		Aggiungo valori alla mappa
 *   map.put("NomeAttributo", "Valore Attributo");
 *   		Dichiaro un attributo da aggiungere al modello, in questo caso indipendente da quello della mappa
 *   model.addAttribute("Messaggio", "Messaggio Da Mostrare");
 *   		Andiamo poi a infilare i valori della mappa nel modello
 *   model.mergeAttributes(map);
 *   return "viewPage.html";
 * }
 * 
 * Nel mio file HTML posso poi leggere i dati passati al modello tramite Thymeleaf
 * I file HTML devono necessariamente essere nella cartella templates sotto src/main/resources, questo è il motivo per cui ho spostato tutto
 * 
 * ESEMPIO 
 * File HTML nell'esempio sopra : viewPage.html:
 * <!DOCTYPE HTML>
 * <html xmlns:th="http://www.thymeleaf.org"> //Si introduce thymeleaf come schema di traduzione degli attributi
 * <head>
 *   <title>Title</title>
 * </head>
 * <body>
 * 			//Qui sotto nel <div> "Parametri passati ecc." è solo un testo. 
 * 			//th:text= "" si comporta come gli attributi html; "th:" è il prefisso necessario
 *    <div>Parametri passati dalla mappa : th:text="${NomeAttributo}"</div>
 *    //${NomeAttributo} deve mostrare una corrispondenza ASSOLUTA con quello dell'entity
 *    //Nell'esempio dell'editor significa che nell'HTML non posso scrivere $"{editor.id} o $"{IdEditor} o ${IDeditor}
 *    <div>Parametri passati dal modello : th:text="${Messaggio}"</div>
 *    // il valore mostrato nella pagina dopo i due punti sarà "Messaggio Da Mostrare"
 * </body>
 * </html>
 * 
 * FILE DA GUARDARE PER VEDERE COME FUNZIONA: AdminEditorPage.html - addEditorPage.html - updateEditorPage.html
 */
@Controller
public class EditorAdminController {
	@Autowired
	private EditorRepository editorRepository; //La repository non ha bisogno di essere cambiata ma non so come introdurre il service
	//SHOW PAGINA LISTA EDITOR
	@GetMapping("/listEditor")
	public String showEditorList(Model model) {
		model.addAttribute("editors", editorRepository.findAll()); //Aggiungo la lista di editors dichiarando attributo editors e riempiendolo con quel che mi torna la repo
		return "AdminEditorPage.html";
	}
	//SHOW PAGINA ADD EDITOR
	@GetMapping("/addEditorPage")
	public String showAddEditorPage(Model model) {
		model.addAttribute("editor",new Editor()); //Aggiungo un singolo Editor fittizio alla pagina per evitare una null reference
		return "addEditorPage.html";
	}
	
	//CREATE
	@PostMapping("/addEditor")
	public String addEditor(@Valid Editor editor, BindingResult result, Model model)
	{
		if(result.hasErrors()) {
			return "addEditorPage.html";		//Se ho errori nella mia funzione di create resto sulla stessa pagina, potrebbe essere necessario rivederlo
		}
		editorRepository.save(editor);
		return "AdminEditorPage.html";
	}
	//SHOW PAGINA UPDATE - 
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Editor editor = editorRepository.findById(id)		//Seleziono l'editor nella repo
				.orElseThrow(()-> new IllegalArgumentException("ID" + id +" non valido"));	//Lancio un eccezione se in qualche modo riesco ad avere un id non valido.
		model.addAttribute("editor", editor);				//Aggiungo il mio editor selezionato al modello 
		return "updateEditorPage.html";						//Vado alla pagina di update
	}
	//UPDATE
	@PostMapping("/update/{id}")
	public String updateEditor(@PathVariable("id") long id, @Valid Editor editor, BindingResult result, Model model) {
		if(result.hasErrors()) {
			editor.setIDEditor(id);				//Resetto l'id per ricaricare la pagina nel caso ci sia un errore durante il load dell'oggetto
			return "updateEditorPage.html";		//Vedi CREATE
		}
		editor.setIDEditor(id);					//Setto l'id dell'editor a quello che mi è stato passato dal mapping per aggiornare quello corretto
		editorRepository.save(editor);			//Salvo l'editor 
		return "AdminEditorPage.html";			//Ritorno alla pagina di listing
	}
	//DELETE
	@GetMapping("/delete/{id}")
	public String deleteEditor(@PathVariable("id")long id, Model model) {
		Editor editor = editorRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("ID" + id + "non valido"));
		editorRepository.delete(editor);		//Vedi update, la navigazione ritorna alla pagina di listing perchè non ho un form da compilare per il delete
		return "AdminEditorPage.html";
	}
}

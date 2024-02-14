package it.hastega.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.hastega.spring.auth.db.pojo.User;
import it.hastega.spring.auth.db.serv.UserService;
import it.hastega.spring.db.pojo.Book;
import it.hastega.spring.db.serv.BookService;

@SpringBootApplication
public class HastegaTestTecnicoBackendApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(HastegaTestTecnicoBackendApplication.class, args);
	}

	public void run(String... args) throws Exception {

		// CREO GLI UTENTI
		User u1 = new User("marco", "busacca", "marcobusacca01@gmail.com");
		User u2 = new User("luca", "frasca", "lucafrasca03@gmail.com");
		User u3 = new User("giovanni", "gallo", "giovannigallo15@gmail.com");
		userService.save(u1);
		userService.save(u2);
		userService.save(u3);

		// CREO I LIBRI
		Book b1 = new Book("Programmare con C", "Antonio Pelleriti",
				"C# è il punto di riferimento della programmazione .NET da quasi vent’anni e rappresenta il linguaggio principe della piattaforma. C#, con .NET Core, è oggi multipiattaforma e consente di sviluppare in modo rapido e produttivo su quasi ogni sistema operativo, e con Xamarin anche su ambienti mobile.\r\n"
						+ //
						"Lo scopo di questo libro è illustrare le basi del linguaggio, quindi la sintassi e i suoi costrutti, applicate al paradigma di programmazione orientato agli oggetti, per poi passare ai concetti avanzati ed esplorare C# e Visual Studio in tutte le loro sfaccettature. Il libro, grazie alla sua completezza, è adatto sia a chi non ha mai programmato e vuole imparare da zero, sia a chi invece proviene da altri linguaggi e vuole cimentarsi nello sviluppo in C# e .NET.",
				0, "B07Z59G9XH", u1);
		Book b2 = new Book("Algoritmi spiegati in modo facile", "Aditya Y. Bhargava",
				"Un algoritmo non è altro che una procedura per risolvere un problema. Gli algoritmi più utilizzati sono già stati testati e verificati ma questo non vuol dire che comprenderne la logica sia facile. Questa guida illustrata aiuta a capirli senza dover faticare su migliaia di pagine di teoria e spiega come applicarli in problemi pratici.\r\n"
						+ //
						"Si inizia dagli algoritmi di ordinamento e ricorsivi e capitolo dopo capitolo si esaminano temi via via più complessi come le tabelle hash, gli algoritmi per la ricerca per grafi, gli algoritmi greedy, la programmazione dinamica e la classificazione di oggetti con KNN. Si arriva infine a introdurre argomenti avanzati come gli alberi di ricerca, la trasformata di Fourier e la programmazione lineare.\r\n"
						+ //
						"Grazie al suo linguaggio semplice e a oltre 400 immagini e diagrammi che accompagnano i singoli passi delle procedure e gli esempi in Python, questo testo è perfetto per programmatori alle prime armi, ingegneri, appassionati di informatica e in generale chiunque voglia avvicinarsi allo studio degli algoritmi.",
				0, "B0BSZ56QQZ", u2);
		Book b3 = new Book("Clean Code", "Robert C. Martin",
				"Un codice cattivo può certo funzionare ma un codice sporco alla lunga può mettere in ginocchio intere organizzazioni. Ogni anno un numero incalcolabile di ore e risorse sono sprecate a causa di codice scritto male. Ma non bisogna rassegnarsi.\r\n"
						+ //
						"Robert C. Martin presenta il suo rivoluzionario approccio agile alla scrittura di codice pulito on the fly, frutto dell'esperienza condivisa con i suoi colleghi di Object Mentor. L'obiettivo è trasmettere i valori di un artigiano del software e mostrare come diventare programmatori migliori distinguendo il buon codice da quello cattivo.\r\n"
						+ //
						"Il volume è idealmente diviso in tre parti. La prima descrive i principi, i modelli e le pratiche per la scrittura di un codice pulito. La seconda presenta casi di studio di complessità crescente: ognuno è un esercizio che mira a trasformare del codice problematico in codice efficiente. La terza, racchiusa in un unico capitolo, raccoglie e sintetizza tutti gli insegnamenti della seconda parte. Il risultato è un corpo di conoscenze comuni a chi scrive, legge e soprattutto rende pulito il codice.\r\n"
						+ //
						"Una lettura fondamentale per ogni sviluppatore, ingegnere informatico, project manager e analista di sistema che vuole produrre codice migliore.",
				0, "B07BSVPHXD", u3);
		bookService.save(b1);
		bookService.save(b2);
		bookService.save(b3);
	}
}

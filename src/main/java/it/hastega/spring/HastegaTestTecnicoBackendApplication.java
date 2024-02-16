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
		User u1 = new User("Marco", "Busacca", "marcobusacca01@gmail.com");
		User u2 = new User("Luca", "Frasca", "lucafrasca03@gmail.com");
		User u3 = new User("Giovanni", "Gallo", "giovannigallo15@gmail.com");
		userService.save(u1);
		userService.save(u2);
		userService.save(u3);

		// LIBRI: USER 1
		Book b1 = new Book("Programmare con C#", "Antonio Pelleriti",
				"C# è il punto di riferimento della programmazione .NET da quasi vent’anni e rappresenta il linguaggio principe della piattaforma. C#, con .NET Core, è oggi multipiattaforma e consente di sviluppare in modo rapido e produttivo su quasi ogni sistema operativo, e con Xamarin anche su ambienti mobile.\r\n"
						+ //
						"Lo scopo di questo libro è illustrare le basi del linguaggio, quindi la sintassi e i suoi costrutti, applicate al paradigma di programmazione orientato agli oggetti, per poi passare ai concetti avanzati ed esplorare C# e Visual Studio in tutte le loro sfaccettature. Il libro, grazie alla sua completezza, è adatto sia a chi non ha mai programmato e vuole imparare da zero, sia a chi invece proviene da altri linguaggi e vuole cimentarsi nello sviluppo in C# e .NET.",
				1, "B07Z59G9XH", u1);

		Book b2 = new Book("Learn Java: A Crash Course Guide to Learn Java in 1 Week", "Timothy C. Needham",
				"Are you ready to program with Java in less than 1 week?\r\n" + //
						"Have you always wanted to learn computer programming but you thought is difficult for you?\r\n"
						+ //
						"Or perhaps you know other programming languages but you are interested in learning the Java language fast?\r\n"
						+ //
						"If the answer is Yes.........then, this book is for you!",
				2,
				"1726643026", u1);

		// LIBRI: USER 2
		Book b3 = new Book("Algoritmi spiegati in modo facile", "Aditya Y. Bhargava",
				"Un algoritmo non è altro che una procedura per risolvere un problema. Gli algoritmi più utilizzati sono già stati testati e verificati ma questo non vuol dire che comprenderne la logica sia facile. Questa guida illustrata aiuta a capirli senza dover faticare su migliaia di pagine di teoria e spiega come applicarli in problemi pratici.\r\n"
						+ //
						"Si inizia dagli algoritmi di ordinamento e ricorsivi e capitolo dopo capitolo si esaminano temi via via più complessi come le tabelle hash, gli algoritmi per la ricerca per grafi, gli algoritmi greedy, la programmazione dinamica e la classificazione di oggetti con KNN. Si arriva infine a introdurre argomenti avanzati come gli alberi di ricerca, la trasformata di Fourier e la programmazione lineare.\r\n"
						+ //
						"Grazie al suo linguaggio semplice e a oltre 400 immagini e diagrammi che accompagnano i singoli passi delle procedure e gli esempi in Python, questo testo è perfetto per programmatori alle prime armi, ingegneri, appassionati di informatica e in generale chiunque voglia avvicinarsi allo studio degli algoritmi.",
				0, "B0BSZ56QQZ", u2);

		Book b4 = new Book("Guida pratica ai microservizi REST in Java Spring Boot",
				"Gianluca Nuscis",
				"Fino a pochi anni fa l’approccio alla programmazione prevedeva la creazione di sistemi monolitici “autocontenuti”, ossia ogni programma assolveva in modo specifico e indipendente ai compiti per cui era stato progettato.\r\n"
						+ //
						"L’orientamento attuale è quello basato su paradigmi che separano la rappresentazione (UI – User Interface) dalla logica di business.\r\n"
						+ //
						"L'approccio a \"Microservizi\" concretizza questo paradigma rendendo lo sviluppo facilmente scalabile.\r\n"
						+ //
						"Questa guida raccoglie in modo organico tutti i passi per sviluppare servizi web utilizzando Java Spring Boot, descrivendo anche come distribuire l'applicazione (sia su SO Linux che Windows), includendo i certificati SSL/TSL per implementare la crittografia. In finale affronta il \"problema\" della tecnologia CORS implementata dai browser per il consumo dei microservizi sviluppati.",
				3, "979-8872113294", u2);

		// LIBRI: USER 3
		Book b5 = new Book("Clean Code", "Robert C. Martin",
				"Un codice cattivo può certo funzionare ma un codice sporco alla lunga può mettere in ginocchio intere organizzazioni. Ogni anno un numero incalcolabile di ore e risorse sono sprecate a causa di codice scritto male. Ma non bisogna rassegnarsi.\r\n"
						+ //
						"Robert C. Martin presenta il suo rivoluzionario approccio agile alla scrittura di codice pulito on the fly, frutto dell'esperienza condivisa con i suoi colleghi di Object Mentor. L'obiettivo è trasmettere i valori di un artigiano del software e mostrare come diventare programmatori migliori distinguendo il buon codice da quello cattivo.\r\n"
						+ //
						"Il volume è idealmente diviso in tre parti. La prima descrive i principi, i modelli e le pratiche per la scrittura di un codice pulito. La seconda presenta casi di studio di complessità crescente: ognuno è un esercizio che mira a trasformare del codice problematico in codice efficiente. La terza, racchiusa in un unico capitolo, raccoglie e sintetizza tutti gli insegnamenti della seconda parte. Il risultato è un corpo di conoscenze comuni a chi scrive, legge e soprattutto rende pulito il codice.\r\n"
						+ //
						"Una lettura fondamentale per ogni sviluppatore, ingegnere informatico, project manager e analista di sistema che vuole produrre codice migliore.",
				2, "B07BSVPHXD", u3);

		Book b6 = new Book("Python da zero: Programmare una rete neurale in 7 giorni", "Benjamin Spahic",
				"Non vi piacerebbe imparare a programmare Pyhton 3 senza alcuna conoscenza precedente?\r\n" + //
						"Nessun problema: con l'aiuto di questa guida per principianti, sarete in grado di comprendere i principi di base della programmazione orientata agli oggetti, con variabili, cicli e classi, in pochissimo tempo.\r\n"
						+ //
						"Questa guida copre le basi della programmazione in Python. Inoltre esempi pratici reali, grafici e piccoli esercizi vi aiuteranno nella comprensione in parallelo.\r\n"
						+ //
						"Con l'aiuto di questa guida per principianti, molti lettori sono rimasti soddisfatti e sono già riusciti a iniziare e ad ampliare le proprie capacità, verificatelo voi stessi!",
				0, "B0BFRY2NQK",
				u3);

		bookService.save(b1);
		bookService.save(b2);
		bookService.save(b3);
		bookService.save(b4);
		bookService.save(b5);
		bookService.save(b6);
	}
}

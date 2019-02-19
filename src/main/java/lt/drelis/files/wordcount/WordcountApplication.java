package lt.drelis.files.wordcount;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WordcountApplication {
/*
	3. Papildomi balai bus skiriami, jei (atlikti nebūtina):
	3.1. Bus paruošta web application, kuri turės GUI interface.
	3.2. Bus panaudotas file upload mechanizmas, bus galima uploadinti N failų.
	3.3. Rezultatai bus pateikiami ir web application GUI.
	3.4. Bus panaudotas software container sprendimas (pvz. Docker).
	
	Reikalavimai pateikiamam rezultatui:
	Užduotį prašytume pateikti el. paštu: jobs@metasite.net .
	Prašome darbo rezultatą patalpinti prieinamoje vietoje peržiūrai (pvz. www.herokuapp.com,
	https://aws.amazon.com/free/ , https://cloud.google.com/free/ , https://azure.microsoft.com/enus/offers/ms-azr-0044p/ ir pan.), 
	
	o source code patalpinti kuriame nors viešajame kodo versijavimo servise (github, bitbucket ar kt.).
	
	*/
	
	public static void main(String[] args) {
		// SpringApplication.run(WordcountApplication.class, args);
		WordSolver solver = new WordSolver();
		
		solver.addFile( "C:/Personal/data.txt" );
		solver.addFile( "C:/Personal/data1.txt" );
		solver.addFile( "C:/Personal/data2.txt" );
		
		solver.solve().forEach( t -> {
			System.out.println("------" + t.name() );
			t.table().keySet().forEach( s -> System.out.println(String.format("%s %s", s, t.table().get(s))));
		});
		
	}

}

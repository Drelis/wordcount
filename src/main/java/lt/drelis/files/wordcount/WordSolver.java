package lt.drelis.files.wordcount;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class WordSolver {
	public static Integer threadCount = 0;
	private WordCounter counter;
	
	public WordSolver (){
		counter = new WordCounter();
		
		counter.addRule(new WordTable ("wordsAG") {
			public boolean accept(String word){
				char first = word.toLowerCase().charAt(0);
				return 'a' <= first && first <= 'g'; 
			}
		});

		counter.addRule(new WordTable ("wordsHN") {
			public boolean accept(String word){
				char first = word.toLowerCase().charAt(0);
				return 'h' <= first && first <= 'n';  
			}
		});

		counter.addRule(new WordTable ("wordsOU") {
			public boolean accept(String word){
				char first = word.toLowerCase().charAt(0);
				return 'o' <= first && first <= 'u';  
			}
		});

		counter.addRule(new WordTable ("wordsVZ") {
			public boolean accept(String word){
				char first = word.toLowerCase().charAt(0);
				return 'v' <= first && first <= 'z';  
			}
		});
	}
	
	public void addFile(File file) {
		new Thread(() -> processFile( counter, file )).start();
	}
	
	public void addFile(String name) {
		addFile(new File (name));
	}
	
	public List<WordTable> solve() {
		do {
			try {
				Thread.sleep(200);
			} catch (InterruptedException ex) {
			}
		} while(threadCount != 0);
		
		return counter.state();
	}

	private static void processFile(WordCounter counter, File file) {
		threadCount++;
		try {
			
			Scanner sc = new Scanner(file);
			while (sc.hasNext()) {
				counter.addWord(sc.next());
			}
			sc.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			threadCount--;
		}
	}

}

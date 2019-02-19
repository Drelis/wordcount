package lt.drelis.files.wordcount;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

public class WordCounter {
	private static Integer ONE = Integer.valueOf(1);
	
	private List<WordTable> body = new ArrayList<>();  
	
	public void addRule(WordTable rule) {
		body.add(rule);
	}
	
	public void addWord (String word) {
		body.stream().filter( t -> t.accept(word)).forEach(	t -> addWordToTable(t.table(), word) ) ;
	}
	
	public List<WordTable> state() {
		return body;
	}

	private static void addWordToTable(Hashtable<String, Integer> table, String word) {
		synchronized (table) {
			Integer cnt = table.get(word);
			table.put(word, cnt == null ? ONE : cnt + 1);
		}
	}
}

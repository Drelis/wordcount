package lt.drelis.files.wordcount;

import java.util.Hashtable;

public abstract class WordTable {
	private Hashtable<String, Integer> body;
	private String name;
	
	public WordTable (String name) {
		if ( name == null || name.length() == 0)
			throw new IllegalArgumentException( "Word for table is invalid" );
		this.name = name;
	}
	
	public abstract boolean accept(String word);
	
	public Hashtable<String, Integer> table () {
		if ( body == null) {
			body = new Hashtable<>();
		}
		return body;
	}
	
	public String name() {
		return this.name;
	}
	
}

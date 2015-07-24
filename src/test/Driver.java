package test;

import java.util.Iterator;
import java.util.Set;

public class Driver {
<<<<<<< HEAD
	public static void main(String[] args) {
		Scrabble scrabble = new Scrabble();
		String word = "piedz";
=======
	public static void main(String[] arguments) {
		ScrabbleWordHelper scrabble = new ScrabbleWordHelper();
		String word = "_a_";
>>>>>>> f69a5bc2ae3ead4d12af38a80fdbf47af4b09ba2

		Set<String> words = scrabble.findMaximumScoreWords(word.toCharArray());

		Iterator<String> it = words.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}

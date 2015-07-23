package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class Driver {
	public static void main(String[] args) {
		Scrabble scrabble = new Scrabble();
		String word = "_a_";

		Set<String> words = scrabble.findMaximumScoreWords(word.toCharArray());

		Iterator<String> it = words.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}

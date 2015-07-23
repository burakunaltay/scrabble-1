package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.junit.Test;

public class ScrabbleTest {

	@Test
	public void scrabbleTest() {
		Scrabble scrabble = new Scrabble();
		String letters = "dreamz";
		String word = "";
		Set<String> words = scrabble.findMaximumScoreWords(letters.toCharArray());
		Iterator<String> iterator = words.iterator();
		while (iterator.hasNext()) {
			word = iterator.next();
		}
		assertEquals("Correct", "mazed", word);
	}
	
	@Test
	public void scrabbleWithBlankTilesTest() {
		String [] outputValues ={"amazed","mazard","mazed"};
		Scrabble scrabble = new Scrabble();
		String letters = "dreamz_";
		String word = "";
		int i=0;

		Set<String> words = scrabble.findMaximumScoreWords(letters.toCharArray());
		Iterator<String> iterator = words.iterator();
		while (iterator.hasNext()) {
			word = iterator.next();
			assertEquals("Correct", outputValues[i++], word);
		}
	}
	@Test
	public void anagramTest() {
		String[] outputValues={"AB","AC","BA","BC","CA","CB"};
		String letters ="abc";
		String word = "";
		int i=0;
		
		AnagramGenerator anagramGenerator=new AnagramGenerator(2,letters.toCharArray());
		ArrayList<String> words = anagramGenerator.findWords();
		Iterator<String> iterator=words.iterator();
		while(iterator.hasNext()){
			word = iterator.next();
			assertEquals("Correct", outputValues[i++], word);
		}
	}
	

}

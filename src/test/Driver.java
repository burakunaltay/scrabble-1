package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;


public class Driver {
	public static void main(String[] args) {
		Scrabble scrabble=new Scrabble();
		String word="dream_";
		
		Set<String> words=scrabble.findMaximumScoreWords(word.toCharArray());
		
		Iterator<String> it=words.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}

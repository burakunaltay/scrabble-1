package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;


public class Driver {
	public static void main(String[] args) {
		Scrabble wordScorer=new Scrabble();
		String word="a_t_tyj";
		Set<String> words=wordScorer.findMaximumScoreWord(word.toCharArray());
		Iterator<String> it=words.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}

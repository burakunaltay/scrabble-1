package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Scrabble {
	private static final Character INITIAL_CHARACTER = 'A';
	
	Set<String> wordsWithMaximumScore;
	private int maxScore;
	Map<String, Integer> dictionary;

	public Scrabble() {
		wordsWithMaximumScore = new HashSet<String>();
		maxScore = Integer.MIN_VALUE;
		dictionary = createDictionary();
	}

	public Set<String> findMaximumScoreWords(char[] letters) {

		for (int i = letters.length; i >= 1; i--) {
			ArrayList<String> words = generateAnagram(letters, i);

			Iterator<String> it = words.iterator();
			while (it.hasNext()) {
				String word = it.next();
				if (isValidWord(word)) {
					int score=dictionary.get(word.toUpperCase());
					updateMaximumScore(word, score);
				}
			}
		}
		return wordsWithMaximumScore;
	}
	public Integer getMaximumScore(){
		return maxScore;
	}
	private ArrayList<String> generateAnagram(char[] letters,
			int numberOfLetters) {
		return (new AnagramGenerator(numberOfLetters, letters)).findWords();
	}

	private Map<String, Integer> createDictionary() {
		Map<String, Integer> dictionary = new HashMap<String, Integer>();
		File file = new File(ScrabbleProperties.DICTIONARY_PATH);
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader(file));
			String word;
			
			while ((word = reader.readLine()) != null) {
				dictionary.put(word.toUpperCase(), calculateScore(word.toUpperCase()));
			}
			
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dictionary;
	}

	private boolean isValidWord(String word) {
		return dictionary.containsKey(word.toUpperCase());
	}

	private int calculateScore(String word) {
		int eachCharacterScore[] = { 1, 2, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1,
				1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 };
		int score = 0;
		char[] characterArray = word.toCharArray();

		for (int i = 0; i < characterArray.length; i++) {
			if (Character.isLowerCase(characterArray[i])) {
				continue;
			}
			
			score += eachCharacterScore[Character
					.toUpperCase(characterArray[i]) - INITIAL_CHARACTER];
		}
		
		return score;
	}

	private void updateMaximumScore(String word, int score) {
		if (score == maxScore) {
			wordsWithMaximumScore.add(word.toLowerCase());
		} else if (score > maxScore) {
			maxScore = score;
			wordsWithMaximumScore = new HashSet<String>();
			wordsWithMaximumScore.add(word.toLowerCase());
		}
	}
}

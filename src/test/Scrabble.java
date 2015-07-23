package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Scrabble {
	private static final Character INITIAL_CHARACTER = 'A';
	
	Set<String> maximumScoreWords;
	private int maxScore;
	Set<String> dictionary;

	public Scrabble() {
		maximumScoreWords = new HashSet<String>();
		maxScore = Integer.MIN_VALUE;
		dictionary = createHashedDictionary();
	}

	public Set<String> findMaximumScoreWords(char[] letters) {

		for (int i = letters.length; i >= 1; i--) {
			ArrayList<String> words = generateAnagram(letters, i);

			Iterator<String> it = words.iterator();
			while (it.hasNext()) {
				String word = it.next();
				if (isValidWord(word)) {
					int score = calculateScore(word);
					updateMaximumScore(word, score);
				}
			}
		}
		return maximumScoreWords;
	}

	private ArrayList<String> generateAnagram(char[] letters,
			int numberOfLetters) {
		return (new AnagramGenerator(numberOfLetters, letters)).findWords();
	}

	private Set<String> createHashedDictionary() {
		Set<String> dictionary = new HashSet<String>();
		File file = new File(ScrabbleProperties.DICTIONARY_PATH);
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader(file));
			String word;
			
			while ((word = reader.readLine()) != null) {
				dictionary.add(word.toLowerCase());
			}
			
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dictionary;
	}

	private boolean isValidWord(String word) {
		return dictionary.contains(word.toLowerCase());
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
			maximumScoreWords.add(word.toLowerCase());
		} else if (score > maxScore) {
			maxScore = score;
			maximumScoreWords = new HashSet<String>();
			maximumScoreWords.add(word.toLowerCase());
		}
	}
}

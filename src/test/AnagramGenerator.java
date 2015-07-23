package test;

import java.util.ArrayList;

public class AnagramGenerator {
	private static final Character START_LETTER = 'a';
	private ArrayList<String> listOfWords;
	private char[] letters;
	private char[] word;
	private int numberOfLetters;
	private boolean[] usedLetters;

	public AnagramGenerator(int numberOfLetters, char[] letters) {
		this.numberOfLetters = numberOfLetters;
		this.letters = letters;

		usedLetters = new boolean[letters.length];
		for (int i = 0; i < numberOfLetters; i++) {
			usedLetters[i] = false;
		}

		convertToUpperCase(letters);
		
		word = new char[numberOfLetters];
		listOfWords = new ArrayList<String>();
	}

	private void convertToUpperCase(char[] letters) {
		for (int i = 0; i < letters.length; i++) {
			letters[i] = Character.toUpperCase(letters[i]);
		}
	}

	public ArrayList<String> findWords() {
		generateWords(0);
		return listOfWords;
	}

	private void generateWords(int index) {
		if (index == numberOfLetters) {
			listOfWords.add(convertCharacterArrayToString(word));
			return;
		}
		for (int i = 0; i < letters.length; i++) {
			if (usedLetters[i]) {
				continue;
			}
			usedLetters[i] = true;

			if (letters[i] == '_') {
				for (int j = 0; j < 26; j++) {
					word[index] = (char) (START_LETTER + j);
					generateWords(index + 1);
				}
			} else {
				word[index] = letters[i];
				generateWords(index + 1);
			}
			usedLetters[i] = false;
		}
	}

	private String convertCharacterArrayToString(char[] word) {
		return String.valueOf(word);
	}
}

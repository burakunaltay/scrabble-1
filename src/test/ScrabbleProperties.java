package test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ScrabbleProperties {
	public static String DICTIONARY_PATH;
	static {
		Properties properties = new Properties();
		InputStream input;
		try {
			input = new FileInputStream("scr.properties");
			properties.load(input);
			DICTIONARY_PATH = properties.getProperty("dictionaryPath");
		} catch (Exception e) {
			System.out.println("Could not load properties.");
		}
	}

}

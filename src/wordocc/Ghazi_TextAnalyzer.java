package wordocc;

//Author Name: Mehrdad Ghazi
//Date: 5/28/2022
//Program Name: Ghazi_TextAnalyzer
//Purpose: Analyze text from file and output most repeated words with their count. I created a text file
//         for the entire Macbeth play which will be the file I am reading from.

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * This class creates a word map based on a txt file that is read into the program with each occurrence of a word increasing
 * the key associated with each value
 * @author Mehrdad Ghazi
 * @version 1.0
 */
public class Ghazi_TextAnalyzer {

	public static void main(String[] args) {

		// create map and list to sort results
		Map<String, Integer> wordMap = buildWordMap("src/macbeth.txt");
		List<Entry<String, Integer>> list = sortByValueInDescendingOrder(wordMap);

		// print results of all words
		System.out.println("List of all words from file and their count in descending order");
		for (Map.Entry<String, Integer> entry : list) {
				System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}
/**
 * The buildWordMap method splits the lines in the txt file by spaces and separates each word and then adds it to the HashMap
 * @param fileName the text file you want the word map to be created from
 * @return returns a HashMap with each word becoming a value with an associated key that correlates to the amount of times that word was found
 */
	public static Map<String, Integer> buildWordMap(String fileName) {
		// create wordMap
		Map<String, Integer> wordMap = new HashMap<>();
		// read file
		try (FileInputStream fis = new FileInputStream(fileName);
				DataInputStream dis = new DataInputStream(fis);
				BufferedReader br = new BufferedReader(new InputStreamReader(dis))) {
			//split strings by spaces since words are separated by spaces
			Pattern pattern = Pattern.compile("\\s+");
			String line = null;
			while ((line = br.readLine()) != null) {
				// case sensitivity does not matter so we'll turn it all to lower case
				line = line.toLowerCase();
				String[] words = pattern.split(line);
				// loop to count occurrences. If the word is there already, increase the count.
				// if not, add the word to the map
				for (String word : words) {
					if (wordMap.containsKey(word)) {
						wordMap.put(word, (wordMap.get(word) + 1));
					} else {
						wordMap.put(word, 1);
					}
				}
			}

		} catch (IOException ioex) {
			ioex.printStackTrace();
		}
		return wordMap;
	}
	/**
	 * This method reads in a Map and returns a list that is sorted by the key in the Map
	 * @param wordMap the wordMap you want sorted
	 * @return returns a list with values from a HashMap sorted by the values with the highest keys
	 */
	public static List<Entry<String, Integer>> sortByValueInDescendingOrder(Map<String, Integer> wordMap) {
		//sort occurrences by highest value
		
		Set<Entry<String, Integer>> entries = wordMap.entrySet();
		//create list
		List<Entry<String, Integer>> list = new ArrayList<>(entries);
		//sort list
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 ) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});
		return list;
	}
}

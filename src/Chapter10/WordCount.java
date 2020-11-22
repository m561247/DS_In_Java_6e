package Chapter10;

import java.util.Scanner;

import Chapter9.Entry;
import net.datastructures.ChainHashMap;

public class WordCount {
//	public static void main(String[] args) {
//		Map<String, Integer> freq = new ChainHashMap<>(); // or any concrete map
//		// scan input for words, using all nonletters as delimiters
//		Scanner doc = new Scanner(System.in).useDelimiter("[^a-zA-Z]+");
//		while (doc.hasNext()) {
//			String word = doc.next().toLowerCase();
//			Integer count = freq.get(word);
//			if (count == null) {
//				count = 0;
//			}
//			freq.put(word, 1 + count);
//		}
//		int maxCount = 0;
//		String maxWord = "no word";
//		for (Entry<String, Integer> ent : freq.entrySet()) {
//			if (ent.getValue() > maxCount) {
//				maxWord = ent.getKey();
//				maxCount = ent.getValue();
//			}
//		}
//		System.out.println("The most frequent word is '" + maxWord);
//		System.out.println("' with " + maxCount + " occurrences."); 
//	}
	public static void main(String[] args) {
		Scanner doc = new Scanner(System.in).useDelimiter("[^a-zA-Z]+");
		while (doc.hasNext()) {
			String word = doc.next().toLowerCase();
			System.out.println(word);
		}
	} 
}

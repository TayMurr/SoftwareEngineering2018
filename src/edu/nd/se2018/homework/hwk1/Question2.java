package edu.nd.se2018.homework.hwk1;

import java.util.HashMap;
import java.util.HashSet;

public class Question2 {

	public Question2(){}
	
	public String getMostFrequentWord(String input, String stopwords){
		
		HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
		String[] strings = input.split(" ");
		
		for (String substring: strings) {
			if (!stopwords.contains(substring)) { 
				if (wordCount.containsKey(substring)) {
					wordCount.put(substring, wordCount.get(substring) + 1);
				} else {
					wordCount.put(substring, 1);
				}
			}
		}
		
		int max = 0;
		String mostFrequent = "";
		for (String key: wordCount.keySet()) {
			int amt = wordCount.get(key);
			if (amt > max) {
				mostFrequent = key;
				max = amt;
			} else if (amt == max) {
				mostFrequent = null;
			}
		}

		return mostFrequent;
	}
}

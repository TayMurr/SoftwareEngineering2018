package edu.nd.se2018.homework.hwk1;

import java.util.HashSet;

public class Question1 {
		
	public Question1(){}
	
	public int getSumWithoutDuplicates(int[] numbers){
		int total = 0;
		HashSet<Integer> hashset = new HashSet<Integer>();
		
		for (int num : numbers) {
			if (!hashset.contains(num)) {
				total+=num;
				hashset.add(num);
			}
		}
		return total;	
	}
}

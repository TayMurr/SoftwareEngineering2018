package edu.nd.se2018.homework.hwk1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question3 {
	
	public Question3(){}	
	
    public int getMirrorCount(int[] numbers){
    	int maxMirrorCount = 0;
    	int sz = 0;
    	int tempCount = 0;
        
    	sz = numbers.length;
    	if (sz == 0) {
    		return 0;
    	}
    	
    	int [] numberReverse = reverse(Arrays.copyOf(numbers, sz));

    	for (int i = 0; i < sz; i++) {
    		if (numbers[i] == numberReverse[i]) {
    			tempCount++;
    		} else {


    			maxMirrorCount = (tempCount > maxMirrorCount) ? tempCount : maxMirrorCount;
    			tempCount = 0;
    		}
    	}
		maxMirrorCount = (tempCount > maxMirrorCount) ? tempCount : maxMirrorCount;

		return maxMirrorCount;	
    }
    
    public int[] reverse(int[] arr) {
    	int temp;
    	for (int i = 0; i < arr.length / 2; i++) {
    		temp = arr[arr.length - 1 - i];
    		arr[arr.length - 1 - i] = arr[i];
    		arr[i] = temp;
    	}
    	return arr;
    }
    
}

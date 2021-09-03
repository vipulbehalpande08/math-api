package com.sojern.exercise.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sojern.exercise.exception.ListIsEmptyException;

@Service
public class MathAPIServiceImpl implements MathAPIService{

	@Override
	public List<Integer> calculateMin(List<Integer> numberList, int quantifier) {
		List<Integer> minNumbers = null;
		try {
			// if list is empty return -1
			if(numberList == null || quantifier == 0 || numberList.isEmpty())
				throw new ListIsEmptyException("List should not be null or Empty");
			// Sort the list in ascending order
			minNumbers = new ArrayList<Integer>();
			Collections.sort(numberList);
			// loop to return requested min number(s)
			for(int i = 0; i < quantifier; i++) {
				minNumbers.add(numberList.get(i));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return minNumbers;
	}

	@Override
	public List<Integer> calculateMax(List<Integer> numberList, int quantifier) {
		List<Integer> maxNumbers = null;
		try {
			// if list is empty return -1
			if(numberList == null || quantifier == 0 || numberList.isEmpty())
				throw new ListIsEmptyException("List should not be null or Empty");
			// Sort the list
			maxNumbers = new ArrayList<Integer>();
			//Sort the list in descending order
			Collections.sort(numberList, Collections.reverseOrder());
			// loop to return requested max number(s)
			for(int i = 0; i < quantifier; i++) {
				maxNumbers.add(numberList.get(i));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return maxNumbers;
	}

	@Override
	public int calculateAvg(List<Integer> numberList) {
		// if decimal numbers are needed we can use double instead int
		Integer avg = 0;
		// if list is empty return -1
		try {
			if(numberList == null || numberList.isEmpty())
				throw new ListIsEmptyException("List should not be null or Empty");
			// loop to add all numbers of list
			for (Integer i: numberList ) {
				avg += i;
			}
			avg =  avg / numberList.size();
			
			//it can also be done using java 8 streams
//			OptionalDouble average = numberList.stream().mapToDouble( number -> number).average();
//			return (average.isPresent() ? average.getAsDouble() : 0);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return avg;
	}

	@Override
	public double calculateMedian(List<Integer> numberList) {
		// if list is empty return -1
		double median = 0.0;
		try {
			if(numberList == null || numberList.isEmpty())
				throw new ListIsEmptyException("List should not be null or Empty");
			Collections.sort(numberList);
			int length = numberList.size();
			if( length % 2 != 0) {
				median =  (double)numberList.get(length/2);
			}
			else {
				median = (double) (numberList.get((length -1)/2) + numberList.get(length/2)) / 2.0;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return median;
	}

	@Override
	public int calculatePercentile(List<Integer> numberList, int quantifier) {
		int index = -1;
		try {
			if(numberList == null || numberList.isEmpty())
				throw new ListIsEmptyException("List should not be null or Empty");
			Collections.sort(numberList);
			index  = (int) Math.ceil((float)quantifier/100 * numberList.size());	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return numberList.get(index -1);
	}

}

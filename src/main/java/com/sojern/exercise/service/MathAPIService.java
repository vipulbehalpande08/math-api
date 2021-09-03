package com.sojern.exercise.service;

import java.util.List;

public interface MathAPIService {

	public List<Integer> calculateMin(List<Integer> numberList, int quantifier);
	public List<Integer> calculateMax(List<Integer> numberList, int quantifier);
	public int calculateAvg(List<Integer> numberList);
	public double calculateMedian(List<Integer> numberList);
	public int calculatePercentile(List<Integer> numberList, int quantifier);
}

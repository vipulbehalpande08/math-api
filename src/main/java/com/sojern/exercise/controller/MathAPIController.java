package com.sojern.exercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sojern.exercise.service.MathAPIService;

@RestController
public class MathAPIController {

	@Autowired
	private MathAPIService mathApiService;
	
	@GetMapping(path = "min")
	@ResponseBody
	public List<Integer> getMin(@RequestParam(required = true) List<Integer> numbers, @RequestParam int quantifier) {
		return mathApiService.calculateMin(numbers, quantifier);
	}
	@GetMapping(path = "max")
	@ResponseBody
	public List<Integer> getMax(@RequestParam(required = true) List<Integer> numbers, @RequestParam int quantifier) {
		return mathApiService.calculateMax(numbers, quantifier);
	}
	@GetMapping(path = "avg")
	@ResponseBody
	public int getAvg(@RequestParam(required = true) List<Integer> numbers) {
		return mathApiService.calculateAvg(numbers);
	}
	@GetMapping(path = "median")
	@ResponseBody
	public double getMedian(@RequestParam(required = true) List<Integer> numbers) {
		return mathApiService.calculateMedian(numbers);
	}
	@GetMapping(path = "percentile")
	@ResponseBody
	public int getQthPercentile(@RequestParam(required = true) List<Integer> numbers,@RequestParam int quantifier) {
		return mathApiService.calculatePercentile(numbers, quantifier);
	}
}

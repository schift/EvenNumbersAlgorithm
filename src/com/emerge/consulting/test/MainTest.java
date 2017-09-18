package com.emerge.consulting.test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.emerge.consulting.Main;

public class MainTest {

	@Test
	public void wrongFirstInputDataValidationError() {
		Main main = new Main();
		List<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(8);
		assertEquals(false, main.doInputValuesValidation(0, list));
	}
	
	@Test
	public void wrongSecondInputDataValidationError() {
		Main main = new Main();
		List<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(1001);
		assertEquals(false, main.doInputValuesValidation(0, list));
	}

	@Test
	public void correctInputDataValidationOk() {
		Main main = new Main();
		List<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(8);
		assertEquals(true, main.doInputValuesValidation(2, list));
	}
	
	@Test
	public void calculateInputDataShouldReturn18Value() {
		Main main = new Main();
		int sumOfValues = 23;
		List<Integer> list = new ArrayList<Integer>();
		list.add(6);
		list.add(5);
		list.add(5);
		list.add(5);
		list.add(2);
		Object[] result = main.findMaxValueOfElements(sumOfValues, list);
		assertEquals(18, result[0]);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void calculateInputDataShouldReturnResultForUnfortunatelyValue() {
		Main main = new Main();
		int sumOfValues = 1;
		List<Integer> list = new ArrayList<Integer>();
		list.add(7);
		Object[] result = main.findMaxValueOfElements(sumOfValues, list);
		assertEquals(0, ((ArrayList<Integer>)result[1]).size());
	}
}

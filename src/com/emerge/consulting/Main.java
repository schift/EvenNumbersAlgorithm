package com.emerge.consulting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	private final static String VALIDATION_ERROR = "Please enter valid input data and try again";
	private final static Main main = new Main();

	public static void main(String[] args) {

		System.out.print("Please input number of notes: ");
		Scanner scanner = new Scanner(System.in);
		List<Integer> nominalValuesList = new ArrayList<Integer>();;
		int iNotesAmount = -1;
		
		try {
			iNotesAmount = Integer.parseInt(scanner.nextLine().trim());

			System.out.print("Please enter nominal values: ");
			while (scanner.hasNextInt()) {
				nominalValuesList.add(scanner.nextInt());
				if (nominalValuesList.size() == iNotesAmount) {
					break;
				}
			}
		} catch (NumberFormatException nfe) {
			main.doPrintErrorMessageAndExit();
		} finally {
			scanner.close();
		}

		if (!main.doInputValuesValidation(iNotesAmount, nominalValuesList)) {
			main.doPrintErrorMessageAndExit();
		}

		main.printResult(iNotesAmount, nominalValuesList, true);
		main.doInputValuesValidation(iNotesAmount, nominalValuesList);
		main.findSolution(iNotesAmount, nominalValuesList);
	}

	@SuppressWarnings("unchecked")
	private void findSolution(int pNotesAmount, List<Integer> pNominalValuesList) {
		
		int sumOfAllValuesFromList = 0;
		// sort integers desc
		Collections.sort(pNominalValuesList);

		// sum values inside list
		for (int i = 0; i < pNominalValuesList.size(); i++)
			sumOfAllValuesFromList += pNominalValuesList.get(i);

		if (checkWhetherValueIsEvenNumber(sumOfAllValuesFromList)) {
			printResult(pNotesAmount, pNominalValuesList, false);
		} else {
			Object[] result = findMaxValueOfElements(sumOfAllValuesFromList, pNominalValuesList);
			printResult((int) result[0], (List<Integer>) result[1], false);
		}
	}

	public Object[] findMaxValueOfElements(int pSumOfAllValuesFromList, List<Integer> pNominalValuesList) {
		int currentIndex = 0;
		int item = pNominalValuesList.get(currentIndex);
		int currentSumOfAllValues = pSumOfAllValuesFromList - item;
		while (!checkWhetherValueIsEvenNumber(currentSumOfAllValues)) {
			int currentItem = pNominalValuesList.get(++currentIndex);
			if (currentItem == item) {
				continue;
			}
			currentSumOfAllValues = pSumOfAllValuesFromList - currentItem;
		}
		pNominalValuesList.remove(currentIndex);
		Collections.reverse(pNominalValuesList);
		return new Object[] { currentSumOfAllValues, pNominalValuesList };
	}

	private void printResult(int outputAmountOfNotes, List<Integer> outputNominalValuesList, boolean isInput) {
		if (isInput) {
			System.out.println("-----------------------------------");
			System.out.print("Input data: \n");
		} else {
			System.out.print("Output data: \n");
		}
		if (outputNominalValuesList.size() == 0) {
			System.out.println("UNFORTUNATELY");
			System.out.println("-----------------------------------");
		} else {
			System.out.println("max amount of pocket money: " + outputAmountOfNotes);
			System.out.println("nominal values: " + Arrays.toString(outputNominalValuesList.toArray()));
			System.out.println("-----------------------------------");
		}
	}

	private boolean checkWhetherValueIsEvenNumber(int val) {
		return (val % 2) == 0;
	}

	public boolean doInputValuesValidation(int pAmountOfNotes, List<Integer> pNominalValuesList) {
		// N (1 <= N <= 1 000 000)
		if (1 > pAmountOfNotes || pAmountOfNotes > 1000000) {
			return false;
		}

		if (pNominalValuesList == null) {
			return false;
		}

		// a1, a2, a3 ... aN (1 <= ai <= 1000)
		for (Integer item : pNominalValuesList) {
			if (1 > item || item > 1000) {
				return false;
			}
		}
		return true;
	}

	private void doPrintErrorMessageAndExit() {
		System.out.println(VALIDATION_ERROR);
		System.exit(1);
	}
}

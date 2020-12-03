package com.ellisvlad.aoc2020.day1;

import java.io.BufferedReader;
import java.util.HashSet;
import java.util.Set;

import com.ellisvlad.aoc2020.DayChallenge;

public class ChallengeMain extends DayChallenge {

	@Override
	public void runChallenge(BufferedReader input) throws Exception {
		Set<Integer> values = new HashSet<>();

		String line;
		while ((line = input.readLine()) != null) {
			values.add(Integer.parseInt(line));
		}

		printPartOutput(1, String.valueOf(findProductOf2020SumPair(values)));
		printPartOutput(2, String.valueOf(findProductOf2020SumTriple(values)));
	}

	@Override
	protected int getPartCount() {
		return 2;
	}

	private int findProductOf2020SumPair(Set<Integer> values) {
		for (int value1 : values) {
			for (int value2 : values) {
				if (value1 + value2 == 2020) {
					return value1 * value2;
				}
			}
		}

		throw new RuntimeException("No two values sum to equal 2020!");
	}

	private int findProductOf2020SumTriple(Set<Integer> values) {
		for (int value1 : values) {
			for (int value2 : values) {
				for (int value3 : values) {
					if (value1 + value2 + value3 == 2020) {
						return value1 * value2 * value3;
					}
				}
			}
		}

		throw new RuntimeException("No three values sum to equal 2020!");
	}

}

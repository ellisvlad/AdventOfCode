package com.ellisvlad.aoc2020.day5;

import java.io.BufferedReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import com.ellisvlad.aoc2020.DayChallenge;

public class ChallengeMain extends DayChallenge {

	@Override
	public void runChallenge(BufferedReader input) throws Exception {
		Set<String> values = new HashSet<>();

		String line;
		while ((line = input.readLine()) != null) {
			values.add(line);
		}

		TreeSet<Integer> seatIds = new TreeSet<>();
		for (String value : values) {
			String rowReplaced = value
				.replaceAll("F", "0")
				.replaceAll("B", "1");

			String colReplaced = rowReplaced
				.replaceAll("L", "0")
				.replaceAll("R", "1");

			int seatId = Integer.parseInt(colReplaced, 2);

			seatIds.add(seatId);
		}

		int mySeat = 0;
		for (Integer seatId = seatIds.higher(seatIds.first());
				seatId != null;
				seatId = seatIds.higher(seatId)) {

			if (seatId - seatIds.lower(seatId) == 2) {
				mySeat = seatId - 1;
			}
		}

		printPartOutput(1, String.valueOf(seatIds.last()));
		printPartOutput(2, String.valueOf(mySeat));
	}

	@Override
	protected int getPartCount() {
		return 2;
	}

}

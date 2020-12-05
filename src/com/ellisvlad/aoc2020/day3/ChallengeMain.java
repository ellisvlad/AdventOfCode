package com.ellisvlad.aoc2020.day3;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ellisvlad.aoc2020.DayChallenge;

public class ChallengeMain extends DayChallenge {
	
	private List<String> rows;

	@Override
	public void runChallenge(BufferedReader input) throws Exception {
		rows = new ArrayList<String>();

		String line;
		while ((line = input.readLine()) != null) {
			rows.add(line);
		}

		long[] hitTrees = new long[] {
			countHitTrees(1, 1),
			countHitTrees(3, 1),
			countHitTrees(5, 1),
			countHitTrees(7, 1),
			countHitTrees(1, 2)
		};
		long hitSum = Arrays.stream(hitTrees).reduce(1, (a, b) -> a * b);

		printPartOutput(1, String.valueOf(hitTrees[1]));
		printPartOutput(2, String.valueOf(hitSum));
	}

	@Override
	protected int getPartCount() {
		return 2;
	}

	private int countHitTrees(int slopeX, int slopeY) {
		int hitTrees = 0;
		int curX = 0;
		int curY = 0;

		while (curY < rows.size()) {
			String row = rows.get(curY); 
			if (row.charAt(curX % row.length()) =='#') {
				hitTrees++;
			}
			curX += slopeX;
			curY += slopeY;
		}

		return hitTrees;
	}

}

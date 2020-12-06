package com.ellisvlad.aoc2020.day6;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.ellisvlad.aoc2020.DayChallenge;

public class ChallengeMain extends DayChallenge {

	@Override
	public void runChallenge(BufferedReader input) throws Exception {
		List<Set<String>> groupAnswers = new ArrayList<>();
		Set<String> answersBuilder = new HashSet<>();
		while (true) {
			String line = input.readLine();
			if (line == null || line.trim().length() == 0) {
				// End of group answers
				groupAnswers.add(answersBuilder);
				answersBuilder = new HashSet<>();

				if (line == null) break;
			} else {
				// Group answers continues
				answersBuilder.add(line);
			}
		}

		int sumGroupUniqueAnswers = groupAnswers.stream()
			.map(group -> group.stream().reduce(
				new HashSet<Character>(),
				(set, line) -> {
					for (char ch : line.toCharArray()) {
						set.add(ch);
					}
					return set;
				},
				(a, b) -> {a.addAll(b); return a;}))
			.map(Set::size)
			.reduce(0, (a, b) -> a + b);

		int sumGroupCommonAnswers = groupAnswers.stream()
				.map(group -> group.stream().reduce(
					IntStream.rangeClosed('a', 'z').mapToObj(c -> (char) c).collect(Collectors.toSet()),
					(set, line) -> {
						Set<Character> lineSet = new HashSet<Character>();
						for (char ch : line.toCharArray()) {
							lineSet.add(ch);
						}
						set.retainAll(lineSet);
						return set;
					},
					(a, b) -> {a.retainAll(b); return a;}))
				.map(Set::size)
				.reduce(0, (a, b) -> a + b);

		printPartOutput(1, String.valueOf(sumGroupUniqueAnswers));
		printPartOutput(2, String.valueOf(sumGroupCommonAnswers));
	}

	@Override
	protected int getPartCount() {
		return 2;
	}

}

package com.ellisvlad.aoc2020.day2;

import java.io.BufferedReader;
import java.util.Optional;

import com.ellisvlad.aoc2020.DayChallenge;

public class ChallengeMain extends DayChallenge {

	@Override
	public void runChallenge(BufferedReader input) throws Exception {
		int validPasswords = 0;

		String line;
		while ((line = input.readLine()) != null) {
			Optional<PasswordChecker> checker = PasswordChecker.parse(line);
			if (!checker.isPresent()) {
				throw new RuntimeException("Invalid line of input: " + line);
			}

			if (checker.get().validate()) validPasswords++;
		}

		printPartOutput(1, String.valueOf(validPasswords));
		printPartOutput(2, "-");
	}

	@Override
	protected int getPartCount() {
		return 2;
	}

}

package com.ellisvlad.aoc2020.day4;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.ellisvlad.aoc2020.DayChallenge;
import com.ellisvlad.aoc2020.day4.validators.BirthYearValidator;
import com.ellisvlad.aoc2020.day4.validators.ExpirationYearValidator;
import com.ellisvlad.aoc2020.day4.validators.EyeColorValidator;
import com.ellisvlad.aoc2020.day4.validators.HairColorValidator;
import com.ellisvlad.aoc2020.day4.validators.HeightValidator;
import com.ellisvlad.aoc2020.day4.validators.IssueYearValidator;
import com.ellisvlad.aoc2020.day4.validators.PassportIdValidator;
import com.ellisvlad.aoc2020.day4.validators.types.GenericValidator;

public class ChallengeMain extends DayChallenge {

	private static GenericValidator[] validators = new GenericValidator[] {
		new BirthYearValidator(),
		new IssueYearValidator(),
		new ExpirationYearValidator(),
		new HeightValidator(),
		new HairColorValidator(),
		new EyeColorValidator(),
		new PassportIdValidator()
	};

	@Override
	public void runChallenge(BufferedReader input) throws Exception {
		Set<Map<String, String>> passportParts = new HashSet<>();
		Map<String, String> passportBuilder = new HashMap<>();
		while (true) {
			String line = input.readLine();
			if (line == null || line.trim().length() == 0) {
				// End of passport
				passportParts.add(passportBuilder);
				passportBuilder = new HashMap<>();

				if (line == null) break;
			} else {
				// Passport continues
				for (String part : line.split(" ")) {
					int splitIdx = part.indexOf(':');
					if (splitIdx == -1) throw new RuntimeException("Passport part looks invalid: " + part);
					String key = part.substring(0, splitIdx);
					String value = part.substring(splitIdx + 1);

					passportBuilder.put(key, value);
				}
			}
		}

		int validPassportSections = (int) passportParts.stream()
				.filter(this::validatePassportSectionsExist)
				.count();

		int validPassports = (int) passportParts.stream()
				.filter(this::validatePassport)
				.count();

		printPartOutput(1, String.valueOf(validPassportSections));
		printPartOutput(2, String.valueOf(validPassports));
	}

	@Override
	protected int getPartCount() {
		return 2;
	}

	private boolean validatePassportSectionsExist(Map<String, String> passport) {
		for (GenericValidator validator : validators) {
			if (!passport.containsKey(validator.getKey())) {
				return false;
			}
		}

		return true;
	}

	private boolean validatePassport(Map<String, String> passport) {
		for (GenericValidator validator : validators) {
			if (!validator.validate(passport)) {
				return false;
			}
		}

		return true;
	}

}

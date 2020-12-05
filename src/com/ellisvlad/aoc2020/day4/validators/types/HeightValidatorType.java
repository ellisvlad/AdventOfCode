package com.ellisvlad.aoc2020.day4.validators.types;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.IntPredicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class HeightValidatorType extends GenericValidator {

	private Map<Pattern, IntPredicate> matchers;

	public HeightValidatorType(String key) {
		super(key);

		matchers = new HashMap<>();
		matchers.put(Pattern.compile("(\\d+)cm"), this::validateCm);
		matchers.put(Pattern.compile("(\\d+)in"), this::validateInches);
	}

	@Override
	protected boolean validateString(String valueStr) {
		for (Entry<Pattern, IntPredicate> matcherPair : matchers.entrySet()) {
			Matcher matcher = matcherPair.getKey().matcher(valueStr);
			if (!matcher.matches()) continue;
			
			int value = Integer.valueOf(matcher.group(1));
			IntPredicate validator = matcherPair.getValue();
		
			return validator.test(value);
		}

		//throw new RuntimeException("Failed to parse height string: " + valueStr);
		return false;
	}

	protected abstract boolean validateCm(int valueCm);

	protected abstract boolean validateInches(int valueInches);

}

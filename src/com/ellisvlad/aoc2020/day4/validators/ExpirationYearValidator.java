package com.ellisvlad.aoc2020.day4.validators;

import com.ellisvlad.aoc2020.day4.validators.types.IntegerValidatorType;

public class ExpirationYearValidator extends IntegerValidatorType {

	public ExpirationYearValidator() {
		super("eyr", 4);
	}

	@Override
	protected boolean validate(int value) {
		return (value >= 2020) && (value <= 2030);
	}

}

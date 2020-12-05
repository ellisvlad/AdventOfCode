package com.ellisvlad.aoc2020.day4.validators;

import com.ellisvlad.aoc2020.day4.validators.types.IntegerValidatorType;

public class BirthYearValidator extends IntegerValidatorType {

	public BirthYearValidator() {
		super("byr", 4);
	}

	@Override
	protected boolean validate(int value) {
		return (value >= 1920) && (value <= 2002);
	}

}

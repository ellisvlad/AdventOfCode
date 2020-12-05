package com.ellisvlad.aoc2020.day4.validators;

import com.ellisvlad.aoc2020.day4.validators.types.IntegerValidatorType;

public class IssueYearValidator extends IntegerValidatorType {

	public IssueYearValidator() {
		super("iyr", 4);
	}

	@Override
	protected boolean validate(int value) {
		return (value >= 2010) && (value <= 2020);
	}

}

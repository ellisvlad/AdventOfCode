package com.ellisvlad.aoc2020.day4.validators;

import com.ellisvlad.aoc2020.day4.validators.types.IntegerValidatorType;

public class PassportIdValidator extends IntegerValidatorType {

	public PassportIdValidator() {
		super("pid", 9);
	}

	@Override
	protected boolean validate(int value) {
		return true;
	}

}

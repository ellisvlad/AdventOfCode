package com.ellisvlad.aoc2020.day4.validators;

import com.ellisvlad.aoc2020.day4.validators.types.HeightValidatorType;

public class HeightValidator extends HeightValidatorType {

	public HeightValidator() {
		super("hgt");
	}

	@Override
	protected boolean validateCm(int value) {
		return (value >= 150) && (value <= 193);
	}

	@Override
	protected boolean validateInches(int value) {
		return (value >= 59) && (value <= 76);
	}

}

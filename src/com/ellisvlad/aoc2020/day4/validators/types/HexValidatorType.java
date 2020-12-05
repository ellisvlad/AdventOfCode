package com.ellisvlad.aoc2020.day4.validators.types;

import java.util.regex.Pattern;

public abstract class HexValidatorType extends GenericValidator {

	public HexValidatorType(String key) {
		super(key);
	}

	@Override
	protected boolean validateString(String valueStr) {
		return Pattern.matches("#[0-9a-fA-F]{6}", valueStr);
	}

}

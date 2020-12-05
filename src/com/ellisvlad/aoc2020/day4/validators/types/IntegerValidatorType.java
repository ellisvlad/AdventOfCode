package com.ellisvlad.aoc2020.day4.validators.types;

public abstract class IntegerValidatorType extends GenericValidator {

	private int digitsAllowed;

	public IntegerValidatorType(String key, int digitsAllowed) {
		super(key);
		this.digitsAllowed = digitsAllowed;
	}

	@Override
	protected boolean validateString(String valueStr) {
		try {
			int value = Integer.parseInt(valueStr);
	
			if (valueStr.length() != digitsAllowed) return false;
	
			return validate(value);
		} catch (NumberFormatException e) {
			return false;
		}
	}

	protected abstract boolean validate(int value);

}

package com.ellisvlad.aoc2020.day4.validators.types;

import java.util.Map;

public abstract class GenericValidator {
	
	private String key;

	protected GenericValidator(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
	
	public boolean validate(Map<String, String> passport) {
		if (!passport.containsKey(key)) return false;
		String value = passport.get(key);

		return validateString(value);
	}
	
	protected abstract boolean validateString(String value);

}

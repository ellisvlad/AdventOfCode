package com.ellisvlad.aoc2020.day2;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordChecker {

	protected static Pattern regex = Pattern.compile("(\\d+)-(\\d+) (.): (.+)");

	protected static Optional<PasswordChecker> parse(String input) {
		Matcher match = regex.matcher(input);
		if (!match.matches()) return Optional.empty();

		int idxStart = Integer.parseInt(match.group(1));
		int idxEnd = Integer.parseInt(match.group(2));
		char character = match.group(3).charAt(0);
		String password = match.group(4);

		return Optional.of(new PasswordChecker(idxStart, idxEnd, character, password));
	}

	int idxStart;
	int idxEnd;
	char character;
	String password;

	private PasswordChecker(int idxStart, int idxEnd, char character, String password) {
		this.idxStart = idxStart;
		this.idxEnd = idxEnd;
		this.character = character;
		this.password = password;
	}
	
	public boolean validate() {
		int occurences = (int) password.chars().filter(ch -> ch == character).count();
		if (occurences >= idxStart && occurences <= idxEnd) return true;
		
		return false;
	}
	
	public boolean validateV2() {
		int occurences = 0;
		if (password.charAt(idxStart - 1) == character) occurences++;
		if (password.charAt(idxEnd - 1) == character) occurences++;
		
		return occurences == 1;
	}

}

package com.ellisvlad.aoc2020.day4.validators.types;

import java.util.Optional;

public abstract class EyeColorValidatorType extends GenericValidator {

	private static enum EyeColor {
		AMBER("amb"),
		BLUE("blu"),
		BROWN("brn"),
		GRAY("gry"),
		GREEN("grn"),
		HAZEL("hzl"),
		OTHER("oth");

		private String colorCode;

		EyeColor(String colorCode) {
			this.colorCode = colorCode;
		}

		public static Optional<EyeColor> fromColorCode(String colorCode) {
			for (EyeColor color : values()) {
				if (color.colorCode.equalsIgnoreCase(colorCode)) return Optional.of(color);
			}

			return Optional.empty();
		}
	}

	public EyeColorValidatorType(String key) {
		super(key);
	}

	@Override
	protected boolean validateString(String valueStr) {
		return EyeColor.fromColorCode(valueStr).isPresent();
	}

}

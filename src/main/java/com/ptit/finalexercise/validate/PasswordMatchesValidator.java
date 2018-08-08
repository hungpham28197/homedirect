package com.ptit.finalexercise.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ptit.finalexercise.model.UserDto;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object>{

	public void initialize(PasswordMatches constraintAnnotation) {
	}

	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		UserDto userDto = (UserDto) obj;
		return userDto.getPassword().equals(userDto.getMatchingPassword());
	}

}

package com.studentinfo.genericvalidator;

import org.apache.commons.validator.routines.EmailValidator;

import com.studentinfo.constants.GenericConstants;


public class GenericValidator {

	public static String isValid(String email) {
		if (EmailValidator.getInstance().isValid(email)) {
			return null;
		}
		return GenericConstants.INVALID_EMAIL;
	}
}

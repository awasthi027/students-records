package com.studentinfo.constants;

import org.springframework.http.MediaType;

import java.nio.charset.Charset;

public class GenericConstants {
	 public static final String INVALID_EMAIL = "Wrong email format. Please write valid email.";
	 public static final String STUDENT_RECORD_SAVED = "Student record has been saved successfully.";
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(),
			Charset.forName("utf8")
	);
}

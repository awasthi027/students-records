package com.studentinfo.constants;

import org.springframework.http.MediaType;

import java.nio.charset.Charset;

public class GenericConstants {
	 public static final String BLANK_SPACE = " ";
	 public static final String INVALID_EMAIL = "Wrong email format. Please write valid email.";
	 public static final String STUDENT_RECORD_SAVED = "Student record has been saved successfully.";
	 public static final String STUDENT_INFO_DELETE = "Student record has been deleted successfully";
	 public static final String FIRST_GET_SAMPLE = "First Get Request Sample. Hello ";
	 public static final String HELLO_MESSAGE = "Hello" + BLANK_SPACE;
	 public static final String GOOGLE_BASE_URL = "https://newsapi.org/v2/";
	 public static final String NEWS_PARAMS = "everything?q=bitcoin&from=2021-07-09&sortBy=publishedAt&apiKey=";
	 public static final String GOOGLE_NEWS_API_KEY = "7ff2a53a38754a31815275ae55f4b88c";


	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(),
			Charset.forName("utf8")
	);
}

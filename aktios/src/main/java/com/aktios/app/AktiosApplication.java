package com.aktios.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.aktios.app.annotations.ExcludeFromJacocoGeneratedReport;

/**
 * Init Aktios Application.
 * @author juanmafe.
 */
@SpringBootApplication
@ExcludeFromJacocoGeneratedReport
public class AktiosApplication {

	/**
	 * Main void.
	 * @param args String[].
	 */
	public static void main(String[] args) {
		SpringApplication.run(AktiosApplication.class, args);
	}

}
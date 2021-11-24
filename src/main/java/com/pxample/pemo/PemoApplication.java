package com.pxample.pemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(PemoApplication.class, args);
	}

	@GetMapping("")
	public String pemodefault(@RequestParam(value = "customdefaultstr", defaultValue = "PefaultPage") String customdefaultstr) {
		return String.format("This is %s~", customdefaultstr);
	}

	@GetMapping("/pemohello")
	public String pemohello(@RequestParam(value = "name", defaultValue = "PemoWorld") String name) {
		return String.format("Hello %s~", name);
	}

}

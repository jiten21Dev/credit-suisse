package com.test.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.test.demo.service.FileProcessor;

@Profile(value = "!test")
@Component
public class ApplicationStartupRunner implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(ApplicationStartupRunner.class);

	@Autowired
	FileProcessor fileProcessor;

	@Override
	public void run(String... args) throws Exception {

		logger.info("Application Started !!");
		fileProcessor.process(args[0]);

	}

}

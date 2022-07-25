package com.test.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.test.demo.repository.EventRepository;

@SpringBootTest
@ActiveProfiles("test")
public class FileProcessorTest {

	@Autowired
	FileProcessor fileProcessor;

	@Autowired
	private EventRepository eventRepository;

	@Test
	public void processTest() throws IOException {
		eventRepository.deleteAll();
		fileProcessor.process("logfile.txt");
		assertEquals(3, eventRepository.count());
	}
}

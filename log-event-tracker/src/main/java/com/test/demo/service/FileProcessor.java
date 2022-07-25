package com.test.demo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.demo.model.Event;
import com.test.demo.model.Log;
import com.test.demo.repository.EventRepository;

@Service
public class FileProcessor {
	Logger logger = LoggerFactory.getLogger(FileProcessor.class);

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	EventRepository eventRepository;

	private final static Map<String, Log> map = new HashMap<>();

	public void process(String filepath) throws IOException {
		Files.lines(Paths.get(filepath)).forEach(l -> saveEventObject(l));

	}

	private void saveEventObject(String jsonLine) {
		try {
			Log log = objectMapper.readValue(jsonLine, Log.class);
			if (!map.containsKey(log.getId()))
				map.put(log.getId(), log);
			else {
				Log oldLog = map.get(log.getId());
				Event event = new Event();
				event.setEventId(log.getId());
				event.setDuration(Math.abs(oldLog.getTimestamp() - log.getTimestamp()));
				event.setHost(log.getHost());
				event.setType(log.getType());
				event.setAlert(event.getDuration() > 4);
				logger.info("Event Saved" + event);
				eventRepository.save(event);
			}

			logger.info("Events saved in DB " + eventRepository.count());

		} catch (JsonProcessingException e) {
			logger.error("Exception in class FileProcessor method saveEventObject : {} for line {}", e.getMessage(),
					jsonLine);
		}
	}
}
package com.test.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.test.demo.model.Event;

@SpringBootTest
@ActiveProfiles("test")
public class EventRepositoryTest {

	@Autowired
	private EventRepository eventRepository;

	@Test
	public void whenFindingEventById_thenCorrect() {
		Event e = new Event();
		e.setEventId("event1");
		e.setDuration(3);
		eventRepository.save(e);
		assertThat(eventRepository.findById("event1")).isInstanceOf(Optional.class);
	}
}

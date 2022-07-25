package com.test.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.demo.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, String> {

}

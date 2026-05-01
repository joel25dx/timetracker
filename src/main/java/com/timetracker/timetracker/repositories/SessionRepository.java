package com.timetracker.timetracker.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.timetracker.timetracker.database.Session;

@Repository
public interface SessionRepository extends MongoRepository<Session, String> {
    List<Session> findByEndTimeIsNull();

    List<Session> findByCategoryId(String categoryId);

}

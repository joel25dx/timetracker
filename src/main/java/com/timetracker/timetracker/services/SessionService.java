package com.timetracker.timetracker.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.timetracker.timetracker.database.Session;
import com.timetracker.timetracker.repositories.SessionRepository;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public Session createSession(Session session) {

        return sessionRepository.insert(session);
    }

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    public Optional<Session> getSessionById(String id) {
        return sessionRepository.findById(id);
    }

    public List<Session> getSessionByCategoryId(String categoryId) {
        return sessionRepository.findByCategoryId(categoryId);
    }

    public void deleteSession(String id) {
        sessionRepository.deleteById(id);
    }

    public boolean activeSession() {
        return !sessionRepository.findByEndTimeIsNull().isEmpty();
    }

    public Session startSession(String categoryId) {
        if (activeSession()) {
            throw new IllegalStateException("there is already an active session");
        }
        Session entry = new Session();
        entry.setCategoryId(categoryId);
        entry.setStartTime(LocalDateTime.now());
        return sessionRepository.insert(entry);
    }

    public Session stopSession(String id) {
        Session entry = sessionRepository.findById(id).orElseThrow();
        entry.setEndTime(LocalDateTime.now());
        return sessionRepository.save(entry);

    }
}
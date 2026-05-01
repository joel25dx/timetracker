package com.timetracker.timetracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timetracker.timetracker.database.Session;
import com.timetracker.timetracker.services.SessionService;

@RestController
@RequestMapping("/session")
@CrossOrigin(origins = "*")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping()
    public List<Session> getAllSessions() {
        return sessionService.getAllSessions();
    }

    @PostMapping("/create")
    public Session saveSession(@RequestBody Session session) {

        return sessionService.createSession(session);
    }

    @DeleteMapping("/{id}")
    public void deleteSession(@PathVariable String id) {
        sessionService.deleteSession(id);
    }

    @PostMapping("/start")
    public Session startSession(@RequestBody String categoryId) {
        return sessionService.startSession(categoryId);
    }

    @PostMapping("/stop/{id}")
    public Session stopSession(@PathVariable String id) {
        return sessionService.stopSession(id);
    }

    @GetMapping("/active")
    public boolean hasActiveSession() {
        return sessionService.activeSession();
    }

}

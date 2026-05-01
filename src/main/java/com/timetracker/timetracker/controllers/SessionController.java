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

@RestController
@RequestMapping("/sessions")
@CrossOrigin(origins = "*")
public class SessionController {

    private SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @Autowired
    private SessionService sessionService;

    @GetMapping()
    public List<Sessions> getAllSessions() {
        return sessionService.getAllSessions();
    }

    @PostMapping("/create")
    public Sessions saveSession(@RequestBody Sessions session) {

        return sessionService.createSession(session);
    }

    @DeleteMapping("/{id}")
    public void deleteSession(@PathVariable String id) {
        sessionService.deleteSession(id);
    }

    @PostMapping("/start")
    public Sessions startTimeEntry(@RequestBody String categoryId) {
        return sessionService.startTimeEntry(categoryId);
    }

    @PostMapping("/stop/{id}")
    public Sessions stopTimeEntry(@PathVariable String id) {
        return sessionService.stopTimeEntry(id);
    }

    @GetMapping("/active")
    public boolean hasActiveTimeEntry() {
        return sessionService.activeSession();
    }

}

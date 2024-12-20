/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.impurse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impurse.entities.Tasks;
import com.impurse.services.TaskService;


@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = { "http://localhost:3000" }, allowedHeaders = "*", allowCredentials = "true")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<?> getTasks() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getTasksByUser(@PathVariable int userId) {
        return ResponseEntity.ok(taskService.findByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody Tasks task, int userId) {
        taskService.createReimbursement(task, userId);
        return ResponseEntity.status(201).body(task);
    }

    @PostMapping("/{taskId}/approve")
    public ResponseEntity<?> approveTask(@PathVariable int taskId) {
        return ResponseEntity.ok(taskService.approveReimbursement(taskId));
    }

    @PostMapping("/{taskId}/deny")
    public ResponseEntity<?> rejectTask(@PathVariable int taskId) {
        return ResponseEntity.ok(taskService.denyReimbursement(taskId));
    }
}

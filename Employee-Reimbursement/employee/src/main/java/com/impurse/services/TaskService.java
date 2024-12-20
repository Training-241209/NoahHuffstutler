/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.impurse.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impurse.DAOs.TaskDAO;
import com.impurse.entities.Tasks;
import com.impurse.entities.Users;

import jakarta.transaction.Transactional;


@Service
public class TaskService {

    @Autowired
    private TaskDAO taskDAO;
    public List<Tasks> findAll() {
        return taskDAO.findAll();
    }

    @Transactional
    public Tasks createReimbursement(Tasks request, Integer userId) {
        try {
            Users user = new Users();
            user.setUserId(userId);
            request.setDateSubmitted(LocalDate.now());
            request.setStatus(Tasks.taskStatus.PENDING);
            request.setUser(user);
            return taskDAO.save(request);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw e;
        }
    }

    public Tasks approveReimbursement(int id) {
        Optional<Tasks> found = taskDAO.findById(id);
        if (found.isPresent()) {
            Tasks task = found.get();
            task.setStatus(Tasks.taskStatus.APPROVED);
            return taskDAO.save(task);
        } else {
            throw new RuntimeException("Reimbursement request not found.");
        }
    }

    public Tasks denyReimbursement(int id) {
        Optional<Tasks> found = taskDAO.findById(id);
        if (found.isPresent()) {
            Tasks task = found.get();
            task.setStatus(Tasks.taskStatus.DENIED);
            return taskDAO.save(task);
        } else {
            throw new RuntimeException("Reimbursement request not found");
        }
    }

    public List<Tasks> findByUserId(int userId) {
        return taskDAO.findByUserUserId(userId);
    }
}

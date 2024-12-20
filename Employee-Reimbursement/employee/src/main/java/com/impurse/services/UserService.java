/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.impurse.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impurse.DAOs.UserDAO;
import com.impurse.entities.Users;

@Service
public class UserService {

    private UserDAO userDAO;
    
    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    
    public Users registerUser(Users user) {
        return userDAO.save(user);
    }

    public Optional<Users> login(String username, String password) {
        return userDAO.findByUsernameAndPassword(username, password);
    }

    public void deleteUser(int userId) {
        userDAO.deleteById(userId);
    }
}

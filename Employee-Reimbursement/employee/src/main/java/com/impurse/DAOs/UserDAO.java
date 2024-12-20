/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.impurse.DAOs;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.impurse.entities.Users;

@Repository
public interface UserDAO extends JpaRepository<Users, Integer>{
    public Optional<Users> findByUsernameAndPassword(String username, String password);

}

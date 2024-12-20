/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.impurse.DAOs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.impurse.entities.Tasks;

@Repository
public interface TaskDAO extends JpaRepository<Tasks, Integer>{
    List<Tasks> findByUserUserId(int userId);
}

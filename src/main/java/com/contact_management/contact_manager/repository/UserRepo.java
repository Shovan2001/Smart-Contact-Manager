package com.contact_management.contact_manager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contact_management.contact_manager.entity.Users;


@Repository
public interface UserRepo extends JpaRepository<Users,Integer>{

    Optional<Users> findByEmail(String email);
    Optional<Users> findByEmailAndPassword(String email, String password);
    
} 
package com.contact_management.contact_manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.contact_management.contact_manager.entity.Users;

@Service
public interface UserServices {

    Users saveUsers(Users user);

    Optional<Users> getUsersById(int userId);

    Optional<Users> updateUsers(Users user);

    void deleteUsers(int userId);

    boolean isUserExistsById(int userId);

    boolean isUserExistsByEmail(String email);

    List<Users> getAllUsers();

}

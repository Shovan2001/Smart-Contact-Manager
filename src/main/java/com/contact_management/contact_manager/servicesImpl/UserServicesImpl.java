package com.contact_management.contact_manager.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact_management.contact_manager.entity.Users;
import com.contact_management.contact_manager.repository.UserRepo;
import com.contact_management.contact_manager.services.UserServices;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserRepo userRepo;

    @Override
    public Users saveUsers(Users user) {

        return userRepo.save(user);
    }

    @Override
    public Optional<Users> getUsersById(int userId) {

        return userRepo.findById(userId);
    }

    @Override
    public Optional<Users> updateUsers(Users user) 
    {
        Users user_new=userRepo.findById(user.getUserId()).get();
        if(user_new !=null)
        {
            user_new.setName(user.getName());
            user_new.setEmail(user.getEmail());
            user_new.setPassword(user.getPassword());
            user_new.setPhoneNo(user.getPhoneNo());
            user_new.setAbout(user.getAbout());

            }
        else
        {
            try {
                throw new Exception("User Not found!!");
            } catch (Exception e) {
                e.printStackTrace();
            } 
        }
        Users updated_user=userRepo.save(user_new);
        
        return Optional.ofNullable(updated_user);
    }

    @Override
    public void deleteUsers(int userId) {

        Users user=userRepo.findById(userId).get();
        
        userRepo.delete(user);
        
    }

    @Override
    public boolean isUserExistsById(int userId) {

        Users user= userRepo.findById(userId).get();

        return Optional.ofNullable(user).isPresent();
    }

    @Override
    public boolean isUserExistsByEmail(String email) {

        throw new UnsupportedOperationException("Unimplemented method 'isUserExistsByEmail'");
    }

    @Override
    public List<Users> getAllUsers() {

        throw new UnsupportedOperationException("Unimplemented method 'getAllUsers'");
    }

}

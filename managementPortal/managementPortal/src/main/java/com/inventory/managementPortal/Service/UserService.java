package com.inventory.managementPortal.Service;

import com.inventory.managementPortal.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    void deleteUserById(Long id);
    User updateUserById(User user, Long id);
}

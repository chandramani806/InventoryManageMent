package com.inventory.managementPortal.ServiceImpl;

import com.inventory.managementPortal.Entity.User;
import com.inventory.managementPortal.Repository.UserRepository;
import com.inventory.managementPortal.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User createUser(User user) {
        return  userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUserById(User user, Long id) {
        return null;
    }

//    @Override
//    public User updateUserById(User user, Long id) {
//        User oldUser = userRepository.findById(id).get();
//        if(oldUser.getUserType() != user.getUserType()) {
//            oldUser.setUserType(user.getUserType());
//        }
//        if(oldUser.getName() != user.getName()) {
//            oldUser.setName(user.getName());
//        }
//        if(oldUser.getPassword() != user.getPassword()) {
//            oldUser.setPassword(user.getPassword());
//        }
//        if(oldUser.getEmailId() != user.getEmailId()) {
//            oldUser.setEmailId(user.getEmailId());
//        }
//        if(oldUser.getMobileNumber() != user.getMobileNumber()){
//            oldUser.setMobileNumber((user.getMobileNumber()));
//        }
//        return userRepository.save(oldUser);
//    }
}
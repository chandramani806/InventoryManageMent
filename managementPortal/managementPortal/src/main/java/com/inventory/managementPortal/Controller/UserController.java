package com.inventory.managementPortal.Controller;

import com.inventory.managementPortal.Entity.User;
import com.inventory.managementPortal.Exception.UserNotCreatedException;
import com.inventory.managementPortal.Exception.UserNotFoundException;
import com.inventory.managementPortal.Repository.UserRepository;
import com.inventory.managementPortal.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @CrossOrigin(origins = "http://localhost:3000", methods = RequestMethod.POST)
    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) throws UserNotCreatedException {
        logger.info("Creating user");
        User checkUser =  userService.createUser(user);

        // If user is not created, you may want to throw an exception or handle it differently
        if (checkUser == null) {
            logger.error("User not created");
            throw new UserNotCreatedException("Entered User Couldn't be Created");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(checkUser);
    }


    @CrossOrigin(origins = "http://localhost:3000", methods = RequestMethod.GET)
    @GetMapping("/getAllUsers")
    public List<User> getAllUser() {
        logger.info("Getting all users");
        return userService.getAllUsers();
    }

    @CrossOrigin(origins = "http://localhost:3000", methods = RequestMethod.GET)
    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Long id) throws UserNotFoundException {
        logger.info("Getting user by id");
        User checkUser = userService.getUserById(id);
        if(checkUser == null){
            logger.error("User cannot be found");
            throw new UserNotFoundException("Entered User doesn't exist");
        }
        logger.info("Getting user by id");
        return checkUser;
    }

    @CrossOrigin(origins = "http://localhost:3000", methods = RequestMethod.PUT)
    @PutMapping("/updateUserById/{id}")
    public User updateUserById(@Valid @RequestBody User user, @PathVariable Long id) {
        logger.info("Updating user");
        return userService.updateUserById(user, id);
    }

    @CrossOrigin(origins = "http://localhost:3000", methods = RequestMethod.DELETE)
    @DeleteMapping("/deleteUserById/{id}")
    public void deleteUserById(@PathVariable Long id) {
        logger.info("Deleting user");
        userService.deleteUserById(id);
    }
}


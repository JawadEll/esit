package com.company.employee_management_backend.service.impl;

import com.company.employee_management_backend.entity.User;
import com.company.employee_management_backend.exception.RecourceException;
import com.company.employee_management_backend.repository.UserRepository;
import com.company.employee_management_backend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public  class  UserServiceImpl implements UserService {

 private final UserRepository userRepository;


    public UserServiceImpl (UserRepository _userRepository) {
      this.userRepository = _userRepository;
     }

    @Override
    public User createUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RecourceException("usename "+user.getUsername()+" exsite déja reeyer avec un autre ");
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()){ //si il y a 0 Users
            throw new RecourceException("ne peut pas étre vide");
        }
        return users;
    }



    @Override
    public Optional<User> getUserById(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RecourceException("User_ID non Trouvale"));
          userRepository.delete(user);
    }

    @Override
    public User updateUser(Long id, User userToUpdate) {
       User userToExist =  userRepository.findById(id)
               .orElseThrow(()->new RecourceException("user  " + id+"non Trouvale"));

        userToExist.setUsername(userToUpdate.getUsername());
        userToExist.setRole(userToUpdate.getRole());
        userToExist.setPassword((userToUpdate.getPassword()));
        //userToExist.setPassword(passwordEncoder.encode(userToUpdate.getPassword()));

        // en attendant  à encoder si Spring Security  passwordEncoder.encode
        return userRepository.save(userToExist);

    }
}

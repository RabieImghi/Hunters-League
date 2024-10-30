package org.rabie.hunters_league.service;

import org.rabie.hunters_league.domain.User;
import org.rabie.hunters_league.exceptions.UserPasswordWrongException;
import org.rabie.hunters_league.exceptions.UserWithEmailNotExistException;
import org.rabie.hunters_league.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User login(User user){
        User userFromDb = userRepository.findByEmail(user.getEmail());
        if(userFromDb == null) throw new UserWithEmailNotExistException("User with email: " + user.getEmail() + " not found");
        else if(!userFromDb.getPassword().equals(user.getPassword())) throw new UserPasswordWrongException("Password is wrong");
        return userFromDb;
    }
    public User update(User user) {
        return userRepository.save(user);
    }



}


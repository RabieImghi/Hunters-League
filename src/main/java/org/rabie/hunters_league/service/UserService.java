package org.rabie.hunters_league.service;

import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.rabie.hunters_league.domain.User;
import org.rabie.hunters_league.exceptions.UserPasswordWrongException;
import org.rabie.hunters_league.exceptions.UserNotExistException;
import org.rabie.hunters_league.repository.UserRepository;
import org.rabie.hunters_league.service.dto.UserSearchDto;
import org.rabie.hunters_league.specification.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    public User getById(UUID id) {
        return userRepository.findById(id).orElse(new User());
    }
    public User save(User user) {
        UserSearchDto searchDto = new UserSearchDto();
        searchDto.setEmail(user.getEmail());
        searchDto.setUsername(user.getUsername());
        if(userRepository.findOne(UserSpecification.getUsersByCriteria(searchDto)).isPresent())
            throw new UserNotExistException("User with email: " + user.getEmail() + " already exist");
        if(userRepository.findOne(UserSpecification.getUsersByCriteria(searchDto)).isPresent())
            throw new UserNotExistException("User with username: " + user.getUsername() + " already exist");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    public User login(User user){
        UserSearchDto searchDto = new UserSearchDto();
        searchDto.setEmail(user.getEmail());
        User userFromDb = userRepository.findOne(UserSpecification.getUsersByCriteria(searchDto)).orElse(null);
        if(userFromDb == null) throw new UserNotExistException("User with email: " + user.getEmail() + " not found");
        else {
            boolean isPasswordMatch = passwordEncoder.matches(user.getPassword(), userFromDb.getPassword());
            if (!isPasswordMatch) throw new UserPasswordWrongException("Error : Password is wrong");
            return userFromDb;
        }
    }
    public User update(User user) {
        return userRepository.save(user);
    }


    public Page<User> searchUsers(UserSearchDto searchDto, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return userRepository.findAll(UserSpecification.getUsersByCriteria(searchDto), pageRequest);
    }
    public void delete(User user) {
        if(user == null) throw new UserNotExistException("User does not exist");
        userRepository.delete(user);
    }

}


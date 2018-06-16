/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicabeans.api.crud.service;

import com.logicabeans.api.crud.IUserService;
import com.logicabeans.api.crud.exception.UserNotFoundException;
import com.logicabeans.api.crud.model.User;
import com.logicabeans.api.crud.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author medineshkatwal
 */
@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository repo;

    @Override
    public Page<User> getUsers(Pageable page) {
        Page<User> allUsers = repo.findAll(page);
        return allUsers;
    }

    @Override
    public User getUser(Long id) throws UserNotFoundException {
        Optional<User> getUser = repo.findById(id);
        if (getUser.isPresent()) {
            return getUser.get();
        }
        throw new UserNotFoundException("User Not Found with id: " + id);
    }

    @Override
    public User addUser(User user) {
        User savedUser = repo.save(user);
        return savedUser;
    }

    @Override
    public User deleteUser(Long id) throws UserNotFoundException {
        User user = this.getUser(id);
        if (user != null) {
            repo.delete(user);
        }
        throw new UserNotFoundException("User Not found with id:" + id);
    }

    @Override
    public User updateUser(User user) throws UserNotFoundException {
        Long id = user.getId();
        if (id != null) {
            User updatedUser = repo.save(user);
            return updatedUser;
        }
        throw new UserNotFoundException("User Not found with id:" + id);
    }

}

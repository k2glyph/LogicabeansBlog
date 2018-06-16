/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicabeans.api.crud;

import com.logicabeans.api.crud.exception.UserNotFoundException;
import com.logicabeans.api.crud.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author medineshkatwal
 */
public interface IUserService {

    public Page<User> getUsers(Pageable page);

    public User getUser(Long id) throws UserNotFoundException;

    public User addUser(User user);

    public User deleteUser(Long id) throws UserNotFoundException;

    public User updateUser(User user) throws UserNotFoundException;
}

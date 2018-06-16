/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicabeans.api.crud.controller;

import com.logicabeans.api.crud.IUserService;
import com.logicabeans.api.crud.exception.UserNotFoundException;
import com.logicabeans.api.crud.model.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author medineshkatwal
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private IUserService service;

    @ApiOperation(
            value = "Get All Users by Pagination",
            notes = "Need to provide start and limit in order to get all user.",
            produces = "application/json")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getUsers(Pageable page) {
        return new ResponseEntity((Page<User>) service.getUsers(page), HttpStatus.OK);
    }

    @ApiOperation(
            value = "Get User by Id",
            notes = "Can retrive user if exist",
            produces = "application/json")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity getUser(@PathVariable Long id) {
        try {
            return new ResponseEntity((User) service.getUser(id), HttpStatus.OK);
        } catch (UserNotFoundException ex) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(
            value = "Add new User",
            notes = "Create new User with registration and saved into database",
            produces = "application/json")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody User user) {
        return new ResponseEntity((User) service.addUser(user), HttpStatus.OK);
    }

    @ApiOperation(
            value = "Update user",
            notes = "if user exists then it will update the user and saved into the database",
            produces = "application/json")
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        try {
            return new ResponseEntity((User) service.updateUser(user), HttpStatus.OK);
        } catch (UserNotFoundException ex) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @ApiOperation(
            value = "Delete User by Id",
            notes = "Only Delete event happen if user exists",
            produces = "application/json")
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return new ResponseEntity((User) service.deleteUser(id), HttpStatus.OK);
        } catch (UserNotFoundException ex) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}

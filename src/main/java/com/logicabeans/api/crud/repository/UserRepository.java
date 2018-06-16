/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicabeans.api.crud.repository;

import com.logicabeans.api.crud.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author medineshkatwal
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}

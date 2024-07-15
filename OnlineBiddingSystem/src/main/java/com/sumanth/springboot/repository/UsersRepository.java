package com.sumanth.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sumanth.springboot.model.Users;

import jakarta.transaction.Transactional;

public interface UsersRepository extends JpaRepository<Users, Long> {
	Users findByUsername(String username);
    Users findByEmail(String email);
    
    @Modifying
    @Transactional
    @Query("UPDATE Users u SET u.password = :password WHERE u.id = :id")
    void updatePassword(@Param("id") long id, @Param("password") String password);
    
    
    @Modifying
    @Transactional
    @Query("UPDATE Users u SET u.email = :email WHERE u.id = :id")
    void upadateEmai(@Param("id") long id, @Param("email") String email);
    
	

}

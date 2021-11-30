package com.example.tvs.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.tvs.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query(value="select * from user u where u.email_id= :emailId and u.password= :password ", nativeQuery=true)
    List<User> getUserByEmailIdandPassword(String emailId,String password);
    
    User findByEmailId(String emailId);

}

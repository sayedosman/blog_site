package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
   
	public Optional<User> findByEmail(String email);
	 

}

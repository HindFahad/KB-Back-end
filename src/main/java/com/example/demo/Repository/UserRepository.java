package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	UserEntity findByEmailAndPassword(String email,String password );
	
	@Query(value = "SELECT * FROM User where email=:email",nativeQuery = true)
	List<UserEntity> findByEmail(String email);
}

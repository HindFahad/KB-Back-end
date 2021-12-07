package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.QustionsEntity;

@Repository
public interface QustionsRepository  extends   JpaRepository<QustionsEntity, Integer>{

}

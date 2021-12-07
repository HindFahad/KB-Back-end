package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.AnswersEntity;
@Repository
public interface AnswersRepository extends  JpaRepository<AnswersEntity, Integer>{


}
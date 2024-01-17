package com.practice.springboot3features.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.springboot3features.entity.Vote;

public interface VoteRepo extends JpaRepository<Vote, Long> {

}

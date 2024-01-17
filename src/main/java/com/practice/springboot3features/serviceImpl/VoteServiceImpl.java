package com.practice.springboot3features.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.springboot3features.entity.Vote;
import com.practice.springboot3features.repository.VoteRepo;
import com.practice.springboot3features.service.VoteService;

@Service
public class VoteServiceImpl implements VoteService {

	@Autowired
	private VoteRepo voteRepo;
	
	public void vote(Vote voteReq) {		
		voteRepo.save(voteReq);
	}
}

package com.practice.springboot3features.controller;

import java.net.URI;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practice.springboot3features.entity.Vote;
import com.practice.springboot3features.exception.AgeNotValidException;
import com.practice.springboot3features.service.VoteService;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;

@RestController
@RequestMapping("/vote")
public class VoteController {

	@Autowired
	private VoteService voteService;
	
	@Autowired
	private ObservationRegistry registry; //io.micrometer.observation.ObservationRegistry(I)
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ResponseEntity<?> vote(@RequestBody Vote voteReq) {	
		if (voteReq.getAge() < 18) {
			voteReq.setVoted(false);
			voteService.vote(voteReq);	
			throw new AgeNotValidException("INVALID AGE");	
		}
		voteReq.setVoted(true);
		voteService.vote(voteReq);
		//return ResponseEntity.ok("Voting done successfully!!");
		return Observation //io.micrometer.observation.Observation(I)
				.createNotStarted("vote", registry) //static Observation createNotStarted(String name, @Nullable ObservationRegistry registry)
				.observe(()->ResponseEntity.ok("Voting done successfully!!")); //observe(Supplier<T> supplier)
	}
}


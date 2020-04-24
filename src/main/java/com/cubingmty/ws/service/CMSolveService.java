package com.cubingmty.ws.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.cubingmty.ws.entity.CMTimes;
//import com.cubingmty.ws.entity.CMUser;
import com.cubingmty.ws.entity.StandardResponse;
import com.cubingmty.ws.repository.CMTimesRepository;
import com.cubingmty.ws.util.CommonConstants;

import org.springframework.data.domain.Sort;


@Service
public class CMSolveService {
	
	
	@Autowired
	private CMTimesRepository solveRepository;
	
	
	
	public StandardResponse<CMTimes> save(CMTimes solve) {
		StandardResponse<CMTimes> response = new StandardResponse<CMTimes>();
		try {
			response.setEntity(solveRepository.save(solve));
			response.setResponsetext("Solve saved!");
			response.setStatus(CommonConstants.RESPONSE_SUCCESS);
		} catch (Exception e) {
			response.setEntity(solve);
			response.setResponsetext(e.toString());
			response.setStatus(CommonConstants.RESPONSE_ERROR);
		}
		return response;
	}
	

	public StandardResponse<CMTimes> registerTestSolve(Double time){
		CMTimes solve = CMTimes.builder()
		.id(1)
		.userId(1)
		.time(time)
		.scramble("U B D")
		.dnf(true)
		.plus(false)
		.date("Hoy")
		.build();
		StandardResponse<CMTimes> response = new StandardResponse<CMTimes>();
		try {
			response.setEntity(solveRepository.save(solve));
			response.setResponsetext("Solve saved!");
			response.setStatus(CommonConstants.RESPONSE_SUCCESS);
		} catch (Exception e) {
			response.setEntity(solve);
			response.setResponsetext(e.toString());
			response.setStatus(CommonConstants.RESPONSE_ERROR);
		}
		return response;
	}
	
	//public CMTimes findByTourney(String email) {
	//	return solveRepository.findByTourney(email).orElse(null);
	//}
	
	//public CMTimes findByUserId(Integer userId) {
	//	return solveRepository.findByUserId(userId).orElse(null);
	//}
	
	public List<CMTimes> findAll() {
		return solveRepository.findAll();
	}
	
	public List<CMTimes> findAllSorted() {
		return solveRepository.findAll(Sort.by("time").ascending());
	}
	
	public void delete(Integer id) {
		solveRepository.deleteById(id);
	}
	
	public Optional<CMTimes> findById(Integer id) {
		return solveRepository.findById(id);
	}
	
	public CMTimes getOne(Integer id) {
		return solveRepository.getOne(id);
	}
	
	
	
	
}

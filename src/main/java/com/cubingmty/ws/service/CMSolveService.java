package com.cubingmty.ws.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.cubingmty.ws.entity.CMSolveTourney;
import com.cubingmty.ws.entity.CMSolves;
import com.cubingmty.ws.entity.StandardResponse;
import com.cubingmty.ws.repository.CMSolveTourneyRepository;
import com.cubingmty.ws.repository.CMSolvesRepository;
import com.cubingmty.ws.util.CommonConstants;
import com.cubingmty.ws.util.UtilFunctions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CMSolveService {
	
	
	@Autowired
	private CMSolvesRepository solveRepository;

	@Autowired
	private CMSolveTourneyRepository solveTorneyRepository;
	
	
	
	public StandardResponse<CMSolves> save(CMSolves solve, Integer tourneyId) {
		StandardResponse<CMSolves> response = new StandardResponse<CMSolves>();

		try {
			solve.checkTimeLimit();
			solve.setDate(new Date());
			solve.setTimeStr(UtilFunctions.parseTimeToString(solve.getTime()));
			solve = solveRepository.save(solve);
			response.setEntity(solve);
			response.setResponsetext("Solve saved!");
			response.setStatus(CommonConstants.RESPONSE_SUCCESS);
			if(tourneyId != null){
				CMSolveTourney solveTourney = CMSolveTourney.builder()
				.solveId(solve.getId())
				.tourneyId(tourneyId).build();
				solveTorneyRepository.save(solveTourney);
			}
		} catch (Exception e) {
			response.setEntity(solve);
			response.setResponsetext(e.toString());
			response.setStatus(CommonConstants.RESPONSE_ERROR);
		}
		return response; 
	}

	public List<CMSolves> findAllByTourneyId(Integer id){
		List<Integer> ids = solveTorneyRepository.getSolvesIdsBytourneyId(id);
		if (ids.size() == 0) return new ArrayList<CMSolves>();
		return solveRepository.findAllByTourneyId(ids);
		
	}
	
	public List<CMSolves> findByCubeAndTourneyId(String cube,Integer id){
		List<Integer> ids = solveTorneyRepository.getSolvesIdsBytourneyId(id);
		if (ids.size() == 0) return new ArrayList<CMSolves>();
		return solveRepository.findByCubeAndTourneyId(cube, ids);
	}

	public StandardResponse<CMSolves> registerTestSolve(Integer userId, Integer time, String cube, Integer tourneyId){
		CMSolves solve = CMSolves.builder()
		.userId(userId)
		.time(time) 
		.scramble("D' F2 D2 R2 U L2 U' L2 F2 U2 R2 F' U B2 D R' F U2 F R2 D")
		.cube(cube)
		.dnf(true)
		.plus2(false)
		.date(new Date())
		.build();
		solve.setTimeStr(UtilFunctions.parseTimeToString(time));
		StandardResponse<CMSolves> response = new StandardResponse<CMSolves>();
		try {
			solve.checkTimeLimit();
			response.setEntity(solveRepository.save(solve));
			response.setResponsetext("Solve saved!");
			response.setStatus(CommonConstants.RESPONSE_SUCCESS);
			if(tourneyId != null){
				CMSolveTourney solveTourney = CMSolveTourney.builder()
				.solveId(solve.getId())
				.tourneyId(tourneyId).build();
				solveTorneyRepository.save(solveTourney);
			}
		} catch (Exception e) {
			response.setEntity(null);
			response.setResponsetext(e.getMessage() );
			response.setStatus(CommonConstants.RESPONSE_ERROR);
		}
		return response;
	}
	
	
	public List<CMSolves> findAll() {
		return solveRepository.findAll();
	}
	
	//public List<CMSolves> findAllSorted() {
	//	return solveRepository.findAll(Sort.by("time").ascending());
	//}
	
	public void delete(Integer id) {
		solveRepository.deleteById(id);
	}
	
	public Optional<CMSolves> findById(Integer id) {
		return solveRepository.findById(id);
	}
	
	public CMSolves getOne(Integer id) {
		return solveRepository.getOne(id);
	}
	
	
	public List<CMSolves> getSolveByUser(Integer userId){
		List<CMSolves> list = solveRepository.findByUserId(userId);
		return list;
	}
	
	public List<CMSolves> getSolveByCube(String cube){
		List<CMSolves> list = solveRepository.findByCube(cube);
		return list;
	}
	
	
	public List<CMSolves> getSolveByUserAndCube(Integer userId, String cube, String order){
		List<CMSolves> list;
		if(order.equals(CommonConstants.ORDER_TIME)){
			list = solveRepository.findByUserIdAndCubeOrderByTimeAsc(userId, cube);
		}else {
			list = solveRepository.findByUserIdAndCubeOrderByDateAsc(userId, cube);
		}
		return list;
	}
	
	public List<CMSolves> getBestSolveByUserAndCube(Integer userId, String cube){
		List<CMSolves> best = solveRepository.findTopByUserIdAndCubeOrderByTimeAsc(userId, cube);
		return best;
	}
	
	
	public List<CMSolves> getByCubeOrderByTime(String cube){
		List<CMSolves> list = solveRepository.findByCubeOrderByTimeAsc(cube);
		return list;
	}
	
	public List<CMSolves> getByCubeOrderByDate(String cube){
		List<CMSolves> list = solveRepository.findByCubeOrderByDateAsc(cube);
		return list;
	}
	
	
	public List<CMSolves> findAllByOrderByTime() {
		return solveRepository.findAllByOrderByTimeAsc();
	}
	
	
	public List<CMSolves> getByUserIdAndCubeOrderByTime(Integer userId, String cube){
		List<CMSolves> list = solveRepository.findByUserIdAndCubeOrderByTimeAsc(userId, cube);
		return list;
	}
	
	public List<CMSolves> getByUserIdAndCubeOrderByDate(Integer userId, String cube){
		List<CMSolves> list = solveRepository.findByUserIdAndCubeOrderByDateAsc(userId, cube);
		return list;
	}
	
}

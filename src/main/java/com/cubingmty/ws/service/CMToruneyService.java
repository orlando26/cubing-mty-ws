package com.cubingmty.ws.service;

import java.util.List;

import com.cubingmty.ws.entity.CMTourney;
import com.cubingmty.ws.entity.StandardResponse;
import com.cubingmty.ws.repository.CMTourneyRepository;
import com.cubingmty.ws.util.CommonConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CMToruneyService {

    @Autowired
    private CMTourneyRepository tourneyRepository;

    public List<CMTourney> findAll(){
        return tourneyRepository.findAll();
    }

    public StandardResponse<CMTourney> save(CMTourney tourney){
        StandardResponse<CMTourney> response = new StandardResponse<>();
        try{
            response.setEntity(tourneyRepository.save(tourney));
            response.setResponsetext("tourney saved!");
            response.setStatus(CommonConstants.RESPONSE_SUCCESS);
        }catch(Exception e){
            response.setEntity(null);
            response.setResponsetext(e.getMessage());
            response.setStatus(CommonConstants.RESPONSE_ERROR);
        }
        return response;
    }
}
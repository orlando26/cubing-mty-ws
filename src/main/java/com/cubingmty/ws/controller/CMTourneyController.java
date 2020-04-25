package com.cubingmty.ws.controller;

import java.util.List;

import com.cubingmty.ws.entity.CMTourney;
import com.cubingmty.ws.entity.StandardResponse;
import com.cubingmty.ws.service.CMToruneyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tourney")
public class CMTourneyController {

    @Autowired
    private CMToruneyService tourneyService;

    @PostMapping
    @CrossOrigin
    public StandardResponse<CMTourney> save(@RequestBody CMTourney tourney){
        return tourneyService.save(tourney);
    }

    @GetMapping
    @CrossOrigin
    public List<CMTourney> findAll(){
        return tourneyService.findAll();
    }
}
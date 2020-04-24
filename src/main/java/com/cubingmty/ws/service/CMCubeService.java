package com.cubingmty.ws.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class CMCubeService {
	
	public Map<String, String> cubesMap;
	
	public CMCubeService() {
		this.cubesMap = new HashMap<String, String>();
		cubesMap.put("2x2x2", "2x2x2-CUBE-RANDOM");
		cubesMap.put("3x3x3", "RUBIKS-CUBE-RANDOM");
		cubesMap.put("4x4x4", "4x4x4-CUBE-RANDOM");
		cubesMap.put("5x5x5", "5x5x5-CUBE-RANDOM");
		cubesMap.put("6x6x6", "6x6x6-CUBE-RANDOM");
		cubesMap.put("7x7x7", "7x7x7-CUBE-RANDOM");
		cubesMap.put("MEGAMINX", "MEGAMINX-RANDOM");
		cubesMap.put("PYRAMINX", "PYRAMINX-RANDOM");
		cubesMap.put("SQUARE-1", "SQUARE-1-RANDOM");
		cubesMap.put("SKEWB", "SKEWB-RANDOM");
		cubesMap.put("TOWER-CUBE", "TOWER-CUBE-RANDOM");
		cubesMap.put("RUBIKS-TOWER", "RUBIKS-TOWER-RANDOM");
		cubesMap.put("RUBIKS-DOMINO", "RUBIKS-DOMINO-RANDOM");
		cubesMap.put("FLOPPY-CUBE", "FLOPPY-CUBE-RANDOM");
	}
	
	public List<String> getCubesList(){
		return cubesMap.keySet().stream().sorted().map(s -> s.replaceAll("0", "")).collect(Collectors.toList());
	}
	
	public String getScrambleId(String key) {
		return this.cubesMap.get(key);
	}
	
}

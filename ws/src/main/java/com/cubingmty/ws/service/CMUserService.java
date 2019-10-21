package com.cubingmty.ws.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubingmty.ws.entity.CMUser;
import com.cubingmty.ws.entity.StandardResponse;
import com.cubingmty.ws.repository.CMUserRepository;
import com.cubingmty.ws.util.CommonConstants;
import com.cubingmty.ws.util.UtilFunctions;

@Service
public class CMUserService {
	
	@Autowired
	private CMUserRepository userRepository;
	
	public StandardResponse<CMUser> save(CMUser user) {
		StandardResponse<CMUser> response = new StandardResponse<CMUser>();
		try {
			user.setPassword(UtilFunctions.hash(user.getPassword()));
			System.out.println(user);
			response.setEntity(userRepository.save(user));
			response.setResponsetext("User saved!");
			response.setStatus(CommonConstants.RESPONSE_SUCCESS);
		} catch (Exception e) {
			response.setEntity(user);
			response.setResponsetext(e.getMessage());
			response.setStatus(CommonConstants.RESPONSE_ERROR);
		}
		return response;
	}
	
	public Optional<CMUser> findById(Integer id) {
		return userRepository.findById(id);
	}
	
	public Iterable<CMUser> findAll(){
		return userRepository.findAll();
	}
	
	
}

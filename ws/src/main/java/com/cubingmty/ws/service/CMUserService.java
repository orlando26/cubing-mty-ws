package com.cubingmty.ws.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cubingmty.ws.entity.CMUser;
import com.cubingmty.ws.entity.StandardResponse;
import com.cubingmty.ws.repository.CMUserRepository;
import com.cubingmty.ws.util.CommonConstants;

@Service
public class CMUserService {
	
	@Autowired
	public PasswordEncoder passwordEncoder;
	
	@Autowired
	private CMUserRepository userRepository;
	
	public StandardResponse<CMUser> save(CMUser user) {
		user.setEnabled(1);
		user.setImage("avatar.png");
		StandardResponse<CMUser> response = new StandardResponse<CMUser>();
		try {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			response.setEntity(userRepository.save(user));
			response.setResponsetext("User saved!");
			response.setStatus(CommonConstants.RESPONSE_SUCCESS);
		} catch(DataIntegrityViolationException cve) {
			response.setEntity(user);
			response.setResponsetext("El correo " + user.getEmail() + " ya esta registrado");
			response.setStatus(CommonConstants.RESPONSE_ERROR);
		} catch (Exception e) {
			response.setEntity(user);
			response.setResponsetext(e.toString());
			response.setStatus(CommonConstants.RESPONSE_ERROR);
		}
		return response;
	}
	
	public CMUser findByEmail(String email) {
		return userRepository.findByEmail(email).orElse(null);
	}
	
	public void delete(Integer id) {
		userRepository.deleteById(id);
	}
	
	public Optional<CMUser> findById(Integer id) {
		return userRepository.findById(id);
	}
	
	public CMUser getOne(Integer id) {
		return userRepository.getOne(id);
	}
	
	public List<CMUser> findAll(){
		return userRepository.findAll();
	}
	
	
}

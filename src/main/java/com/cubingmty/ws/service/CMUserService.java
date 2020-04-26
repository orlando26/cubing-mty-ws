package com.cubingmty.ws.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cubingmty.ws.entity.CMUser;
import com.cubingmty.ws.entity.StandardResponse;
import com.cubingmty.ws.entity.catalogs.CMRole;
import com.cubingmty.ws.exceptions.EmptyValuesException;
import com.cubingmty.ws.repository.CMUserRepository;
import com.cubingmty.ws.util.CommonConstants;

@Service
public class CMUserService {
	
	@Autowired
	public PasswordEncoder passwordEncoder;
	
	@Autowired
	private CMUserRepository userRepository;
	
	public StandardResponse<CMUser> save(CMUser user) {
		user.setImage("avatar.png");
		List<CMRole> roles = new ArrayList<>();
		roles.add(new CMRole(3));
		user.setRoles(roles);
		StandardResponse<CMUser> response = new StandardResponse<CMUser>();
		try {
			if(user.checkEmpty()) throw new EmptyValuesException();

			user.setPassword(passwordEncoder.encode(user.getPassword()));
			response.setEntity(userRepository.save(user));
			response.setResponsetext("Usuario registrado!");
			response.setStatus(CommonConstants.RESPONSE_SUCCESS);
		} catch(DataIntegrityViolationException cve) {
			response.setEntity(user);
			response.setResponsetext("El correo " + user.getEmail() + " ya esta registrado");
			response.setStatus(CommonConstants.RESPONSE_ERROR);
		} catch (Exception e) {
			response.setEntity(user);
			response.setResponsetext(e.getMessage());
			response.setStatus(CommonConstants.RESPONSE_ERROR);
		}
		return response;
	}

	public StandardResponse<CMUser> registerTestUser(String name, String password, String wcaid){
		CMUser user = CMUser.builder()
		.name(name)
		.lastname(name)
		.nickname(name)
		.email(name + "@a.com")
		.password(password)
		.wcaId(wcaid)
		.stateId(19)
		.cityId(986)
		.birthday(new Date())
		.build();
		user.setImage("avatar.png");
		List<CMRole> roles = new ArrayList<>();
		roles.add(new CMRole(3));
		user.setRoles(roles);
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

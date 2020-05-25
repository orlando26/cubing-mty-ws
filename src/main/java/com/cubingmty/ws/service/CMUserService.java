package com.cubingmty.ws.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.cubingmty.ws.entity.AuthRequest;
import com.cubingmty.ws.entity.CMUser;
import com.cubingmty.ws.entity.StandardResponse;
import com.cubingmty.ws.entity.catalogs.CMRole;
import com.cubingmty.ws.jwt.JwtTokenProvider;
import com.cubingmty.ws.repository.CMUserRepository;
import com.cubingmty.ws.util.CommonConstants;

import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CMUserService {
	
	@Autowired
	public PasswordEncoder passwordEncoder;
	
	@Autowired
	private CMUserRepository userRepository;

	@Autowired
	private JwtTokenProvider tokenProvider;

	@Autowired
	AuthenticationManager authManager;
	
	public StandardResponse<CMUser> save(CMUser user) {
		user.setImage("avatar.png");
		List<CMRole> roles = new ArrayList<>();
		roles.add(new CMRole(3));
		user.setRoles(roles);
		StandardResponse<CMUser> response = new StandardResponse<CMUser>();
		try {
			user.checkEmpty();

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

	public StandardResponse<CMUser> authenticate(AuthRequest auth){
		StandardResponse<CMUser> response = new StandardResponse<>();
		try{
			auth.checkEmpty();
			UsernamePasswordAuthenticationToken authenticationToken = 
			new UsernamePasswordAuthenticationToken(auth.getUsername(), auth.getPassword());
			authManager.authenticate(authenticationToken);
			CMUser user = findByEmail(authenticationToken.getName()); 
			user.setToken(tokenProvider.generateToken(authenticationToken)); 

			response.setEntity(user);
			response.setStatus(CommonConstants.RESPONSE_SUCCESS);
			response.setResponsetext("Authenticated");
		} catch(BadCredentialsException e) {
			response.setEntity(null);
			response.setStatus(CommonConstants.RESPONSE_ERROR);
			response.setResponsetext("Usuario o password incorrecto");
		} catch (Exception e) {
			response.setEntity(null);
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
		.stateId(1)
		.cityId(1)
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
	
	public boolean pictureupload(Integer id, MultipartFile file) {
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("data:image/png;base64,");
			sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(file.getBytes(), false)));
			String imageBase64 = sb.toString();
			CMUser user = userRepository.getOne(id);
			user.setImage(imageBase64);
			userRepository.save(user);
			return true;
		}
		catch (IOException e) {
			LoggerFactory.getLogger(this.getClass()).error("pictureupload", e);
			return false;
		}

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

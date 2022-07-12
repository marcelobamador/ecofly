package br.com.ecofly.service.impl;


import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.ecofly.dto.User;
import br.com.ecofly.model.PilotEntity;
import br.com.ecofly.repository.PilotRepository;
import br.com.ecofly.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private PilotRepository pilotRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public void save(User user) {
		PilotEntity entity = new PilotEntity();
		entity.setFirstName(user.getName());
		entity.setLastName(user.getLastname());	
		entity.setEmail(user.getEmail());
		entity.setCode("ECO"); 
		entity.setLocation(user.getLocation());
		entity.setHub("SBGR");
		entity.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		entity.setSalt(null);
		entity.setRankId(1);
		entity.setRank("Candidato");
		entity.setRankLevel(1);
		entity.setJoinDate(new Date(0));
		entity.setLastIp(user.getIp());
		entity.setBgImage("background.png");
		pilotRepository.save(entity);
		
	}

	@Override
	public User findByEmail(String username) {
		PilotEntity pilot = pilotRepository.findByEmail(username);
		
		User user = null;
		if(pilot != null) {
			user = new User();
			user.setEmail(pilot.getEmail());
		}
		
		
		return user;
	}

}

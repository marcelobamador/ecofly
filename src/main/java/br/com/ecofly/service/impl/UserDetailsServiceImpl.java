package br.com.ecofly.service.impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ecofly.model.GroupsEntity;
import br.com.ecofly.model.PilotEntity;
import br.com.ecofly.repository.PilotRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	String userName;
	String password;
	
	@Autowired
	private PilotRepository pilotRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) {
		Optional<PilotEntity> pilot = pilotRepository.findByUserName(username);
		if(pilot == null) throw new UsernameNotFoundException(username);
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (GroupsEntity role : pilot.get().getGroups()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		pilot.ifPresent((opt) -> {
			userName = opt.getUserName();
			password = opt.getPassword();
		});
		
		return new User(userName, password, grantedAuthorities);
	}

}

package br.com.ecofly.service;

import br.com.ecofly.dto.User;

public interface UserService {
	
	void save(User user);
	
	User findByEmail(String username);

}

package br.com.ecofly.service;

import br.com.ecofly.dto.UserDTO;

public interface UserService {
	
	void save(UserDTO user);
	
	UserDTO findByEmail(String username);

}

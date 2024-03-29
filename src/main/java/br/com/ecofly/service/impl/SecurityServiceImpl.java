package br.com.ecofly.service.impl;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.ecofly.service.SecurityService;


@Service
public class SecurityServiceImpl implements SecurityService {

	@Override
	public boolean isAuthenticated() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || AnonymousAuthenticationToken.class.
            isAssignableFrom(authentication.getClass())) {
            return false;
        }
        return authentication.isAuthenticated();
	}

}

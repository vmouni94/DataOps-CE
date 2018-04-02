package com.rsrit.Dops.Server.Security;

/**
 * @author gn.teja created on 02/23/2017
 *
 */

import java.util.Arrays;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rsrit.Dops.Server.Model.UserModel.DataOps_User;
import com.rsrit.Dops.Server.Repository.UserRepository;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
	
	 private static final String ROLE_USER = "ROLE_USER";
	 
	 @Autowired
	  private UserRepository repository;
	 
	  public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException {
	        final DataOps_User user = repository.findByUserName(userName);
	 
	        if (user == null) {
	        	System.out.println("None found");
	            throw new UsernameNotFoundException("No user found with username: " + userName);
	        }
	        System.out.println(user.getPassword() +" "+user.getUserName());
	        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), true, true, true, true, getAuthorities(ROLE_USER));
	    }
	
	private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return Arrays.asList(new SimpleGrantedAuthority(role));
    }

}

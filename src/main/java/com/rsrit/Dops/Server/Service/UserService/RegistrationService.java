package com.rsrit.Dops.Server.Service.UserService;

/**
 * @author gn.teja created on 02/25/2017
 *
 */

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsrit.Dops.Server.Model.UserModel.DataOps_User;
import com.rsrit.Dops.Server.Repository.UserRepository;
import com.rsrit.Dops.Server.Validations.EmailExistsException;


@Service
@Transactional
public class RegistrationService implements IRegistrationService {
	
	
	@Autowired
	UserRepository repository;

	@Override
	public DataOps_User registerNewUser(final DataOps_User userDetails) throws EmailExistsException {	
		if (emailExist(userDetails.getUserEmail())) {
			System.out.println("duplicate Email -> email exists");
            throw new EmailExistsException ("There is an account with that email address: " + userDetails.getUserEmail());
        }
		System.out.println(userDetails);
		System.out.println("registering new User -> email exists not found");
		return repository.save(userDetails);
	}

    private boolean emailExist(String email) {
    		final DataOps_User userDetails = repository.findByUserEmail(email);
    		System.out.println("in verification");
    		System.out.println(userDetails);
        return userDetails != null;
    }	
}


package com.rsrit.Dops.Server.Service.UserService;

import com.rsrit.Dops.Server.Model.UserModel.DataOps_User;
import com.rsrit.Dops.Server.Validations.EmailExistsException;

public interface IRegistrationService {
	
	DataOps_User registerNewUser(DataOps_User userDetails) throws EmailExistsException;

}

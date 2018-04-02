package com.rsrit.Dops.Server.Repository;

/**
 * @author gn.teja created on 02/25/2017
 *
 */

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsrit.Dops.Server.Model.UserModel.DataOps_User;

public interface UserRepository extends JpaRepository <DataOps_User, Long> {
	
	DataOps_User findByUserEmail(String userEmail);
	DataOps_User findByUserName(String userName);

}

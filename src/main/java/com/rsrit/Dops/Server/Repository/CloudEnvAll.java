package com.rsrit.Dops.Server.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsrit.Dops.Server.Model.CloudEnv.Cloud_Environment;

public interface CloudEnvAll extends JpaRepository <Cloud_Environment, String> {

	
	//Cloud_Environment findByUserId(Long userId);
//	List<Cloud_Environment> findByUserId(Long userId);
	List<Cloud_Environment> findByUserName(String userName);
	
	
//	Cloud_Environment findOne(Long cloudId);
	
	//List<Cloud_Environment> findAll();
}

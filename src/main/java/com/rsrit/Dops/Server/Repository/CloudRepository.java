package com.rsrit.Dops.Server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsrit.Dops.Server.Model.CloudEnv.Cloud_Environment;

public interface CloudRepository extends JpaRepository <Cloud_Environment, String> {

	
	Cloud_Environment findByUserName(String userName);
//	List<Cloud_Environment> findByUserId(Long userId);
	//Cloud_Environment findByCloudId(Long cloudId);
	
	
//	Cloud_Environment findOne(Long cloudId);
	
	//List<Cloud_Environment> findAll();
}
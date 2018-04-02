package com.rsrit.Dops.Server.Service.CloudEnvService;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsrit.Dops.Server.Model.CloudEnv.Cloud_Environment;
import com.rsrit.Dops.Server.Repository.CloudRepository;


@Service
@Transactional
public class CloudService implements ICloudService {

	
	@Autowired
	CloudRepository repository;
	
	@Override
	public Cloud_Environment SaveNewCloud(final Cloud_Environment cloudenv) {
		return repository.save(cloudenv);
	}
	

//	@Override
//	public Cloud_Environment getNewCloud(final Cloud_Environment getcloudenv) {
//		// TODO Auto-generated method stub
//		//return repository.findcloudname(getcloudenv.getCloudname());
//		return null;
//		
//	}
}
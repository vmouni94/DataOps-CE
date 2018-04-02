package com.rsrit.Dops.Server.Service.CloudEnvService;

import com.rsrit.Dops.Server.Model.CloudEnv.Cloud_Environment;

public interface ICloudService {
	
	Cloud_Environment SaveNewCloud(	Cloud_Environment cloudenv);
}

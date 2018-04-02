package com.rsrit.Dops.Server.Service.AwsService;

/**
 * @author gn.teja created on 03/15/2017
 *
 */

import org.springframework.stereotype.Service;

import com.amazonaws.auth.BasicAWSCredentials;

@Service
public class AwsInstanceService {

	//environment variables 
	public static String accessKey = "AKIAJ3RZCPTAN3JMOJEA";
	public static String secretKey = "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";

	
	//instance variables --> region/ family/ number of instances/  keyname/ pemfile/ VPC/ subnet and securityGroup
	
	public static String imageID = "ami-4b814f22";
	public static String instanceType = "m1.small";
	public static int numOfInstances = 1;
	
//	public static String groupName = "sg-d4a84da2";
//	public static String keyName = "helloTest";
//	
//	public static Region region;
//	public static AmazonEC2Client ec2client;
//	public static AmazonRDSClient rdsclient;
	
//  Region region = "us-east-1"
	
	public static BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

}
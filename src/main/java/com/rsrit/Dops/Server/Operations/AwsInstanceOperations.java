package com.rsrit.Dops.Server.Operations;

/**
 * @author gn.teja created on 03/15/2017
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import com.amazonaws.auth.AWSStaticCredentialsProvider;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.DescribeKeyPairsResult;

import com.amazonaws.services.ec2.model.DescribeSecurityGroupsRequest;
import com.amazonaws.services.ec2.model.DescribeSecurityGroupsResult;
import com.amazonaws.services.ec2.model.SecurityGroup;

import com.amazonaws.services.ec2.model.CreateKeyPairRequest;
import com.amazonaws.services.ec2.model.CreateKeyPairResult;
import com.amazonaws.services.ec2.model.KeyPair;

import com.amazonaws.services.ec2.model.KeyPairInfo;
import com.amazonaws.services.ec2.model.RunInstancesRequest;
import com.amazonaws.services.ec2.model.RunInstancesResult;
import com.rsrit.Dops.Server.Service.AwsService.AwsInstanceService;

public class AwsInstanceOperations {

	@Autowired
	AwsInstanceService instCred;

	final AmazonEC2 ec2 = AmazonEC2ClientBuilder.standard()
			.withCredentials(new AWSStaticCredentialsProvider(AwsInstanceService.credentials)).withRegion("us-east-1")
			.build();

	String testSecurityGroup ; 
	
	// public static void main(String[] args) throws Exception {
	// 	AwsInstanceOperations m = new AwsInstanceOperations();

	// 	m.createEC2Instances();
	// 	//m.createNewKeyPair("sdkTestKeyPai6");
	// 	//m.describeExistingKeyPairs();
	// 	m.describeExistingSecurityGroups("sg-e0a8d196");
	// }

	public Object createEC2Instances() {

		try {

			RunInstancesRequest runInstancesRequest = new RunInstancesRequest();

			runInstancesRequest.withImageId(AwsInstanceService.imageID) 
					.withInstanceType(AwsInstanceService.instanceType)
					.withMinCount(AwsInstanceService.numOfInstances)
					.withMaxCount(AwsInstanceService.numOfInstances)
					.withKeyName("helloTest")
					.withSecurityGroups("TestforSdk");
			
			RunInstancesResult result = ec2.runInstances(runInstancesRequest);
			System.out.println("---------Created Instance Successfully --------------");
			System.out.println(result);
			return null;
		} catch (Exception e) {
			System.out.println("Oops.... failed in createEC2Instances method ");
			e.printStackTrace();

			System.exit(0);
			return null;
		}

	}

	public void describeExistingSecurityGroups(String group_id) {

		try {

			DescribeSecurityGroupsRequest request = new DescribeSecurityGroupsRequest().withGroupIds(group_id);

			DescribeSecurityGroupsResult response = ec2.describeSecurityGroups(request);

			for (SecurityGroup group : response.getSecurityGroups()) {
				
				System.out.println("Found security group with Name "+ group.getGroupName() +" with id "+ group.getGroupId() + " vpc id "+ group.getVpcId() + " and description " + group.getDescription());
				System.out.println("//////////////////////////");
				testSecurityGroup = group.getGroupName();
				System.out.println(group.getOwnerId());
				System.out.println("//////////////////////////");
				
			}

		} catch (Exception e) {

			System.out.println("Oops.... failed in describeExistingSecurityGroups method ");
			e.printStackTrace();
			System.exit(0);
		}

	}

	public void describeExistingKeyPairs() {
		try {

			DescribeKeyPairsResult response = ec2.describeKeyPairs();

			for (KeyPairInfo key_pair : response.getKeyPairs()) {
				System.out.printf("Found key pair with name %s " + "and fingerprint %s", 
						key_pair.getKeyName(), key_pair.getKeyFingerprint());
			}

		} catch (Exception e) {
			System.out.println("Oops.... failed in describingExistingKeyPairs method ");
			e.printStackTrace();
			System.exit(0);
		}

	}

	public void createNewKeyPair(String key_name) {
		
		   KeyPair keyPairVal = new KeyPair();
		   
	try {
		
		CreateKeyPairRequest request = new CreateKeyPairRequest().withKeyName(key_name);
		CreateKeyPairResult response = ec2.createKeyPair(request);
		System.out.println("Successfully created key pair named " + key_name);
		
		//Describing KeyPair.........
		keyPairVal = response.getKeyPair();
		System.out.println(keyPairVal.getKeyMaterial());  
		// join the methods to save the file in DB and to download the file
		
				
	} catch(Exception e) {
		
		System.out.println("Oops.... failed in createNewKeyPair method ");
		e.printStackTrace();
		System.exit(0);
		
		}
	}
	
	public void createNewSecurityGroup() {

	}

	public void checkRegions() {

	}

}

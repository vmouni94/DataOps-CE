package com.rsrit.Dops.Server.Model.UserModel;

import java.util.Set;

import javax.persistence.CascadeType;

/**
 * @author gn.teja created on 02/25/2017
 *
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.rsrit.Dops.Server.Model.CloudEnv.Cloud_Environment;

@Entity
@Table(name = "DataOps_User")
public class DataOps_User {
	
	//@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;	
	private String userFullName;	
	@Column(name = "email", nullable = false, unique = true, updatable = true)
	private String userEmail;	
	private String userRole;
	private String userCountry;
	
	@Id
	private String userName;
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="userName")
	private Set<Cloud_Environment> Cloud_Environment;
	    

	public Set<Cloud_Environment> getCloud_Environment() {
	        return Cloud_Environment;
	    }


	public void setCloud_Environment(Set<Cloud_Environment> cloud_Environment) {
	        Cloud_Environment = cloud_Environment;
	    }
	

	public DataOps_User() {
		super();
		
	}


	public DataOps_User(String userFullName, String userEmail, 
			String userRole, String userCountry, String userName, String password) {
		super();
		this.userFullName = userFullName;
		this.userEmail = userEmail;
		this.userRole = userRole;
		this.userCountry = userCountry;
		this.userName = userName;
		this.password = password;
	}


	public String getUserFullName() {
		return userFullName;
	}


	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getUserRole() {
		return userRole;
	}


	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}


	public String getUserCountry() {
		return userCountry;
	}


	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "DataOps_User [userFullName=" + userFullName + ", userEmail=" + userEmail + ", userRole=" + userRole
				+ ", userCountry=" + userCountry + ", userName=" + userName + ", password=" + password + "]";
	}
	


}

package com.rsrit.Dops.Server.Model.CloudEnv;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cloud_Environment")
public class Cloud_Environment {

	private String cloudname;
	private String cloudenv;
	private Long accesskey;
	private Long secretkey;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cloudId;
	private String userName;

	public Long getCloudId() {
		return cloudId;
	}

	public void setCloudId(Long cloudId) {
		this.cloudId = cloudId;
	}

	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	//private Long userId;

	// @ManyToOne
	// private DataOps_User DataOps_User;
	// data_ops_user_user_id
	
	

	public String getCloudname() {
		return cloudname;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setCloudname(String cloudname) {
		this.cloudname = cloudname;
	}

	public String getCloudenv() {
		return cloudenv;
	}

	public void setCloudenv(String cloudenv) {
		this.cloudenv = cloudenv;
	}

	public Long getAccesskey() {
		return accesskey;
	}

	public void setAccesskey(Long accesskey) {
		this.accesskey = accesskey;
	}

	public Long getSecretkey() {
		return secretkey;
	}

	public void setSecretkey(Long secretkey) {
		this.secretkey = secretkey;
	}

	/*public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}*/

	public Cloud_Environment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cloud_Environment(String cloudname, String cloudenv, Long accesskey, Long secretkey, Long cloudId,
			String userName) {
		super();
		this.cloudname = cloudname;
		this.cloudenv = cloudenv;
		this.accesskey = accesskey;
		this.secretkey = secretkey;
		this.cloudId = cloudId;
		this.userName =  userName;
		//this.userId = userId;
	}

	// public DataOps_User getDataOps_User() {
	// return DataOps_User;
	// }
	//
	// public void setDataOps_User(DataOps_User dataOps_User) {
	// DataOps_User = dataOps_User;
	// }

}

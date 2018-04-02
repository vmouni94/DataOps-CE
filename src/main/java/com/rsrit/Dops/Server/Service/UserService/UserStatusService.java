package com.rsrit.Dops.Server.Service.UserService;

/**
 * @author gn.teja created on 03/22/2017
 *
 */

public class UserStatusService {
	
	private String message;
	private Boolean isUserSessionActive;
	
	public UserStatusService(Boolean bool, String string) {
		message = string;
		isUserSessionActive = bool;
	}
	
	public Boolean getIsUserSessionActive() {
		return isUserSessionActive;
	}

	public void setIsUserSessionActive(Boolean isUserSessionActive) {
		this.isUserSessionActive = isUserSessionActive;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String text) {
		this.message = text;
	}

}

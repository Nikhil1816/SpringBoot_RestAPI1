package com.client.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;



public class UserResponse {
	
	
	private User[] data;
	
	
	public User[] getData() {
		return data;
	}
	public void setData(User[] data) {
		this.data = data;
	}
	
}

package com.client.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.client.model.User;
import com.client.model.UserResponse;

@Service
public class UserService {

	private final RestTemplate restTemplate;

	@Autowired
	public UserService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public UserResponse consumeAPI() {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		UserResponse userResponse = restTemplate.getForObject("https://reqres.in/api/users", UserResponse.class, headers);
		return userResponse;
	}
	public UserResponse consumeAPI1(int id) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		UserResponse userResponse = restTemplate.getForObject("https://reqres.in/api/users/"+id, UserResponse.class, headers);
		return userResponse;
	}


	public User saveEmp(User user) {
		HttpHeaders headers = new HttpHeaders();

		HttpEntity<User> entity = new HttpEntity<>(user, headers);
		return restTemplate.exchange("https://reqres.in/api/users", HttpMethod.POST, entity, User.class).getBody();

	}

	public void delete(int id) {
		
		restTemplate.exchange("https://reqres.in/api/users/"+id,HttpMethod.DELETE,null,Void.class);
		
	}

	public User updateUsers(User user,int id) {
		HttpHeaders headers = new HttpHeaders();

		HttpEntity<User> entity = new HttpEntity<>(user, headers);
		return restTemplate.exchange("https://reqres.in/api/users/"+id, HttpMethod.PUT, entity, User.class).getBody();

	}

}

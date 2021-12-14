package com.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.client.model.User;
import com.client.service.UserService;

@RestController
public class UserController {

   private final UserService userService;
   
   @Autowired
   public UserController(UserService userService) {
	   this.userService=userService;
   }
   @GetMapping("/users")
   public ResponseEntity<?> getData() {
	  return new ResponseEntity<>(userService.consumeAPI(), HttpStatus.OK);
   }
   @GetMapping("/users/{id}")
   public ResponseEntity<?> getData1(@PathVariable int id) {
	   return new ResponseEntity<>(userService.consumeAPI1(id), HttpStatus.OK);
   }
   
  @PostMapping("/a")
  public ResponseEntity saveUser(@RequestBody User user) {
	  user = userService.saveEmp(user);
	  return ResponseEntity.status(HttpStatus.CREATED).body(user);
  }
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable int id) {
		userService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
  @PutMapping("/users/{id}")
  public ResponseEntity updateUser(@RequestBody User user,int id) {
	  user = userService.updateUsers(user,id);
	  return ResponseEntity.status(HttpStatus.CREATED).body(user);
  }
}

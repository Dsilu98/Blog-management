package com.debakanta.blog.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.debakanta.blog.entities.User;
import com.debakanta.blog.payload.ApiResponce;
import com.debakanta.blog.payload.UserDto;
import com.debakanta.blog.services.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("api/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	//POST-create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<UserDto>(createUserDto,HttpStatus.CREATED);
	}
	
	//PUT-upadte user
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable Integer id, @RequestBody UserDto userDto) {
		UserDto updatedUserDto = this.userService.updateUser(userDto, id);
		return ResponseEntity.ok(updatedUserDto);
	}
	//DELETE-delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponce> deleteUser(@PathVariable Integer userId){
		this.userService.deleteUser(userId);
		String message = String.format("User having user id: %s has been deleted successfully!!",userId);
		ApiResponce apiResponce = new ApiResponce(message, true);
		return new ResponseEntity(apiResponce,HttpStatus.OK);
	}
	//GET-get user
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return new ResponseEntity<List<UserDto>>(this.userService.getAllUsers(),HttpStatus.OK);
	}
	//GET-get user
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
		return new ResponseEntity<UserDto>(this.userService.getUserById(userId),HttpStatus.FOUND);
	}
	
}

package com.gevbagratunyan.school.controllers;

import com.gevbagratunyan.school.entity.models.User;
import com.gevbagratunyan.school.service.services.UserService;
import com.gevbagratunyan.school.transfer.user.request.*;
import com.gevbagratunyan.school.transfer.user.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@Validated
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("")
	public UserResponse addUser(@Valid @RequestBody UserAddRequest userAddRequest) {
		return userService.add(userAddRequest);
	}

	@GetMapping("/{id}")
	public UserResponse getUser(@PathVariable Long id) {
		return userService.get(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.delete(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("")
	public ResponseEntity<List<User>> getUsers() {
		List<User>  users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public UserResponse updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateRequest updateRequest) {
		return userService.update(id, updateRequest);
	}
}

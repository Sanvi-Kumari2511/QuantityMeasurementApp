package com.apps.quantitymeasurement.controller;

import com.apps.quantitymeasurement.auth.entity.User;
import com.apps.quantitymeasurement.security.JwtUtil;
import com.apps.quantitymeasurement.service.CustomUserDetailsService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private CustomUserDetailsService userService;

	@PostMapping("/register")
	public Map<String, String> register(@RequestBody User user) {

		userService.registerUser(user.getUsername(), user.getPassword(), "USER");

		return Map.of("message", "User registered successfully");
	}

	@PostMapping("/login")	
	public ResponseEntity<?> login(@RequestBody User user) {
	    try {
	        authManager.authenticate(
	            new UsernamePasswordAuthenticationToken(
	                user.getUsername(),
	                user.getPassword()
	            )
	        );

	        String token = jwtUtil.generateToken(user.getUsername());
	        return ResponseEntity.ok(Map.of("token", token));

	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                .body(Map.of("error", "Invalid credentials"));
	    }
	}
}
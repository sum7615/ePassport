package com.passport.controller;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.passport.dto.ResgistrationResponseDto;
import com.passport.dto.SingleUserReturn;
import com.passport.dto.UserChangePasswordDto;
import com.passport.dto.UserDTO;
import com.passport.dto.UserUpdateDTO;
import com.passport.entity.Users;
import com.passport.exception.UserAlreadyExistException;
import com.passport.exception.UserNotFoundException;
import com.passport.service.UserService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	Logger log = LoggerFactory.getLogger(Users.class);

	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@DeleteMapping("/user")
	public String deleteuser(@RequestBody UserDTO userDto) throws UserNotFoundException {
//		return userService.deleteuser(userDto.getId());
		Long userId = userDto.getId();
	        String result = userService.deleteuser(userId);
	        return result;
	   
	    }

		@GetMapping("/register")
		public String register() {
			return "register.html";
		}
		@PostMapping("/register")
		public String registerSave() {
			return "home.html";
		}

	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN') || hasRole('ROLE_USER')")
	@PutMapping("/user")
	public Users updateUser(@Valid @RequestBody UserUpdateDTO userDto) throws UserNotFoundException{
//		return userService.updateUser(userDto);
        Users updatedUser = userService.updateUser(userDto);
        return updatedUser;
	}

	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN') || hasRole('ROLE_USER')")
	@PostMapping("/change-password")
	public String changePassword(@Valid @RequestBody UserChangePasswordDto userChangePasswordDto)throws UserNotFoundException {
		return userService.changePassword(userChangePasswordDto);
	   
	}
	
	
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@GetMapping("/users")
	public List<ResgistrationResponseDto> alluser(){
		return userService.alluser();

	}
	@SecurityRequirement(name = "Bearer Authentication")
	@PreAuthorize(value = "hasRole('ROLE_ADMIN') || hasRole('ROLE_USER')")
	@GetMapping("/user/{id}")
	public SingleUserReturn user(@PathVariable long id) throws UserNotFoundException{
		return userService.user(id);
	}


	@PostMapping("/register")
	public ResponseEntity<Object> register(@Valid @RequestBody UserDTO userDto, BindingResult result)
			throws TransactionSystemException, UserAlreadyExistException {
		if (result.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			result.getFieldErrors()
					.forEach(error -> sb.append(error.getField() + ": " + error.getDefaultMessage() + "\n"));
			return ResponseEntity.badRequest().body(sb.toString());
		}
		// converting DTO to entity
		Users user = new Users();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setDob(userDto.getDob());
		user.setGender(userDto.getGender());
		user.setPresentAddress(userDto.getPresentAddress());
		user.setPermanentAddress(userDto.getPermanentAddress());
		String encryptedPassword = new BCryptPasswordEncoder().encode(userDto.getPassword());
		user.setPassword(encryptedPassword);
		user.setUsername(userDto.getUsername());
		user.setPhone(userDto.getPhone());
		user.setRoles(userDto.getRoles());
		ResgistrationResponseDto savedUser = userService.register(user);
		
		//calling service 
		return ResponseEntity.ok(savedUser);
	}
}
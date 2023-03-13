package com.passport.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.PathVariable;

import com.passport.dto.ResgistrationResponseDto;
import com.passport.dto.SingleUserReturn;
import com.passport.dto.UserChangePasswordDto;
import com.passport.dto.UserUpdateDTO;
import com.passport.entity.Users;
import com.passport.exception.UserAlreadyExistException;
import com.passport.exception.UserNotFoundException;

@Service
public interface UserService {
	public ResgistrationResponseDto register(Users user)throws TransactionSystemException, UserAlreadyExistException;
	public String deleteuser(Long id) throws UserNotFoundException;
	public Users updateUser(UserUpdateDTO updatedUser) throws UserNotFoundException;
	public String changePassword(UserChangePasswordDto userChangePasswordDto)throws UserNotFoundException;
	public List<ResgistrationResponseDto> alluser();
	SingleUserReturn user(@PathVariable long id) throws UserNotFoundException;	
	
}

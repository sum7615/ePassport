package com.passport.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import com.passport.dto.ResgistrationResponseDto;
import com.passport.dto.SingleUserReturn;
import com.passport.dto.UserChangePasswordDto;
import com.passport.dto.UserUpdateDTO;
import com.passport.entity.Users;
import com.passport.exception.UserAlreadyExistException;
import com.passport.exception.UserNotFoundException;
import com.passport.repository.UserRepository;
import com.passport.repository.UsersRepository;
import com.passport.service.UserService;



@Service
public class UserServiceimpl implements UserService 
{
	@Autowired
    UsersRepository userRepository;  
	@Override
	public ResgistrationResponseDto register(Users user) throws TransactionSystemException, UserAlreadyExistException 
	{
		if (userRepository.findByUsername(user.getUsername()).isEmpty()) {
			userRepository.save(user);
			ResgistrationResponseDto dto = new ResgistrationResponseDto();
			dto.setPresentAddress(user.getPresentAddress());
			dto.setPermanentAddress(user.getPermanentAddress());
			dto.setId(userRepository.findByUsername(user.getUsername()).get().getId());
			dto.setGender(user.getGender());
			dto.setDob(user.getDob());
			dto.setName(user.getName());
			dto.setPhone(user.getPhone());
			dto.setRoles(user.getRoles());
			dto.setUsername(user.getUsername());

			return dto;

		} else {

			throw new UserAlreadyExistException("User is already registered");

		}

	}

	@Override
	public String deleteuser(Long id) throws UserNotFoundException {
		Users user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User Not Found"));

		userRepository.deleteById(id);
		return "Deleted Successfully";

	}

	@Override
	public Users updateUser(UserUpdateDTO updatedUser) throws UserNotFoundException
	{
		Users user = userRepository.findById(updatedUser.getId())
				.orElseThrow(() -> new UserNotFoundException("User Not Found"));

		user.setName(updatedUser.getName());
		user.setPhone(updatedUser.getPhone());
//		user.setAddress(updatedUser.getAddress());
		userRepository.save(user);

		return user;

	}

	@Override
	public String changePassword(UserChangePasswordDto userChangePasswordDto) throws UserNotFoundException {

		Users user = userRepository.findById(userChangePasswordDto.getId())
				.orElseThrow(() -> new UserNotFoundException("User Not Found"));
		user.setId(userChangePasswordDto.getId());
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(userChangePasswordDto.getPassword());
		
		user.setPassword(encryptedPassword);
		userRepository.save(user);

		return "Password Changed";

	}

	@Override
	public List<ResgistrationResponseDto> alluser(){

			List<Users> user = userRepository.findAll();
			List<ResgistrationResponseDto> alluser = user.stream()
					.map(u -> new ResgistrationResponseDto(u.getGender(),u.getUsername(),u.getDob(),u.getGender(), u.getPhone(),
							u.getPresentAddress(), u.getPermanentAddress(), u.getPassword(), u.getRoles()))
			  
			    .collect(Collectors.toList());
			
			
			return alluser;
			
		
	}

	@Override
	public SingleUserReturn user(long id) throws UserNotFoundException {
		Users user = userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User Not Found"));
		SingleUserReturn resturnUser = new SingleUserReturn();
		
		resturnUser.setPermanentAddress(user.getPermanentAddress());
		resturnUser.setPresentAddress(user.getPresentAddress());
		resturnUser.setId(user.getId());
		resturnUser.setDob(user.getDob());
		resturnUser.setName(user.getName());
		resturnUser.setGender(user.getGender());
		resturnUser.setPhone(user.getPhone());
		resturnUser.setUsername(user.getUsername());
		resturnUser.setRoles(user.getRoles());
		return resturnUser;
		
	}

	
}

package com.passport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.passport.dto.PassportOfficeDto;
import com.passport.entity.PassportOffice;
import com.passport.exception.AppointmentNotFoundException;
import com.passport.service.PassportOfficeService;

import jakarta.validation.Valid;

@RestController
public class PassportofficeController {
	
	@Autowired
	private PassportOfficeService passportOfficeService;
	
	@PostMapping("/passportoffice")
	public String add_passportoffice(@Valid @RequestBody PassportOffice passportOffice) {
	    String response= passportOfficeService.add_passportoffice(passportOffice);
	    return response;
	}
	
	@GetMapping("/passportoffice")
	public List<PassportOfficeDto> list_passportoffice(){
	 return	passportOfficeService.list_passportoffice();
	}
	 
	@DeleteMapping("/passportoffice")
	public String delete_passportoffice(@RequestBody PassportOfficeDto passportOfficeDto) throws AppointmentNotFoundException{
		String response= passportOfficeService.delete_passportoffice(passportOfficeDto.getId());
		return response;
	}
	
	@PutMapping("/passportoffice")
	public String update_passportoffice(@Valid @RequestBody PassportOffice passportOffice)throws AppointmentNotFoundException{
		String response = passportOfficeService.update_passportoffice(passportOffice);
		return response;
		
	}

}

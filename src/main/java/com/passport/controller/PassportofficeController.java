package com.passport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.passport.dto.PassportOfficeDto;
import com.passport.service.PassportOfficeService;

@RestController
public class PassportofficeController {
	
	@Autowired
	private PassportOfficeService passportOfficeService;
	
	@PostMapping("/appointment")
	public String add_Appointment(@RequestBody PassportOfficeDto passportOfficeDto) {
	    String response= passportOfficeService.add_Appointment(passportOfficeDto);
	    return response;
	}

}

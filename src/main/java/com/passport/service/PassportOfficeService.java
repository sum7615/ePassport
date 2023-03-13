package com.passport.service;

import org.springframework.stereotype.Service;

import com.passport.dto.PassportOfficeDto;

@Service
public interface PassportOfficeService {


	String add_Appointment(PassportOfficeDto passportOfficeDto);


}

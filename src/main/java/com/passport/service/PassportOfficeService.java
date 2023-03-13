package com.passport.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.passport.dto.PassportOfficeDto;
import com.passport.entity.PassportOffice;
import com.passport.exception.AppointmentNotFoundException;

@Service
public interface PassportOfficeService {


	String add_passportoffice(PassportOffice passportOffice);

	List<PassportOfficeDto> list_passportoffice();

	String delete_passportoffice(Long id)throws AppointmentNotFoundException;

	String update_passportoffice(PassportOffice passportOffice)throws AppointmentNotFoundException;


}

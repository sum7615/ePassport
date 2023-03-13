package com.passport.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passport.dto.PassportOfficeDto;
import com.passport.entity.PassportOffice;
import com.passport.exception.AppointmentNotFoundException;
import com.passport.repository.PassportOfficeRepository;
import com.passport.service.PassportOfficeService;

@Service
public class PassportOfficeServiceImpl implements PassportOfficeService {
	
	@Autowired
	private PassportOfficeRepository passportOfficeRepository;

	@Override
	public String add_passportoffice(PassportOffice passportOffice) {
		passportOfficeRepository.save(passportOffice);
		
		return "PassportOffice details added succesfully";
		
	}

	@Override
	public List<PassportOfficeDto> list_passportoffice() {
		List<PassportOffice> passportOffices= passportOfficeRepository.findAll();
		
		return passportOffices.stream().map(ex ->{
			PassportOfficeDto passportOfficeDto= new PassportOfficeDto();
			passportOfficeDto.setId(ex.getId());
			passportOfficeDto.setOfficeName(ex.getOfficeName());
			passportOfficeDto.setJurisdictionName(ex.getJurisdictionName());
			passportOfficeDto.setAddress(ex.getAddress());
			passportOfficeDto.setPhoneNumber(ex.getPhoneNumber());
					return passportOfficeDto;
				}).collect(Collectors.toList());
	}

	@Override
	public String delete_passportoffice(Long id) throws AppointmentNotFoundException {
	     PassportOffice passportOffice= passportOfficeRepository.findById(id).orElseThrow(()-> new AppointmentNotFoundException("PassportOffice id is not valid, please give a valid id"));
	     passportOfficeRepository.deleteById(id);
	     return "Passport Details deleted successfuilly";
	}

	@Override
	public String update_passportoffice(PassportOffice passportOffice) throws AppointmentNotFoundException {
	PassportOffice office = passportOfficeRepository.findById(passportOffice.getId()).orElseThrow(() -> new AppointmentNotFoundException("Appointment id is not valid"));
	  office.setOfficeName(passportOffice.getOfficeName());
	  office.setJurisdictionName(passportOffice.getJurisdictionName());
	  office.setAddress(passportOffice.getAddress());
	  office.setPhoneNumber(passportOffice.getPhoneNumber());
	  passportOfficeRepository.save(office);
	  return "PassportOffice details updated successfully";
	}
	



}

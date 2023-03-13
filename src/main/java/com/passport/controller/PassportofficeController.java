package com.passport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.passport.dto.PassportOfficeDto;
import com.passport.entity.PassportOffice;
import com.passport.exception.AppointmentNotFoundException;
import com.passport.repository.PassportOfficeRepository;
import com.passport.service.PassportOfficeService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PassportofficeController {

	@Autowired
	private PassportOfficeService passportOfficeService;

	private PassportOfficeRepository passportOfficeRepository;

	@GetMapping("/passportoffice")
	public String list_passportoffice(Model m) {
		m.addAttribute("office", passportOfficeService.list_passportoffice());
		return "office.html";
	}

	@GetMapping("/addPassportoffice")
	public String addPassportoffice() {
		return "AddPassportoffice.html";
	}

	@PostMapping("/addPassportOffice")
	public String add_passportoffice(@Valid @RequestBody PassportOffice passportOffice, Model m) {
		passportOfficeService.add_passportoffice(passportOffice);
		List<PassportOffice> office = passportOfficeRepository.findAll();
		m.addAttribute("office", office);
		return "office.html";
	}

	@DeleteMapping("/passportoffice")
	public String delete_passportoffice(@RequestBody PassportOfficeDto passportOfficeDto)
			throws AppointmentNotFoundException {
		String response = passportOfficeService.delete_passportoffice(passportOfficeDto.getId());
		return response;
	}

	@PutMapping("/passportoffice")
	public String update_passportoffice(@Valid @RequestBody PassportOffice passportOffice)
			throws AppointmentNotFoundException {
		String response = passportOfficeService.update_passportoffice(passportOffice);
		return response;

	}

}

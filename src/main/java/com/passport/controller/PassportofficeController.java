package com.passport.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	@Autowired
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
	@GetMapping("/editPassportoffice/{id}")
	public String editPassportoffice(@PathVariable(value="id") long id, Model m) {
		PassportOffice office = passportOfficeRepository.findById(id).get();
		m.addAttribute("office",office);
		return "editPassportoffice.html";
	}

	
	
	
	@PostMapping("/addPassportOffice")
	public String add_passportoffice(@Valid @ModelAttribute("passportOffice") PassportOffice passportOffice, Model m) {
		passportOfficeService.add_passportoffice(passportOffice);
		return "redirect:/passportoffice";
	}

	@GetMapping("/deletepassportoffice/{id}")
	public String delete_passportoffice(@PathVariable(value="id") long id)
			throws AppointmentNotFoundException {
		String response = passportOfficeService.delete_passportoffice(id);
		return "redirect:/passportoffice";
	}

	@PostMapping("/editpassportoffice")
	public String update_passportoffice(@Valid @ModelAttribute("passportOffice") PassportOffice passportOffice)
			throws AppointmentNotFoundException {
		String response = passportOfficeService.update_passportoffice(passportOffice);
		return "redirect:/passportoffice";

	}

}

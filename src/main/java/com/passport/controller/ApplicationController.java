package com.passport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.passport.entity.Application;
import com.passport.repository.ApplicationRepository;

@Controller
public class ApplicationController {
	@Autowired
	private ApplicationRepository applicationRepository;

	@GetMapping("/application")
	public String application() {
		return "application";
	}
	@GetMapping("/apply")
	public String apply(Model m) {
		List<Application> allApp = applicationRepository.findAll();
		m.addAttribute("app",allApp);
		return "apply";
	}
	@PostMapping("/application")
	public Application saveApplication(@ModelAttribute Application application) {
		Application lastApp = applicationRepository.findByAadhar(application.getAadhar());
		if(lastApp==null)	{
			applicationRepository.save(application);
		}
		return application;
	}
}

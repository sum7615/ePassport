package com.passport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class UserController {
@GetMapping("/register")
public String register() {
	return "register.html";
}
@PostMapping("/register")
public String registerSave() {
	return "home.html";
}
}

package com.drew.jat.auction.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drew.jat.auction.entity.User;
import com.drew.jat.auction.service.UserService;

@RequestMapping("/register")
@Controller
public class RegisterController {

	@Autowired
	private UserService userService;

	@ModelAttribute("_user")
	public User constructUser() {
		return new User();
	}
	
	@RequestMapping
	public String showRegister() {

		return "user-register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doRegister(@Valid @ModelAttribute("_user") User user, BindingResult result) {

		if (result.hasErrors()) {
			return "user-register";
		}

		userService.save(user);
		return "redirect:/register.html?success=true";
	}

	@RequestMapping("/available")
	@ResponseBody
	public String available(@RequestParam String username){
		
		Boolean availableBoolean = userService.findOne(username) == null;
		return availableBoolean.toString();
	}
	
}

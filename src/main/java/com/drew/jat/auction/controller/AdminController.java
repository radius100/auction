package com.drew.jat.auction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.drew.jat.auction.service.UserService;

@RequestMapping("/users")
@Controller
public class AdminController {

	@Autowired
	private UserService userService;

	
	@RequestMapping
	public String users(Model model) {

		model.addAttribute("users", userService.findAll());
		return "users";
	}

	@RequestMapping("/{id}")
	public String detail(Model model, @PathVariable int id) {

		model.addAttribute("user", userService.findOneWithBlogs(id));
		return "user-detail";
	}

	@RequestMapping("/remove/{id}")
	private String removeUser(@PathVariable int id) {

		userService.delete(id);
		return "redirect:/users.html";
	}
}


package com.ocsen.producer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ocsen.producer.services.Produder;

@Controller
public class HomeController {

	@Autowired
	private Produder producer;
	@GetMapping("/")
	public String index() {
		return "home/index";
	}
	
	@GetMapping("/send")
	public String send(@RequestParam("msg")String msg, Model model) {
		producer.send(msg);
		model.addAttribute("message", msg);
		return "home/send";
	}
}

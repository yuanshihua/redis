package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.User;
import com.example.demo.service.RedisService;

@Controller
public class RedisController {
	@Autowired
	private RedisService service;
	
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/redis",method=RequestMethod.POST)
	public String serializeUser(User u,Model model) {
		service.serialize(u);
		model.addAttribute("id","user:"+u.getId());
		return "getUser";
	}
	
	@RequestMapping(value="/getuser",method=RequestMethod.GET)
	@ResponseBody
	public String getUser(String id) {
		User u = service.getUser(id);
		return u.toString();
	}
}

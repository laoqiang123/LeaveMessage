package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.test.domain.Reply;

/**
 * 
 * @author laoqiang
 *
 */
@Controller
@RequestMapping(value = "/reply")
public class ReplyController {
	@RequestMapping(method = RequestMethod.GET, value = "/h1")
	public String initReply(ModelMap model) {
		model.addAttribute("reply", new Reply());
		return "reply";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/h2")
	public String addReply(ModelMap model) {
		model.addAttribute("reply", new Reply());
		return "addreply";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/h3")
	public String submitReply(ModelMap model) {
		model.addAttribute("reply", new Reply());
		return "reply";
	}

}

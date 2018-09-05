package com.green.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.green.spring.entity.Contact;
import com.green.spring.entity.EmailContact;
import com.green.spring.entity.PhoneContact;
import com.green.spring.model.ContactModel;
import com.green.spring.model.HomeModel;
import com.green.spring.service.ContactService;

@Controller
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		List<Contact> contacts = contactService.findAll();
		List<EmailContact> email = contactService.findAllEmail();
		List<PhoneContact> phone = contactService.findAllPhone();
		model.addAttribute("contacts", contacts);
		model.addAttribute("email", email);
		model.addAttribute("phone", phone);
		return "home";
	}
	
	
}

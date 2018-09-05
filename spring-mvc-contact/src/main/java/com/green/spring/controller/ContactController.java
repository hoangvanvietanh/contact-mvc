package com.green.spring.controller;

import java.util.List;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.spring.entity.Contact;
import com.green.spring.entity.EmailContact;
import com.green.spring.entity.PhoneContact;
import com.green.spring.model.ContactModel;
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
	
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		
		ContactModel contact = new ContactModel();
		model.addAttribute("contact", contact);
		
		model.addAttribute("mode", "create");
		
		return "contact-detail";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String handleCreate(@ModelAttribute("contact") ContactModel contact, 
			BindingResult result, Model model) {
		System.out.println("Id: " +contact.getId_contact()+contact.getName_contact() + contact.getAddress_contact());
		// validate inputed contact info and convert to entity
		if (result.hasErrors()) {
			return "contact-detail";
		}
		
		// save contact info
		Contact c = contact.toContact();
		contactService.createContact(c);
		
		// back to contact list page
		return "redirect:/contact";
	}
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@RequestParam(name="contactId") int contactId, Model model) {
		Contact c = contactService.findContact(contactId);

		if (c == null) {
			return "redirect:/contact";
		}
		ContactModel contactModel = new ContactModel();
		contactModel.fromContact(c);
		model.addAttribute("contact", contactModel);
		model.addAttribute("mode", "update");
		
		return "contact-detail";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String handleUpdate(@RequestParam(name="contactId") Long contactId,
			@ModelAttribute("contact") ContactModel contact, 
			BindingResult result, Model model) {
		
		// validate inputed contact info and convert to entity
		if (result.hasErrors()) {
			return "contact-detail";
		}
		
		// save contact info
		Contact c = contact.toContact();
		contactService.updateContact(c);
		
		// back to contact list page
		return "redirect:/contact";
	}
}

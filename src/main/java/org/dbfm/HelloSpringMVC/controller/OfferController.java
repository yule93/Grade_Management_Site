package org.dbfm.HelloSpringMVC.controller;

import java.util.List;

import org.dbfm.HelloSpringMVC.model.Offer;
import org.dbfm.HelloSpringMVC.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.*;

@Controller
public class OfferController {

	@Autowired
	private OfferService offerservice;
	
	@RequestMapping("/offers")
	public String showOffers (Model model) {
		List<Offer> offers = offerservice.getCurrent();
		model.addAttribute("offers", offers);
		
		return "offers";
	}
	
	@RequestMapping("/createoffer")
	public String createOffer (Model model) {
		
		model.addAttribute("offer", new Offer());
		
		return "createoffer";
	}
	
	@RequestMapping("/docreate")
	public String doCreate (Model model, @Valid Offer offer, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("===Form data does not validated.");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error:errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "createoffer";
		}
		
		offerservice.insert(offer);
		return "offercreated";
	}
}

package org.dbfm.HelloSpringMVC.service;

import java.util.List;

import org.dbfm.HelloSpringMVC.dao.OfferDAO;
import org.dbfm.HelloSpringMVC.model.Offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

	@Autowired
	private OfferDAO offerDao;
	
	public List<Offer> getCurrent() {
		return offerDao.getOffers();
	}
	
	public void insert(Offer offer) {
		offerDao.insert(offer);
		
	}
}

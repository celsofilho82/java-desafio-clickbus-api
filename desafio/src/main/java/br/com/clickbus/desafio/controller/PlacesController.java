package br.com.clickbus.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.clickbus.desafio.repository.PlaceRepository;

@RestController
@RequestMapping("/places")
public class PlacesController {

	@Autowired
	private PlaceRepository placeRepository;
	
}

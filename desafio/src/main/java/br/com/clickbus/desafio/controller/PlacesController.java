package br.com.clickbus.desafio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.clickbus.desafio.controller.dto.PlaceDTO;
import br.com.clickbus.desafio.controller.dto.PlaceDetailsDTO;
import br.com.clickbus.desafio.model.Place;
import br.com.clickbus.desafio.repository.PlaceRepository;

@RestController
@RequestMapping("/places")
public class PlacesController {

	@Autowired
	private PlaceRepository placeRepository;

	@GetMapping
	public List<PlaceDTO> list(String name) {
		if (name == null) {
			List<Place> places = placeRepository.findAll();
			return PlaceDTO.convert(places);
		} else {
			List<Place> places = placeRepository.findByName(name);
			return PlaceDTO.convert(places);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<PlaceDetailsDTO> view(@PathVariable Long id) {

		Optional<Place> place = placeRepository.findById(id);

		if (place.isPresent()) {
			return ResponseEntity.ok(new PlaceDetailsDTO(place.get()));
		}

		return ResponseEntity.notFound().build();
	}
}

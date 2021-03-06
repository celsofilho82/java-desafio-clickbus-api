package br.com.clickbus.desafio.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.clickbus.desafio.controller.dto.PlaceDTO;
import br.com.clickbus.desafio.controller.dto.PlaceDetailsDTO;
import br.com.clickbus.desafio.controller.form.PlaceForm;
import br.com.clickbus.desafio.controller.form.UpdatePlaceForm;
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
	public ResponseEntity<PlaceDetailsDTO> show(@PathVariable Long id) {

		Optional<Place> place = placeRepository.findById(id);

		if (place.isPresent()) {

			return ResponseEntity.ok(new PlaceDetailsDTO(place.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<PlaceDTO> create(@RequestBody @Valid PlaceForm form, UriComponentsBuilder uriBuilder) {

		Place place = form.converter();

		placeRepository.save(place);

		URI uri = uriBuilder.path("/places/{id}").buildAndExpand(place.getId()).toUri();

		return ResponseEntity.created(uri).body(new PlaceDTO(place));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PlaceDTO> update(@PathVariable Long id, @RequestBody @Valid UpdatePlaceForm form) {

		Optional<Place> optional = placeRepository.findById(id);

		if (optional.isPresent()) {
			Place place = form.update(id, placeRepository);

			return ResponseEntity.ok(new PlaceDTO(place));
		}

		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Optional<Place> optional = placeRepository.findById(id);

		if (optional.isPresent()) {
			placeRepository.deleteById(id);

			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

}

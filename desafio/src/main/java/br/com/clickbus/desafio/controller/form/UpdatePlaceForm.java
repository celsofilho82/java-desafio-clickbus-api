package br.com.clickbus.desafio.controller.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.clickbus.desafio.model.Place;
import br.com.clickbus.desafio.repository.PlaceRepository;

public class UpdatePlaceForm {

	@NotNull
	@NotEmpty
	private String name;

	@NotNull
	@NotEmpty
	private String city;

	@NotNull
	@NotEmpty
	private String state;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Place update(Long id, PlaceRepository placeRepository) {
		Place place = placeRepository.getOne(id);
		place.setName(this.name);
		place.setCity(this.city);
		place.setState(this.state);
		place.setUpdatedAt(LocalDateTime.now());

		return place;
	}

}

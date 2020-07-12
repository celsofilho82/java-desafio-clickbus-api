package br.com.clickbus.desafio.controller.dto;

import java.time.LocalDateTime;

import br.com.clickbus.desafio.model.Place;

public class PlaceDetailsDTO {

	private Long id;
	private String name;
	private String city;
	private String state;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public PlaceDetailsDTO(Place place) {

		this.id = place.getId();
		this.name = place.getName();
		this.city = place.getCity();
		this.state = place.getState();
		this.createdAt = place.getCreatedAt();
		this.updatedAt = place.getUpdatedAt();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

}

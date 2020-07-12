package br.com.clickbus.desafio.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.clickbus.desafio.model.Place;

public class PlaceDTO {

	private Long id;
	private String name;
	private String city;
	private String state;

	public PlaceDTO(Place place) {

		this.id = place.getId();
		this.name = place.getName();
		this.city = place.getCity();
		this.state = place.getState();

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
	
	public static List<PlaceDTO> convert(List<Place> places){
		
		return places.stream().map(PlaceDTO::new).collect(Collectors.toList());
	}

}

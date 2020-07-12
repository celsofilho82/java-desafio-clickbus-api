package br.com.clickbus.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clickbus.desafio.model.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {

	List<Place> findByName(String name);

}

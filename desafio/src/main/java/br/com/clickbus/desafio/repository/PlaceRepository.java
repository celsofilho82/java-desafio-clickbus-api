package br.com.clickbus.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clickbus.desafio.model.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {

}

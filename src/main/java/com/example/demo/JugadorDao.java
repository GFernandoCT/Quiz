package com.example.demo;

import java.util.List;
import java.util.Optional;

public interface JugadorDao {

	int count();
	int save(Jugador jugador);
	int update(Jugador jugador);
	int deleteById(Long id);
	List<Jugador> findAll();
	List<Jugador> findByNameAndPrice(String name, int puntuacion);
	Optional<Jugador> findById(Long id);
	String getNameById(Long id);
	List<Jugador> findLast();

}

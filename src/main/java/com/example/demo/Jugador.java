package com.example.demo;

import java.util.List;

public class Jugador {
	private Long id;
	private String name;
	private int puntuacion;
	
	
	public Jugador(Long id, String name, int puntuacion) {
		this.id = id;
		this.name = name;
		this.puntuacion = puntuacion;
	}


	public Jugador(List<String> messages, int puntos) {
		this.name=messages.get(0);
		this.puntuacion=puntos;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPuntuacion() {
		return puntuacion;
	}


	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	
}

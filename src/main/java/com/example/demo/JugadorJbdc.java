package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JugadorJbdc implements JugadorDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int count() {
		return jdbcTemplate.queryForObject("select count(*) from jugadores",Integer.class);
	}

	@Override
	public int save(Jugador jugador) {
		return jdbcTemplate.update("insert into jugadores (name, puntuacion) values(?,?)", jugador.getName(), jugador.getPuntuacion());
	}

	@Override
	public int update(Jugador jugador) {
		return jdbcTemplate.update("update jugadores set puntuacion = ? where id = ?", jugador.getPuntuacion(), jugador.getId());
	}

	@Override
	public int deleteById(Long id) {
		return jdbcTemplate.update("delete from jugadores where id = ?", id);
	}

	@Override
	public List<Jugador> findAll() {
		return jdbcTemplate.query("select * from jugadores",
				(rs, rowNum) -> new Jugador(rs.getLong("id"), rs.getString("name"), rs.getInt("puntuacion")));
	}

	@Override
	public List<Jugador> findByNameAndPrice(String name, int puntuacion) {
		return jdbcTemplate.query("select * from books where name like ? and puntuacion <= ?",
				new Object[] { "%" + name + "%", puntuacion },
				(rs, rowNum) -> new Jugador(rs.getLong("id"), rs.getString("name"), rs.getInt("puntuacion")));
	}

	@Override
	public Optional<Jugador> findById(Long id) {
		return jdbcTemplate.queryForObject("select * from books where id = ?", new Object[] { id }, (rs,
				rowNum) -> Optional.of(new Jugador(rs.getLong("id"), rs.getString("name"), rs.getInt("puntuacion"))));
	}

	@Override
	public String getNameById(Long id) {
		return jdbcTemplate.queryForObject("select name from books where id = ?", new Object[] { id }, String.class);
	}

}

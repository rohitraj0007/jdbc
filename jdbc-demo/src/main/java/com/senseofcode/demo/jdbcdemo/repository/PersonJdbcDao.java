package com.senseofcode.demo.jdbcdemo.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.senseofcode.demo.jdbcdemo.entity.Person;
import com.senseofcode.demo.jdbcdemo.mapper.PersonRowMapper;

@Repository
public class PersonJdbcDao {

	@Autowired
	JdbcTemplate jdbcTemplate;// spring provides

// select * from person
	public List<Person> findAll() {
		return jdbcTemplate.query("Select * from person", new BeanPropertyRowMapper<Person>(Person.class));

	}

// select person by id
	public Person findById(int id) {
		return jdbcTemplate.queryForObject("Select * from person where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));

	}

	// delete person by id
	public int deleteById(int id) {
		return jdbcTemplate.update("delete from person where id=?", new Object[] { id });

	}

	// insert into  person by 
	public int insertIntoPerson(Person person) {
		return jdbcTemplate.update("insert into person\r\n" + 
				"(id,name,location,birth_date)\r\n" + 
				"values(?,?,?,?);", new Object[] { person.getId(),person.getName(),person.getLocation(),new Timestamp(person.getBirthDate().getTime())});

	}
	
	// select person by id using customRowMapper
		public Person findByIdUsingCustomeRowMapper(int id) {
			return jdbcTemplate.queryForObject("Select * from person where id=?", new Object[] { id },
					new PersonRowMapper());

		}
	
	// update person
		public int updatePerson(Person person) {
			return jdbcTemplate.update("update person\r\n" + 
					"set name = ?, location =? " +
					"where id = ? ", new Object[] {person.getName(),person.getLocation(), person.getId()});

		}
}

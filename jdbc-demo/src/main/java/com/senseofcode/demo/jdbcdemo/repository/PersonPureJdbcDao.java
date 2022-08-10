package com.senseofcode.demo.jdbcdemo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.senseofcode.demo.jdbcdemo.entity.Person;

@Component
public class PersonPureJdbcDao {
	
	@Autowired
	DataSource dataSource;

// select * from person
	/*
	 * using pure jdbc without spring
	 */
	public List<Person> findAll() throws SQLException {
		List<Person>  persons = new ArrayList<Person>();
		try(Connection connection = dataSource.getConnection()){
		
		PreparedStatement statement= connection.prepareStatement("Select * from person");
		
		ResultSet resultSet = statement.executeQuery();
		
		
		
		while(resultSet.next()) {
			Person person = new Person(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("location"),resultSet.getDate("birth_date"));
			persons.add(person);
		}
		
		
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
		return persons;
	}
}

		
	




package com.senseofcode.demo.jdbcdemo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.senseofcode.demo.jdbcdemo.entity.Person;
import com.senseofcode.demo.jdbcdemo.repository.PersonJdbcDao;
import com.senseofcode.demo.jdbcdemo.repository.PersonPureJdbcDao;

@SpringBootApplication
public class JdbcDemoApplication implements CommandLineRunner {

	
	@Autowired
	PersonJdbcDao personJdbcDao;
	
	@Autowired
	PersonPureJdbcDao personPureJdbcDao ;
	public static void main(String[] args) {
		SpringApplication.run(JdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(personJdbcDao.findAll());
		System.out.println(personJdbcDao.findById(10002));
		System.out.println(personJdbcDao.deleteById(10002));
		System.out.println(personJdbcDao.insertIntoPerson(new Person(10004,"Siyaldah","Amit",new Date())));
		System.out.println(personJdbcDao.updatePerson(new Person(10004,"Siyalda","Amit Chowdhary",new Date())));
		System.out.println(personJdbcDao.findByIdUsingCustomeRowMapper(10004));
		System.out.println(personPureJdbcDao.findAll());
		
	}

}

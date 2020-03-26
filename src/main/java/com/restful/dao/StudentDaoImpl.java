package com.restful.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.restful.model.Student;


public class StudentDaoImpl implements StudentDao
{

	private DataSource ds;
	private JdbcTemplate jdbcTemplate;
	public String insertSQL = "insert into student (id, name, email, age) values(?,?,?,?)";

	public void setDs(DataSource ds) {
		this.ds = ds;
	}

	public Student getStudentById(int id) {
		jdbcTemplate = new JdbcTemplate(ds);

		Student std = jdbcTemplate.queryForObject("select *from student where id =?", new Object[] {id}, new StudentRowmapper());
		return std;
	}

	public int insertStudent(Student student) {
		jdbcTemplate = new JdbcTemplate(ds);
		return jdbcTemplate.update(insertSQL, new Object[] {student.getId(), student.getName(), student.getEmail(), student.getAge()});

	}

	public List<Student> getAllStudents() {
		jdbcTemplate = new JdbcTemplate(ds);
		List<Student> studentList = jdbcTemplate.query("select *from student", new StudentRowmapper());
		return studentList;
	}



}

package com.restful.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.restful.model.Student;

public class StudentRowmapper implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student std = new Student();
		std.setId(rs.getInt("id"));
		std.setName(rs.getString("name"));
		std.setEmail(rs.getString("email"));
		std.setAge(rs.getInt("age"));
		return std;
	}



}

package com.restful.dao;

import java.util.List;

import com.restful.model.Student;

public interface StudentDao {

	Student getStudentById(int id);
	int insertStudent(Student student);
	List<Student> getAllStudents();

}

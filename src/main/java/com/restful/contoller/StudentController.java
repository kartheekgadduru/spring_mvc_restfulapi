package com.restful.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restful.dao.StudentDao;
import com.restful.model.Student;

@RestController
public class StudentController {


	@Autowired
	StudentDao studentDao;
	@RequestMapping("/getStudent/{id}")

	public  Student getStudentById(@PathVariable("id") int id) {

		return studentDao.getStudentById(id);
	}


	@RequestMapping("/getStudentList")

	public List<Student> getAllStudends(){
		return studentDao.getAllStudents();
	}
	@RequestMapping( value = "/saveStudent", method=RequestMethod.POST, produces = "application/json")
	public String saveStudent(@RequestBody Student student) {
		String message = null;
		int row = studentDao.insertStudent(student);
		if(row == 1) {
			message = row+" row has been inserted in database";
		}else {

			message ="someting went wrong";
		}

		return message;
	}





}

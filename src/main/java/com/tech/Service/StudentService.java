package com.tech.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.Entity.Student;
import com.tech.Repo.StudentRepo;

@Service
public class StudentService {
	@Autowired
	private StudentRepo studentrepo;
	

	public int addStudent(Student student) {
		return studentrepo.save(student).getSid();
	}

	public List<Student> getAllStudents() {
		return studentrepo.findAll();
	}

	public void deleteStudent(int sid) {
		studentrepo.deleteById(sid);
	}
	
	public Student getStudentById(int sid) {
		return studentrepo.findById(sid).orElse(null);
		
	}
	public void updateStudent(Student student) {
		studentrepo.save(student);
	}
	
}

package com.tech.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tech.Entity.Student;
import com.tech.Service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentservice;

	@GetMapping("/addStudent")
	public String addStudent(Model model) {
		model.addAttribute("cat", new Student());
		return "home";
	}

	@PostMapping("/createStudentDetails")
	public String createStudentDetails(@ModelAttribute("cat") Student student, Model model) {
		int savestudent = studentservice.addStudent(student);
		model.addAttribute("abc", savestudent);
		return "house";
	}

	@GetMapping("/saveStudentDetails")
	public String getAllStudents(Model model) {
		List<Student> allStudents = studentservice.getAllStudents();
		model.addAttribute("car", allStudents);
		return "india";
	}

	@GetMapping("/deleteStudent/{sid}")
	public String deleteStudent(@PathVariable int sid) {
		studentservice.deleteStudent(sid);
		return "redirect:/saveStudentDetails";
	}
	
	@GetMapping("/editStudent/{sid}")
	public String editStudent(@PathVariable("sid") int sid,Model model) {
		Student studentById = studentservice.getStudentById(sid);
		model.addAttribute("zebra", studentById);
		return "update";
	}
	
	@PostMapping("/updateStudent/{sid}")
	public String updateStudentDetails(@ModelAttribute("zebra")Student student,Model model) {
		studentservice.updateStudent(student);
		return "redirect:/saveStudentDetails";
	}
}

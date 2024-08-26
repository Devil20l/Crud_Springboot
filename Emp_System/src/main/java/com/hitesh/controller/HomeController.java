package com.hitesh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hitesh.Entity.Employee;
import com.hitesh.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private EmpService empservice;

	@GetMapping("/")
	public String index(Model m) {

		List<Employee> list = empservice.getAllEmp();
		m.addAttribute("empList", list);
		return "index";

	}

	@GetMapping("/LoadEmpSave")
	public String loadempSave() {
		return "emp_save";

	}

	@GetMapping("/EditEmp/{id}")
	public String EditEmp(@PathVariable int id, Model m) {

		Employee emp = empservice.getEmpById(id);
		m.addAttribute("emp", emp);
		return "edit_emp";

	}

	@PostMapping("/saveEmp")
	public String saveEmp(@ModelAttribute Employee emp, HttpSession session) {

		Employee Newemp = empservice.save(emp);

		if (Newemp != null) {
			session.setAttribute("msg", "Register sucessfully");
		} else {

			session.setAttribute("msg", "Somwthing wrong  on server ");

		}
		return "redirect:/LoadEmpSave";

	}

	@PostMapping("/UpdateEmpDtls")
	public String updateEmp(@ModelAttribute Employee emp, HttpSession session) {

		Employee updateemp = empservice.save(emp);

		if (updateemp != null) {
			session.setAttribute("msg", "Update sucessfully");
		} else {

			session.setAttribute("msg", "Somwthing worng on server");

		}
		return "redirect:/";

	}

	@GetMapping("/deleteEmp/{id}")
	public String deleteEmp(@PathVariable int id, HttpSession session) {

		boolean f = empservice.deleteEmp(id);

		if (f) {
			session.setAttribute("msg", " Delete sucessfully");
		} else {
			session.setAttribute("msg", " Somwthing worng on server");
		}
		return "redirect:/";

	}
}

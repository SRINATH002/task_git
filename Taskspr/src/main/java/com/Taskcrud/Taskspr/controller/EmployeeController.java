 package com.Taskcrud.Taskspr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Taskcrud.Taskspr.model.Employee;
import com.Taskcrud.Taskspr.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@GetMapping("/")
	public String home()
	{
	   return "main";
	}
	@GetMapping("/index")
	public String viewHomePage(Model model)
	{
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "index";
	}
	  
	@GetMapping("/shownewEmployeeFrom")
	public String showNewEmployeeForm(Model model)
	{
		Employee employee=new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")	
	public String saveEmployee(@ModelAttribute("employee")Employee employee)
	{
		employeeService.saveEmployee(employee);
		return "redirect:/index";
	}
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value="id")long id,Model model)
	{
		Employee employee=employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "update_employee";
	}
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value="id")long id)
	{
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/index";
	}

}

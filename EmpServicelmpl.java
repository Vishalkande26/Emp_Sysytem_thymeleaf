package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmpRepository;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class EmpServicelmpl implements EmpService {

	@Autowired
	private EmpRepository empRepo;

	
	public Employee saveEmp(Employee emp) {
		Employee newEmp = empRepo.save(emp);
		return newEmp;
	}

	
	public List<Employee> getAllEmp() {

		return empRepo.findAll();
	}

	
	public Employee getEmpById(int id) {
		return empRepo.findById(id).get();
	}

	
	public boolean deleteEmp(int id) {
		Employee emp = empRepo.findById(id).get();
		if (emp != null) {
			empRepo.delete(emp);
			return true;
		}
		return false;
	}

	public void removeSessionMessage() {
		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
				.getSession();

		session.removeAttribute("msg");

	}

}

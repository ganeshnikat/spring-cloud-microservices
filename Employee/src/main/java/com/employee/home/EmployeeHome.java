package com.employee.home;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employee")
public class EmployeeHome {

	@Autowired
	Environment env;
	
	@RequestMapping("/get-employee-details/{employeeName}")
	public Map<String, String> getEmployeeDetails(@PathVariable("employeeName") String name) throws Exception {

		Map<String, String> employeeMap = new HashMap<>();

		employeeMap.put("employeeName", name);
		employeeMap.put("ApplicationName", env.getProperty("spring.application.name"));
		employeeMap.put("hostName", InetAddress.getLocalHost().getHostName());
		employeeMap.put("hostAddress", InetAddress.getLocalHost().getHostAddress());
		employeeMap.put("port", env.getProperty("server.port"));
	    
		return employeeMap;
	}
}
